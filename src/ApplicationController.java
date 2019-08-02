import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JTable;

public class ApplicationController {
	private Application application;
	ArrayList<File> files;
	/**
	 * Method creates a controller object responsible for managing applications.
	 */
	public ApplicationController()
	{
		
	}
	
	public Application getApplicationOfApplicant(String applicantNumber)
	{
		return application; //needs logic!!!
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
		return true; //needs logic!!!
	}
	
	public Application createNewApplication(String applicantNumber)
	{
		//needs logic!!!
		return application;
	}
	
	public boolean submitApplication(Application anApplication)
	{
		//needs logic
		
		return true;
	}
	
	public boolean insertOrUpdateApplication(Application anApplication)
	{
		//needs logic
		
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
	
	public boolean downloadPDF(String pdfName)
	{
		//needs logic
		return true;
	}
	
	public boolean applicantionEditable(String applicationNumber)
	{
		//needs logic
		return true;
	}
	
	public StudyProgram getStudyProgram(String studyProgramName)
	{
		//needs logic!!!
		return new StudyProgram(studyProgramName);
	}
	
	public boolean applicantionViewable(String applicationNumber)
	{
		//needs logic
		return true;
	}
	
	public boolean requestPDFofApplicantDetails(String applicantNumber, String application)
	{
		//needs logic!
		return true;
	}
	
	public void populateApplicationsTable(JTable tableToPopulate)
	{
		//
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
				String[] applicantRow = csvApplicantsList.nextLine().split(",");
				String firstName = applicantRow[1];
				String lastName = applicantRow[1];
				String applicantNumber = applicantRow[1];
				String email = applicantNumber + "@myUCT.ac.za"; //E-mail?
				notifyApplicant(firstName,lastName, applicantNumber, email);
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
	
	public ArrayList<String> getFilteredList(String studyProgram, String level, String applicationStatus)
	{
		return filterListByApplicationStatus( filterListByLevel(filterListByStudyProgramme(getApplicantApplicationList(), studyProgram), level), applicationStatus);
	}
	
	public ArrayList<String> getApplicantApplicationList()
	{
		//needs logic!!!
		return new ArrayList<String>();
	}
	
	public ArrayList<String> filterListByStudyProgramme(ArrayList<String> list, String studyProgramme)
	{
		//needs logic
		if (studyProgramme.equals("All"))
		{
			
		}
		else if (studyProgramme.equals("Other"))
		{
			
		}
		else
		{
			
		}
		return list;
	}
	
	public ArrayList<String> filterListByLevel(ArrayList<String>list, String level)
	{
		//needs logic
		if (level.equals("All"))
		{
			
		}
		else
		{
			
		}
		return list;
	}
	
	public ArrayList<String> filterListByApplicationStatus(ArrayList<String>list, String appStatus)
	{
		//needs logic
		if (appStatus.equals("All"))
		{
			
		}
		else
		{
			
		}
		return list;
	}
	
	public void getFilteredApplicantListAsCSV(ArrayList<String> filteredApplicantList)
	{
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
