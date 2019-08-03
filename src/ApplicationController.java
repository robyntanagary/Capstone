import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
	
	public ApplicationController(DataReaderWriter data)
	{
		this();
		dataAccess = data;
	}
	
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
	
	public boolean noExistingApplication(String applicantNumber)
	{
		return dataAccess.getApplicationOfApplicant(applicantNumber).equals(null); 
	}
	
	public Application createNewApplication(String applicantNumber)
	{
		application = new Application();
		int applicationNumber = dataAccess.getMaxApplicationNumber() + 1;
		application.setApplicationNumber(String.valueOf(applicationNumber));
		dataAccess.setApplicationOfApplicant(applicantNumber, application);
		return application;
	}
	
	public boolean submitApplication(Application anApplication)
	{
		anApplication.setApplicationStatus(new ApplicationStatus("Applied", "Applicant submitted application"));
		dataAccess.getApplicantApplicationRefByApplication(anApplication.getApplicationNumber()).setApplicationRef(anApplication);
		return true;
	}
	
	public boolean insertOrUpdateApplication(Application anApplication)
	{
		dataAccess.getApplicantApplicationRefByApplication(anApplication.getApplicationNumber()).setApplicationRef(anApplication);
		return true;
	}
	
	public boolean uploadPDF(String pdfName)
	{
		//needs logic!!!
		return true;
	}
	
	/**
	 * Method adds uploaded pdf file to file list so that it can be uploaded upon request.
	 * @param file Specified file to be uploaded.
	 */
	public void chosenPDF(File file)
	{
		files.add(file);
	}
	
	public boolean downloadPDF(String pdfName, File fileToSave)
	{
		String fullFilePathOfWhereToSaveFile = fileToSave.toString();
		//needs logic
		return true;
	}
	
	public boolean applicantionEditable(String applicationNumber)
	{
		String status = dataAccess.getApplicantApplicationRefByApplication(applicationNumber).getApplicationRef().getApplicationStatus().getStatusDescripition();
		status = status.trim();
		return (status.equals("Created") || status.equals("Applied") || status.equals("Decision Deffered") || status.equals("On Waiting List") || status.equals("Firm Offer Deferred"));
	}
	
	public StudyProgram getStudyProgram(String studyProgramName)
	{
		//needs logic!!!
		return new StudyProgram(studyProgramName);
	}
	
	public boolean applicantionViewable(String applicationNumber)
	{
		String status = dataAccess.getApplicantApplicationRefByApplication(applicationNumber).getApplicationRef().getApplicationStatus().getStatusDescripition();
		status = status.trim();
		return (!status.equals("Withdrawn"));
	}
	
	public boolean requestPDFofApplicantDetails(String applicantNumber, String application, File fileToSave)
	{
		String fullFilePathOfWhereToSaveFile = fileToSave.toString();
		//needs logic!
		return true;
	}
	
	public DefaultTableModel populateApplicationsTable(DefaultTableModel model)
	{
		ArrayList<ApplicantApplicationReference> applicationRefererences = dataAccess.getApplicantsAndTheirApplications();
		String[] cellValues = new String[6];
		
		applicationRefererences.trimToSize();
		
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
	 * Method adds uploaded csv file to file list so that it can be uploaded upon request.
	 * @param file Specified file to be uploaded.
	 */
	public void chosenCSV(File file)
	{
		files.add(file);
	}
	
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
	
	public ArrayList<ApplicantApplicationReference> getFilteredList(String studyProgram, String level, String applicationStatus)
	{
		return filterListByApplicationStatus( filterListByLevel(filterListByStudyProgramme(getApplicantApplicationList(), studyProgram), level), applicationStatus);
	}
	
	public ArrayList<ApplicantApplicationReference> getApplicantApplicationList()
	{
		return dataAccess.getApplicantsAndTheirApplications();
	}
	
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
	
	public ArrayList<ApplicantApplicationReference> filterListByLevel(ArrayList<ApplicantApplicationReference>list, String level)
	{
		//needs logic
		if (level.equals("All"))
		{
			return list;
		}
		else
		{
			return dataAccess.filterByStudyProgram(list, level);
		}
	}
	
	public ArrayList<ApplicantApplicationReference> filterListByApplicationStatus(ArrayList<ApplicantApplicationReference>list, String appStatus)
	{
		if (!appStatus.equals("All"))
		{
			return dataAccess.filterByApplicationStatus(list, appStatus);
		}
		return list;
	}
	
	public void getFilteredApplicantListAsCSV(ArrayList<ApplicantApplicationReference> filteredApplicantList, File fileToSave)
	{
		String fullFilePathOfWhereToSaveFile = fileToSave.toString();
		//needs logic
	}
	
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
