import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Class responsible for managing applications.
 * @author FYTTAN001, LXXWEN005, MCKROB018
 */
public class ApplicationController {
	private Application application;
	private ArrayList<File> files;
	private DataReaderWriter dataAccess;
	
	
	/**
	 * Method creates a controller object responsible for managing applications.
	 */
	public ApplicationController()
	{
		application = null; //no application have yet been created or selected
		files = new ArrayList<File>(); //no file have yet been included
	}
	
	/**
	 * Method creates a controller object responsible for managing applications, while enabling database access.
	 * @param data Specified data to be used by the controller.
	 */
	public ApplicationController(DataReaderWriter data)
	{
		this();
		dataAccess = data;
	}
	
	/**
	 * Method fetches application belonging to the specified applicant.
	 * @param applicantNumber Specified applicant number of the applicant whose application needs to be fetched
	 * @return the application of the specified applicant
	 */
	public Application getApplicationOfApplicant(String applicantNumber)
	{
		
		return dataAccess.getApplicationOfApplicant(applicantNumber); //see DataReaderWriter
	}
	
	/**
	 * Method makes the provided application the application of focus.
	 * @param application The specified application that is of focus.
	 */
	public void setApplicationOfFocus(Application application)
	{
		this.application = application;
	}
	
	/**
	 * Method checks if the applicant has already an application in the system.
	 * @param applicantNumber Specified applicant number of the applicant of focus.
	 * @return Whether the applicant does not yet have an application in the system.
	 */
	public boolean noExistingApplication(String applicantNumber)
	{
		return dataAccess.getApplicationOfApplicant(applicantNumber).equals(null); 
	}
	
	/**
	 * Creates a new application for the applicant of focus.
	 * @param applicantNumber Applicant number of the applicant of focus.
	 * @return New application for the applicant with the "Created" status.
	 */
	public Application createNewApplication(String applicantNumber)
	{
		application = new Application(applicantNumber);
		int applicationNumber = dataAccess.getMaxApplicationNumber() + 1;
		application.setApplicationNumber(String.valueOf(applicationNumber));
		return application;
	}
	
	/**
	 * Submits the specified application.
	 * @param anApplication Specified application to submit.
	 * @return Whether application was successfully submitted or not.
	 */
	public boolean submitApplication(Application anApplication)
	{
		anApplication.setApplicationStatus(new ApplicationStatus("Applied", "Applicant submitted application"));
		dataAccess.getApplicantApplicationRefByApplication(anApplication.getApplicationNumber()).setApplicationRef(anApplication);
		return true;
	}
	
	/**
	 * Updates data with permanent application changes.
	 * @param anApplication Specified application that will result in permanent changes to the data.
	 * @return Whether the insert or update was successful or not.
	 */
	public boolean insertOrUpdateApplication(Application anApplication)
	{
		dataAccess.updateApplicationRecord((dataAccess.getApplicantApplicationRefByApplication(anApplication.getApplicationNumber())));
		return true;
	}
	
	/**
	 * Uploads single PDF of details that applicant provides.
	 * @param applicationNumber The application number of the application for which the PDF is being uploaded.
	 * @param pdfName Specified name of the the pdf file to be uploaded.
	 * @return Whether the PDF was uploaded successfully or not.
	 */
	public boolean uploadPDF(String applicationNumber, String pdfName)
	{
		files.trimToSize();
		File file = null; //Get file from list
		for (int i=0; i<files.size(); i++) {
			if (files.get(i).getName().equalsIgnoreCase(pdfName)) {
				file = files.get(i);
				break;
			}
		}
		if (file!=null) {
			FileExtensionFilter fef = new FileExtensionFilter("pdf");
			if (!fef.accept(file)) {
				return false;
			}
			return dataAccess.writePDFtoDB(file, applicationNumber);
		}
		return false;
	}
	
	/**
	 * Method adds chosen pdf file to file list so that it can be uploaded upon request.
	 * @param file Specified file to be uploaded.
	 */
	public void chosenPDF(File file)
	{
		files.add(file);
	}
	
	/**
	 * Allows academic to download single PDF of required documentation. Makes call to DataReaderWriter to fulfill request.
	 * @param applicantNumber Number of applicant whose PDF will be downloaded.
	 * @param dest Destination to which the PDF should be saved.
	 * @return Whether the file was successfully downloaded or not.
	 */
	public boolean downloadPDF(String applicationNumber, File dest)
	{
		FileExtensionFilter fef = new FileExtensionFilter("pdf");
		if (!fef.accept(dest)) {
			return false;
		}
		return dataAccess.readPDFfromDB(dest, applicationNumber);
	}
	
	/**
	 * Checks whether application is still in editable state.
	 * @param applicationNumber Specified application for checking if still in editable state
	 * @return Whether application is still in an editable state.
	 */
	public boolean applicationEditable(String applicationNumber)
	{
		String status = dataAccess.getApplicantApplicationRefByApplication(applicationNumber).getApplicationRef().getApplicationStatus().getStatusDescripition();
		status = status.trim();
		return (status.equals("Created") || status.equals("Applied") || status.equals("Decision Deffered") || status.equals("On Waiting List") || status.equals("Firm Offer Deferred"));
	}
	
	/**
	 * Method fetches details of study program that has been specified by its name.
	 * @param studyProgramName Specified name of the study program to fetch.
	 * @return The study program with the specified name.
	 */
	public StudyProgram getStudyProgram(String studyProgramName)
	{
		return new StudyProgram(studyProgramName);
	}
	
	/**
	 * Checks if application is still in viewable state.
	 * @param applicationNumber Specified application to check for viewable state.
	 * @return Whether the application is still in a viewable state.
	 */
	public boolean applicantionViewable(String applicationNumber)
	{
		String status = dataAccess.getApplicantApplicationRefByApplication(applicationNumber).getApplicationRef().getApplicationStatus().getStatusDescripition();
		status = status.trim();
		return (!status.equals("Withdrawn"));
	}
	
	/**
	 * Creates a PDF of applicant/application details and saves it to the specified location.
	 * @param applicantNumber Applicant to generate details for.
	 * @param applicationNumber Specified application to generate details for.
	 * @param fileToSave Specified file, i.e. the PDF file.
	 * @return Whether the request failed or succeeded.
	 */
	public boolean requestPDFofApplicantDetails(String applicantNumber, String applicationNumber, File fileToSave)
	{
		FileExtensionFilter fef = new FileExtensionFilter("pdf");
		if (!fef.accept(fileToSave)) {
			return false;
		}
		Applicant applicant = dataAccess.getApplicantApplicationRefByApplicant(applicantNumber).getApplicantRef();
		Application application = dataAccess.getApplicantApplicationRefByApplicant(applicantNumber).getApplicationRef();
		Document document = new Document();
		try { 
			PdfWriter.getInstance(document, new FileOutputStream(fileToSave.getAbsolutePath())).setInitialLeading(16);
			document.open();
			Font fontA = FontFactory.getFont(FontFactory.COURIER, 16, Font.BOLD, BaseColor.BLACK);
			Font fontB = FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, BaseColor.BLACK);
			Font fontC = FontFactory.getFont(FontFactory.COURIER, 12, BaseColor.BLACK);
			Font fontCB = FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLD, BaseColor.BLACK);
			SimpleDateFormat df = new SimpleDateFormat("dd MMMMMMMMM yyyy");
			document.add(new Chunk("University of Cape Town School of IT", fontA));
			document.add(Chunk.NEWLINE);
			document.add(new Chunk("Application Details for Application " + applicationNumber + 
					" made by Applicant " + applicantNumber, fontCB));
			document.add(Chunk.NEWLINE);
			document.add(new Chunk("Information retrieved on " + df.format(new Date()), fontC));
			document.add(Chunk.NEWLINE);
			document.add(new Chunk(" ", fontC));
			document.add(Chunk.NEWLINE);
			document.add(new Chunk("Applicant Details:", fontB));
			document.add(Chunk.NEWLINE);
			document.add(new Chunk("Full Name: " + applicant.getTitle() + " "  + applicant.getFirstName() + " " + applicant.getSurname(), fontC));
			document.add(Chunk.NEWLINE);
			document.add(new Chunk("Citizenship: " + applicant.getCitizenship() , fontC));
			if (applicant instanceof InternationalApplicant) {
				document.add(Chunk.NEWLINE);
				document.add(new Chunk("Country: " + applicant.getCitizenshipCountry() , fontC));
				document.add(Chunk.NEWLINE);
				document.add(new Chunk("Passport Number: " + ((InternationalApplicant) applicant).getPassport() , fontC));
			} else { 
				document.add(Chunk.NEWLINE);
				document.add(new Chunk("ID Number: " + ((SouthAfricanApplicant) applicant).getID() , fontC));
				document.add(Chunk.NEWLINE);
				document.add(new Chunk("Race: " + ((SouthAfricanApplicant) applicant).getRace() , fontC));
			}
			document.add(Chunk.NEWLINE);
			document.add(new Chunk("Email Address: " + applicant.getEmail() , fontC));
			document.add(Chunk.NEWLINE);
			document.add(new Chunk("Cellphone Number: " + applicant.getCellPhone() , fontC));
			document.add(Chunk.NEWLINE);
			document.add(new Chunk("Address: " + applicant.getResidenceAddress().getLineAddress() + ", " + applicant.getResidenceAddress().getCountry(), fontC));
			
			StudyProgram sp = application.getStudyProgram();
			document.add(Chunk.NEWLINE);
			document.add(new Chunk(" ", fontC));
			document.add(Chunk.NEWLINE);
			document.add(new Chunk("Application Details:", fontB));
			document.add(Chunk.NEWLINE);
			document.add(new Chunk("Study Program: " + sp.getAcademicQualification(), fontC));
			document.add(Chunk.NEWLINE);
			document.add(new Chunk("Qualification Level: " + sp.getQualificationLevel(), fontC));
			document.add(Chunk.NEWLINE);
			document.add(new Chunk("Specialisation or Major: " + sp.getSpecialisationOrMajor(), fontC));
			ApplicationStatus as = application.getApplicationStatus();
			document.add(Chunk.NEWLINE);
			document.add(new Chunk("Current Application Status: " + as.getStatusDescripition(), fontC));
			document.add(Chunk.NEWLINE);
			document.add(new Chunk("Reason for Application Status: " + as.getReasonDescription(), fontC));
			
			TertiaryQualification tq = applicant.getPreviousQualification();
			document.add(Chunk.NEWLINE);
			document.add(new Chunk(" ", fontC));
			document.add(Chunk.NEWLINE);
			document.add(new Chunk("Applicant Experience and Previous Qualifications:", fontB));
			document.add(Chunk.NEWLINE);
			document.add(new Chunk("Previous Degree: " + tq.getDegree(), fontC));
			document.add(Chunk.NEWLINE);
			document.add(new Chunk("Equivalent NQF Value of degree: " + tq.getNQFEquivalence(), fontC));
			document.add(Chunk.NEWLINE);
			document.add(new Chunk("Minimum Years in which degree can be obtained: " + tq.getMinDuration(), fontC));
			document.add(Chunk.NEWLINE);
			document.add(new Chunk("Tertiary Institution where degree was obtained: " + tq.getTertiaryInstitution(), fontC));
			document.add(Chunk.NEWLINE);
			document.add(new Chunk("Country where degree was obtained: " + tq.getCountry(), fontC));
			if (tq instanceof TertiaryQualificationForMIT) {
				TertiaryQualificationForMIT tqm = (TertiaryQualificationForMIT) tq;
				document.add(Chunk.NEWLINE);
				document.add(new Chunk("Prior IT Experience (in years): " + tqm.getPriorITExperience(), fontC));
				document.add(Chunk.NEWLINE);
				document.add(new Chunk("Level of Undergraduate Mathematics Completed: " + tqm.getHighestLevelUndergradMathematcs(), fontC));
				for (int i = 0; i < tqm.getHighestLevelUndergradMathematcs(); ++i) {
					document.add(Chunk.NEWLINE);
					document.add(new Chunk("Average for Year " + (i+1) + ": " + tqm.getUndergradMaths()[i].getAverage(), fontC));
				} if (tqm.hasProjectThesis()) {
					document.add(Chunk.NEXTPAGE);
					document.add(new Chunk("Description of Project Thesis of Previous Degree", fontB));
					document.add(Chunk.NEWLINE);
					document.add(new Chunk(" ", fontC));
					document.add(Chunk.NEWLINE);
					document.add(new Paragraph(tqm.getDescriptionProjectThesis(), fontC));
				}
			}
			document.close();
		} catch (DocumentException | FileNotFoundException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Populates the table with application information.
	 * @param model Specified table model that needs to be populated.
	 * @return The populated table model.
	 */
	public DefaultTableModel populateApplicationsTable(DefaultTableModel model, ArrayList<ApplicantApplicationReference> applicationRefererences)
	{
		model.setRowCount(0);
		String[] cellValues = new String[6];
		
		applicationRefererences.trimToSize();
		
		cellValues[0] = "Application Number";
		cellValues[1] = "Applicant Number"; 
		cellValues[2] = "Application Status"; 
		cellValues[3] = "Prev Degree"; 
		cellValues[4] = "Obtained in";
		cellValues[5] = "Applied For";
		model.addRow(cellValues);
		
		for (int i=0; i<applicationRefererences.size();i++)
		{
			cellValues[0] = applicationRefererences.get(i).getApplicationRef().getApplicationNumber();
			cellValues[1] = applicationRefererences.get(i).getApplicantRef().getApplicantNumber();
			cellValues[2] = applicationRefererences.get(i).getApplicationRef().getApplicationStatus().getStatusDescripition();
			cellValues[3] = applicationRefererences.get(i).getApplicantRef().getPreviousQualification().getDegree();
			cellValues[4] = applicationRefererences.get(i).getApplicantRef().getPreviousQualification().getCountry();
			cellValues[5] = applicationRefererences.get(i).getApplicationRef().getStudyProgram().getAcademicQualification();
		
			model.addRow(cellValues);
		}
		
		return model;
	}
	
	/**
	 * Method adds chosen csv file to file list so that it can be processed upon request.
	 * @param file Specified file to be processed.
	 */
	public void chosenCSV(File file)
	{
		files.add(file);
	}
	
	/**
	 * Extracts information from the csv file provided.
	 * @param csvName Specified name of the csv file
	 * @return whether csv file has been successfully extracted and all applicants have been notified.
	 */
	public boolean notifyApplicants(File csvfile)
	{
		Scanner csvApplicantsList = null;
		try
		{
			csvApplicantsList = new Scanner(new FileReader(csvfile));
					
			csvApplicantsList.nextLine();
			
			while (csvApplicantsList.hasNext())
			{
				String[] applicantRow = csvApplicantsList.nextLine().split(","); //extract potential applicant from list
				String firstName = applicantRow[6]; //extract first name
				String lastName = applicantRow[5]; //extract last name
				String applicantNumber = applicantRow[1]; //extract applicant number
				String email = applicantNumber + "@myUCT.ac.za"; //E-mail 
				boolean result = notifyApplicant(firstName,lastName, applicantNumber, email); //notify potential applicant
				if (!result) return false;
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return false;
		}
		finally
		{
			if (csvApplicantsList != null)
			{
				csvApplicantsList.close();
			}
		}
		return true;
	}
	
	/**
	 * Filters list by studyProgram, level and application status
	 * @param studyProgram Specified study program by which to filter list.
	 * @param level Specified level by which to filter list
	 * @param applicationStatus Specified application status by which to filter the list
	 * @return filtered list
	 */
	public ArrayList<ApplicantApplicationReference> getFilteredList(String studyProgram, String level, String applicationStatus)
	{
		if(studyProgram.equals("%") && level.contentEquals("%") && applicationStatus.equals("%"))
		{
			return dataAccess.getApplicantsAndTheirApplications();
		}
		
		else if(!studyProgram.equals("%"))
		{
			return dataAccess.filterStudyProgram(studyProgram, applicationStatus);
		}
		
		else
		{
			return dataAccess.filterLevel(level, applicationStatus);
		}
	}

	/**
	 * Generates CSV file of the list of application details
	 * @param filteredApplicantList Specified list from which csv should be genereated
	 * @param fileToSave File specified by JFileChooser save dailog. 
	 * @return Whether the action was successful or not
	 */
	public boolean getFilteredApplicantListAsCSV(ArrayList<ApplicantApplicationReference> filteredApplicantList, File fileToSave)
	{
		String fullFilePathOfWhereToSaveFile = fileToSave.toString();
		PrintWriter writer = null;
		
		filteredApplicantList.trimToSize();
		if (filteredApplicantList.size() == 0) {return true;}
		
		try
		{
			if ((!(fullFilePathOfWhereToSaveFile.endsWith(".pdf")) && (!(fullFilePathOfWhereToSaveFile.contains("."))))) {fullFilePathOfWhereToSaveFile += ".csv";}
			writer = new PrintWriter(new File(fullFilePathOfWhereToSaveFile));
			
			filteredApplicantList.trimToSize(); 
			
			for (int i=0; i<filteredApplicantList.size(); i++)
			{
				String temp = filteredApplicantList.get(i).getApplicantRef().getSurname();
				temp += "," + filteredApplicantList.get(i).getApplicantRef().getFirstName();
				temp += "," + filteredApplicantList.get(i).getApplicantRef().getApplicantNumber();
				temp += "," + filteredApplicantList.get(i).getApplicantRef().getPassword();
				temp += "," + filteredApplicantList.get(i).getApplicantRef().getTitle();
				temp += "," + filteredApplicantList.get(i).getApplicantRef().getCitizenship();
				temp += "," + filteredApplicantList.get(i).getApplicantRef().getCitizenshipCountry();
				
				if (filteredApplicantList.get(i).getApplicantRef().getCitizenship().equalsIgnoreCase("International"))
				{
					temp += "," + ((InternationalApplicant) filteredApplicantList.get(i).getApplicantRef()).getPassport();
					temp += ",";
				}
				else if ((filteredApplicantList.get(i).getApplicantRef().getCitizenship().contains("South African")))
				{
					temp += "," + ((SouthAfricanApplicant) filteredApplicantList.get(i).getApplicantRef()).getID();
					temp += "," + ((SouthAfricanApplicant) filteredApplicantList.get(i).getApplicantRef()).getRace();
				}
				else
				{
					temp += ",,";
				}
				
				temp += "," + filteredApplicantList.get(i).getApplicantRef().getEmail();
				temp += "," + filteredApplicantList.get(i).getApplicantRef().getCellPhone();
				temp += "," + filteredApplicantList.get(i).getApplicantRef().getResidenceAddress().getLineAddress();
				temp += "," + filteredApplicantList.get(i).getApplicantRef().getResidenceAddress().getCountry();
				temp += "," + filteredApplicantList.get(i).getApplicantRef().getPreviousQualification().getDegree();
				temp += "," + filteredApplicantList.get(i).getApplicantRef().getPreviousQualification().getTertiaryInstitution();
				temp += "," + filteredApplicantList.get(i).getApplicantRef().getPreviousQualification().getCountry();
				temp += "," + String.valueOf(filteredApplicantList.get(i).getApplicantRef().getPreviousQualification().getMinDuration());
				temp += "," + filteredApplicantList.get(i).getApplicantRef().getPreviousQualification().getNQFEquivalence();
				
				if (filteredApplicantList.get(i).getApplicationRef().getStudyProgram().getAcademicQualification().contains("MIT"))
				{
					temp += "," + String.valueOf(((TertiaryQualificationForMIT) filteredApplicantList.get(i).getApplicantRef().getPreviousQualification()).getPriorITExperience());
					temp += "," + String.valueOf(((TertiaryQualificationForMIT) filteredApplicantList.get(i).getApplicantRef().getPreviousQualification()).getDescriptionProjectThesis());
					int MathLevel = ((TertiaryQualificationForMIT) filteredApplicantList.get(i).getApplicantRef().getPreviousQualification()).getHighestLevelUndergradMathematcs();
					temp += "," + String.valueOf(MathLevel);
					if (MathLevel > 0)
					{
						temp += "," + String.valueOf(((TertiaryQualificationForMIT) filteredApplicantList.get(i).getApplicantRef().getPreviousQualification()).getUndergradMaths()[0].getAverage());
					}
					else
					{
						temp += ",";
					}
					
					if (MathLevel > 1)
					{
						temp += "," + String.valueOf(((TertiaryQualificationForMIT) filteredApplicantList.get(i).getApplicantRef().getPreviousQualification()).getUndergradMaths()[1].getAverage());
					}
					else
					{
						temp += ",";
					}
					
					if (MathLevel > 2)
					{
						temp += "," + String.valueOf(((TertiaryQualificationForMIT) filteredApplicantList.get(i).getApplicantRef().getPreviousQualification()).getUndergradMaths()[2].getAverage());
					}
					else
					{
						temp += ",";
					}
				}
				else
				{
					temp += ",,,,,,";
				}
				
				temp += "," + filteredApplicantList.get(i).getApplicationRef().getApplicationNumber();
				temp += "," + filteredApplicantList.get(i).getApplicationRef().getStudyProgram().getAcademicQualification();
				temp += "," + filteredApplicantList.get(i).getApplicationRef().getApplicationStatus().getStatusDescripition();
				temp += "," + filteredApplicantList.get(i).getApplicationRef().getApplicationStatus().getReasonDescription();
				
				writer.println(temp);
			}
			
		}
		catch(IOException e)
		{
			return false;
		}
		finally
		{
			if (writer!=null)
			{
				writer.close();
			}
		}
		return true;
	}
	
	/**
	 * Sends an email to an applicant to confirm the email address.
	 * @param firstName First name of the potential applicant.
	 * @param lastName Last name of the potential applicant.
	 * @param applicantNumber Applicant number of the potential applicant.
	 * @param email Email address of the applicant.
	 * @return Whether the email was successfully sent or not.
	 */
	public boolean confirmEmail(String firstName, String lastName, String applicantNumber, String email)
	{
		//Get properties object
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		
		//get Session
		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("postgradtool@gmail.com","capstone2019");
					}
	          	});
  		//compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(email));
			message.setSubject("Email Confirmation - UCT School of IT");
			message.setText("Dear Applicant\n"
					+ "Thank you very much for signing up on the University of Cape Town School of IT "
					+ "internal applications system.\n"
					+ "Please click the link below to confirm your email address.\n"
					+ "\nwww.examplelink.co.za\n"
					+ "\nKind regards\n"
					+ "University of Cape Town School of IT\n"); 
			//send message
			Transport.send(message);
			System.out.println(firstName + " " + lastName + " (" + applicantNumber + ") has been sent an email confirmation"
					+ "link at this address: " + email);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Notifies a potential applicant by sending them an email.
	 * @param firstName First name of the potential applicant.
	 * @param lastName Last name of the potential applicant.
	 * @param applicantNumber Applicant number of the potential applicant.
	 * @param email Email address of the applicant.
	 * @return Whether the email was successfully sent or not.
	 */
	public boolean notifyApplicant(String firstName, String lastName, String applicantNumber, String email)
	{
		//Get properties object
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		
		//get Session
		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("postgradtool@gmail.com","capstone2019");
					}
	          	});
  		//compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(email));
			message.setSubject("Notification from UCT School of IT");
			message.setText("Dear " + firstName + " " + lastName + "\n"
					+ "Thank you very much for applying online for a Postgraduate Degree at the University of Cape Town.\n"
					+ "Please follow the link below to complete your application by applying directly to the School of IT.\n"
					+ "\nwww.examplelink.co.za\n"
					+ "\nKind regards\n"
					+ "University of Cape Town School of IT\n"); 
			//send message
			Transport.send(message);
			System.out.println(firstName + " " + lastName + " (" + applicantNumber + ") has been emailed at this address: " + email);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Method return file uploaded to tool as specified fileName
	 * @param fileName The specified name of the file to return
	 * @return File specified by its name.
	 */
	private File getFile(String fileName)
	{
		files.trimToSize();
		for (int i=0; i<files.size(); i++)
		{
			if (files.get(i).getName().equals(fileName)) {return files.get(i);}
		}
		return null;
	}
}
