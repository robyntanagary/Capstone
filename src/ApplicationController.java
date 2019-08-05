import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Class responsible for managing application
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
	 * Method creates a controller object responsible for managing applications, while enabling accesses to data
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
	 * @return whether the applicant does not yet have an application in the system.
	 */
	public boolean noExistingApplication(String applicantNumber)
	{
		return dataAccess.getApplicationOfApplicant(applicantNumber).equals(null); 
	}
	
	/**
	 * Creates a new application for the applicant of focus.
	 * @param applicantNumber Applicant number of the applicant of focus.
	 * @return an application for the applicant with the Created status.
	 */
	public Application createNewApplication(String applicantNumber)
	{
		application = new Application();
		int applicationNumber = dataAccess.getMaxApplicationNumber() + 1;
		application.setApplicationNumber(String.valueOf(applicationNumber));
		dataAccess.setApplicationOfApplicant(applicantNumber, application);
		return application;
	}
	
	/**
	 * Submits the specified application.
	 * @param anApplication Specified application to submit.
	 * @return whether application have successfully been submitted
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
	 * @return whether the insert or update have been successful.
	 */
	public boolean insertOrUpdateApplication(Application anApplication)
	{
		dataAccess.getApplicantApplicationRefByApplication(anApplication.getApplicationNumber()).setApplicationRef(anApplication);
		return true;
	}
	
	/**
	 * Uploads single pdf of documents that applicant provides.
	 * @param pdfName Specified name of the the pdf file.
	 * @return whether the uploading was successful.
	 */
	public boolean uploadPDF(String pdfName)
	{
		files.trimToSize();
		File file = null;
		for (int i=0; i<files.size(); i++)
		{
			if (files.get(i).getName().equalsIgnoreCase(pdfName))
			{
				file = files.get(i);
				break;
			}
		}
		
		if (file!=null)
		{
			FileExtensionFilter filter = new FileExtensionFilter(".pdf");
			if (filter.accept(file))
			{
				
			}
		}
		return false;
	}
	
	/**
	 * Method adds uploaded pdf file to file list so that it can be uploaded upon request.
	 * @param file Specified file to be uploaded.
	 */
	public void chosenPDF(File file)
	{
		files.add(file);
	}
	
	/**
	 * Allows academic to download single PDF of required documentation.
	 * @param pdfName Specified name of the PDF file
	 * @param fileToSave Specified file to save.
	 * @return
	 */
	public boolean downloadPDF(String applicantNumber, File fileToSave)
	{
		dataAccess.getApplicantApplicationRefByApplicant(applicantNumber).getApplicationRef().getPdfPath();
		String fullFilePathOfWhereToSaveFile = fileToSave.toString();
		
		return true;
	}
	
	/**
	 * Checks whether application is still in editable state.
	 * @param applicationNumber Specified application for checking if still in editable state
	 * @return whether application is still in an editable state.
	 */
	public boolean applicantionEditable(String applicationNumber)
	{
		String status = dataAccess.getApplicantApplicationRefByApplication(applicationNumber).getApplicationRef().getApplicationStatus().getStatusDescripition();
		status = status.trim();
		return (status.equals("Created") || status.equals("Applied") || status.equals("Decision Deffered") || status.equals("On Waiting List") || status.equals("Firm Offer Deferred"));
	}
	
	/**
	 * Method fetches details of study programme that has been specified by its name.
	 * @param studyProgramName Specified name of the study programme to fetch.
	 * @return the study programme with the specified name.
	 */
	public StudyProgram getStudyProgram(String studyProgramName)
	{
		return new StudyProgram(studyProgramName);
	}
	
	/**
	 * Checks if application is still in viewable state.
	 * @param applicationNumber Specified application to check for viewable state.
	 * @return whether the application is still in a viewable state.
	 */
	public boolean applicantionViewable(String applicationNumber)
	{
		String status = dataAccess.getApplicantApplicationRefByApplication(applicationNumber).getApplicationRef().getApplicationStatus().getStatusDescripition();
		status = status.trim();
		return (!status.equals("Withdrawn"));
	}
	
	/**
	 * Allows academic to download a single PDF of application details.
	 * @param applicantNumber Specified applicant 
	 * @param application Specified application (application number)
	 * @param fileToSave Specified file, i.e. the PDF file
	 * @return the PDF file of applicant details
	 */
	public boolean requestPDFofApplicantDetails(String applicantNumber, String application, File fileToSave)
	{
		String fullFilePathOfWhereToSaveFile = fileToSave.toString();
		//needs logic! -maybe you can copy some code from the DataReaderWriter class
		return true;
	}
	
	/**
	 * Populates the table with application information
	 * @param model Specified table model that needs to be populated
	 * @return the populated table model
	 */
	public DefaultTableModel populateApplicationsTable(DefaultTableModel model)
	{
		ArrayList<ApplicantApplicationReference> applicationRefererences = dataAccess.getApplicantsAndTheirApplications();
		String[] cellValues = new String[6];
		
		applicationRefererences.trimToSize();
		
		for (int i=0; i<applicationRefererences.size();i++)
		{
			cellValues[0] = applicationRefererences.get(i).getApplicationRef().getApplicationNumber();
			cellValues[1] = applicationRefererences.get(i).getApplicantRef().getApplicantNumber();
			//cellValues[2] = applicationRefererences.get(i).getApplicationRef().getApplicationStatus().getStatusDescripition();
			//cellValues[3] = applicationRefererences.get(i).getApplicantRef().getPreviousQualification().getDegree();
			//cellValues[4] = applicationRefererences.get(i).getApplicantRef().getPreviousQualification().getCountry();
			//cellValues[5] = applicationRefererences.get(i).getApplicationRef().getStudyProgram().getAcademicQualification();
		
			model.addRow(cellValues);
		}
		
		return model;
	}
	
	/**
	 * Method adds uploaded csv file to file list so that it can be uploaded upon request.
	 * @param file Specified file to be uploaded.
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
	public boolean notifyApplicants(String csvName)
	{
		Scanner csvApplicantsList = null;
				
		try
		{
			csvApplicantsList = new Scanner(new FileReader(getFile(csvName).toString()));
					
			while (csvApplicantsList.hasNext())
			{
				String[] applicantRow = csvApplicantsList.nextLine().split(","); //extract potential applicant from list
				String firstName = applicantRow[6]; //extract first name
				String lastName = applicantRow[5]; //extract last name
				String applicantNumber = applicantRow[1]; //extract applicant number
				String email = applicantNumber + "@myUCT.ac.za"; //E-mail? 
				notifyApplicant(firstName,lastName, applicantNumber, email); //notify potential applicant
			}
		}
		catch(IOException e)
		{
					System.out.println("Error in populating combo box.");
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
		return filterListByApplicationStatus( filterListByLevel(filterListByStudyProgramme(getApplicantApplicationList(), studyProgram), level), applicationStatus);
	}
	
	/**
	 * Fetches a list of details pertaining to applicants and their applications.
	 * @return List of details pertaining to applicants and their applications.
	 */
	public ArrayList<ApplicantApplicationReference> getApplicantApplicationList()
	{
		return dataAccess.getApplicantsAndTheirApplications();
	}
	
	/**
	 * Filters list based on the study program
	 * @param list Specified list of the filter.
	 * @param studyProgramme Specified study program by which to filter the list
	 * @return filtered list
	 */
	public ArrayList<ApplicantApplicationReference> filterListByStudyProgramme(ArrayList<ApplicantApplicationReference> list, String studyProgramme)
	{
		//needs logic
		if (studyProgramme.equals("All"))
		{
			return list;
		}
		else if (studyProgramme.equals("Other"))
		{
			 return dataAccess.filterByStudyProgram(list, studyProgramme);
		}
		else
		{
			 return dataAccess.filterByStudyProgram(list, studyProgramme);
		}
	}
	/**
	 * Filters list based on the level of the applications
	 * @param list Specified list to filter.
	 * @param level Specified level by which to filter the list.
	 * @return filtered list
	 */
	public ArrayList<ApplicantApplicationReference> filterListByLevel(ArrayList<ApplicantApplicationReference>list, String level)
	{
		if (level.equals("All"))
		{
			return list;
		}
		else
		{
			return dataAccess.filterByStudyProgram(list, level);
		}
	}
	
	/**
	 * Filters list based on the status of the applications
	 * @param list Specified list to filter.
	 * @param appStatus Specified application status by which to filter list
	 * @return filtered list
	 */
	public ArrayList<ApplicantApplicationReference> filterListByApplicationStatus(ArrayList<ApplicantApplicationReference>list, String appStatus)
	{
		if (!appStatus.equals("All"))
		{
			return dataAccess.filterByApplicationStatus(list, appStatus);
		}
		return list;
	}
	
	/**
	 * Generates CSV file of the list of application details
	 * @param filteredApplicantList Specified list from which csv should be genereated
	 * @param fileToSave File specified by JFileChooser save dailog. 
	 */
	public void getFilteredApplicantListAsCSV(ArrayList<ApplicantApplicationReference> filteredApplicantList, File fileToSave)
	{
		//method will definitely need debugging as I am not sure what JFileChooser save dialog returns 
		String fullFilePathOfWhereToSaveFile = fileToSave.toString();
		PrintWriter writer = null;
		
		filteredApplicantList.trimToSize();
		if (filteredApplicantList.size() == 0) {return;}
		
		try
		{
			if ((!(fullFilePathOfWhereToSaveFile.endsWith(".pdf")) && (!(fullFilePathOfWhereToSaveFile.contains("."))))) {fullFilePathOfWhereToSaveFile += ".pdf";}
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
				}
				else
				{
					temp += ",";
				}
				
				
				if ((filteredApplicantList.get(i).getApplicantRef().getCitizenship().contains("South African")))
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
				temp += "," + filteredApplicantList.get(i).getApplicationRef().getPdfName();
				temp += "," + filteredApplicantList.get(i).getApplicationRef().getPdfPath();
				
				writer.println(temp);
			}
			
		}
		catch(IOException e)
		{
			System.out.println("error");
		}
		finally
		{
			if (writer!=null)
			{
				writer.close();
			}
		}
	}
	
	/**
	 * Notifies potential applicants using their details.
	 * @param firstName Specified first name of the potential applicant.
	 * @param lastName Specified last name of the potential applicant.
	 * @param applicantNumber Specified applicant number of the potential applicant.
	 * @param email Specified email address of the applicant.
	 */
	public void notifyApplicant(String firstName, String lastName, String applicantNumber, String email)
	{
		//needs logic
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
			if (files.get(i).equals(fileName)) {return files.get(i);}
		}
		return null;
	}
	
	
}
