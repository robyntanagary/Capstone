import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DataReaderWriter {
	private ArrayList<ApplicantApplicationReference> applicationReferences; //mapping between applicant number and application number
	private ArrayList<FOacademic> facultyOfficeAcademics;
	public int maxApplicationNumber;
	
	public DataReaderWriter()
	{
		maxApplicationNumber = 0;
		applicationReferences  = new ArrayList<ApplicantApplicationReference>(); //mapping between applicant number and application number
		facultyOfficeAcademics = new ArrayList<FOacademic>();
		readDataIn();
	}
	
	private void readDataIn()
	{
		Scanner references = null;
		
		try
		{
			references = new Scanner(new FileReader("SampleData.csv"));
			
			while (references.hasNextLine())
			{
				String[] fields = references.nextLine().split(",");
				
				String surname = fields[0].trim();
				String firstName = fields[1].trim();
				String applicantNumber = fields[2].trim();
				String password = fields[3].trim();
				String title = fields[4].trim();
				String email = fields[10].trim();
				String cellPhone = fields[11].trim();
				
				if (applicantNumber.startsWith("A0"))
				{
					facultyOfficeAcademics.add(new FOacademic(surname, firstName, applicantNumber, password, title, email, cellPhone));
				}
				else
				{
					Applicant anApplicant = new Applicant();
					Application theirApplication = new Application();
					
					if (fields[5].trim().equals("International"))
					{
						anApplicant = new InternationalApplicant();
						((InternationalApplicant) anApplicant).setPassport(fields[7].trim());
					}
					else if (fields[5].trim().contains("South African"))
					{
						anApplicant = new SouthAfricanApplicant();
						((SouthAfricanApplicant) anApplicant).setID(fields[8].trim());
						((SouthAfricanApplicant) anApplicant).setRace(fields[9].trim());
					}
					anApplicant.setSurname(surname);
					anApplicant.setFirstName(firstName);
					anApplicant.setApplicantNumber(applicantNumber);
					anApplicant.setPassword(password);
					anApplicant.setTitle(title);
					anApplicant.setEmail(email);
					anApplicant.setCellPhone(cellPhone);
					anApplicant.setCitizenship(fields[5].trim());
					anApplicant.setCitizenshipCountry(fields[6].trim());
					String residenceLine = fields[12].trim();
					String residenceCountry = fields[13].trim();
					anApplicant.setResidenceAddress(new Address(residenceLine, residenceCountry));
					String prevDegree = fields[14].trim();
					String prevDegreeUniversity = fields[15].trim();
					String prevDegreeCountry = fields[16].trim();
					int prevDegreeDuration = Integer.valueOf(fields[17].trim());
					String prevDegreeNQF = fields[18].trim();
					String applicationNumber = fields[25].trim();
					theirApplication.setApplicationNumber(applicationNumber);
					maxApplicationNumber = Math.max(Integer.valueOf(applicationNumber), maxApplicationNumber);
					theirApplication.setStudyProgram(new StudyProgram(fields[26].trim()));
					theirApplication.setApplicationStatus(new ApplicationStatus(fields[27].trim(), fields[28].trim()));
					theirApplication.setPdfName(fields[29].trim());
					theirApplication.setPdfPath(fields[30].trim());
					
					if (theirApplication.getStudyProgram().getAcademicQualification().contains("MIT"))
					{
						int itExperience = Integer.valueOf(fields[19].trim());
						String thesis = fields[20].trim();
						boolean prevDegreeHadThesis = (!thesis.equals(""));
						int highestMLevel = Integer.valueOf(fields[21].trim());
						UndergraduateMathematics[] maths= new UndergraduateMathematics[highestMLevel];
						
						if (highestMLevel > 0) {maths[0] = new UndergraduateMathematics(1, Integer.valueOf(fields[22].trim()));}
						if (highestMLevel > 1) {maths[1] = new UndergraduateMathematics(2, Integer.valueOf(fields[23].trim()));}
						if (highestMLevel > 2) {maths[2] = new UndergraduateMathematics(3, Integer.valueOf(fields[24].trim()));}
						
						anApplicant.setPreviousQualification(new TertiaryQualificationForMIT(prevDegree, prevDegreeUniversity, prevDegreeCountry, prevDegreeDuration, prevDegreeNQF, itExperience, prevDegreeHadThesis, thesis, highestMLevel, maths));
					}
					else
					{
						anApplicant.setPreviousQualification(new TertiaryQualification(prevDegree, prevDegreeUniversity, prevDegreeCountry, prevDegreeDuration, prevDegreeNQF));
					}
					
					applicationReferences.add(new ApplicantApplicationReference(anApplicant, theirApplication));
				}	
			}
		}
		catch(IOException e)
		{
			System.out.println("Error in getting references.");
		}
		finally
		{
			if (references != null)
			{
				references.close();
			}
		} 
	}
	
	public ArrayList<ApplicantApplicationReference> getApplicantsAndTheirApplications()
	{
		return applicationReferences;
	}
	
	public ArrayList<FOacademic> getAcademics()
	{
		return facultyOfficeAcademics;
	}
	
	public void setApplicantsAndTheirApplications(ArrayList<ApplicantApplicationReference> references)
	{
		applicationReferences = references;
	}
	
	public void setAcademics(ArrayList<FOacademic> academics)
	{
		facultyOfficeAcademics = academics;
	}
	
	
	public void writeDataBack()
	{
		PrintWriter writer = null;
		
		try
		{
			writer = new PrintWriter(new FileWriter("SampleData.txt", false));
			
			applicationReferences.trimToSize(); 
			
			for (int i=0; i<applicationReferences.size(); i++)
			{
				String temp = applicationReferences.get(i).getApplicantRef().getSurname();
				temp += "," + applicationReferences.get(i).getApplicantRef().getFirstName();
				temp += "," + applicationReferences.get(i).getApplicantRef().getApplicantNumber();
				temp += "," + applicationReferences.get(i).getApplicantRef().getPassword();
				temp += "," + applicationReferences.get(i).getApplicantRef().getTitle();
				temp += "," + applicationReferences.get(i).getApplicantRef().getCitizenship();
				temp += "," + applicationReferences.get(i).getApplicantRef().getCitizenshipCountry();
				
				if (applicationReferences.get(i).getApplicantRef().getCitizenship().equalsIgnoreCase("International"))
				{
					temp += "," + ((InternationalApplicant) applicationReferences.get(i).getApplicantRef()).getPassport();
				}
				else
				{
					temp += ",";
				}
				
				
				if ((applicationReferences.get(i).getApplicantRef().getCitizenship().contains("South African")))
				{
					temp += "," + ((SouthAfricanApplicant) applicationReferences.get(i).getApplicantRef()).getID();
					temp += "," + ((SouthAfricanApplicant) applicationReferences.get(i).getApplicantRef()).getRace();
				}
				else
				{
					temp += ",";
				}
				
				temp += "," + applicationReferences.get(i).getApplicantRef().getEmail();
				temp += "," + applicationReferences.get(i).getApplicantRef().getCellPhone();
				temp += "," + applicationReferences.get(i).getApplicantRef().getResidenceAddress().getLineAddress();
				temp += "," + applicationReferences.get(i).getApplicantRef().getResidenceAddress().getCountry();
				temp += "," + applicationReferences.get(i).getApplicantRef().getPreviousQualification().getDegree();
				temp += "," + applicationReferences.get(i).getApplicantRef().getPreviousQualification().getTertiaryInstitution();
				temp += "," + applicationReferences.get(i).getApplicantRef().getPreviousQualification().getCountry();
				temp += "," + String.valueOf(applicationReferences.get(i).getApplicantRef().getPreviousQualification().getMinDuration());
				temp += "," + applicationReferences.get(i).getApplicantRef().getPreviousQualification().getNQFEquivalence();
				
				if (applicationReferences.get(i).getApplicationRef().getStudyProgram().getAcademicQualification().contains("MIT"))
				{
					temp += "," + String.valueOf(((TertiaryQualificationForMIT) applicationReferences.get(i).getApplicantRef().getPreviousQualification()).getPriorITExperience());
					temp += "," + String.valueOf(((TertiaryQualificationForMIT) applicationReferences.get(i).getApplicantRef().getPreviousQualification()).getDescriptionProjectThesis());
					int MathLevel = ((TertiaryQualificationForMIT) applicationReferences.get(i).getApplicantRef().getPreviousQualification()).getHighestLevelUndergradMathematcs();
					temp += "," + String.valueOf(MathLevel);
					if (MathLevel > 0)
					{
						temp += "," + String.valueOf(((TertiaryQualificationForMIT) applicationReferences.get(i).getApplicantRef().getPreviousQualification()).getUndergradMaths()[0].getAverage());
					}
					else
					{
						temp += ",";
					}
					
					if (MathLevel > 1)
					{
						temp += "," + String.valueOf(((TertiaryQualificationForMIT) applicationReferences.get(i).getApplicantRef().getPreviousQualification()).getUndergradMaths()[1].getAverage());
					}
					else
					{
						temp += ",";
					}
					
					if (MathLevel > 2)
					{
						temp += "," + String.valueOf(((TertiaryQualificationForMIT) applicationReferences.get(i).getApplicantRef().getPreviousQualification()).getUndergradMaths()[2].getAverage());
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
				
				temp += "," + applicationReferences.get(i).getApplicationRef().getApplicationNumber();
				temp += "," + applicationReferences.get(i).getApplicationRef().getStudyProgram().getAcademicQualification();
				temp += "," + applicationReferences.get(i).getApplicationRef().getApplicationStatus().getStatusDescripition();
				temp += "," + applicationReferences.get(i).getApplicationRef().getApplicationStatus().getReasonDescription();
				temp += "," + applicationReferences.get(i).getApplicationRef().getPdfName();
				temp += "," + applicationReferences.get(i).getApplicationRef().getPdfPath();
				
				writer.println(temp);
			}
			
			facultyOfficeAcademics.trimToSize();
			
			for (int i=0; i<facultyOfficeAcademics.size(); i++)
			{
				String temp2 = facultyOfficeAcademics.get(i).getSurname();
				temp2 += "," + facultyOfficeAcademics.get(i).getFirstName();
				temp2 += "," + facultyOfficeAcademics.get(i).getStaffNumber();
				temp2 += "," + facultyOfficeAcademics.get(i).getPassword();
				temp2 += "," + facultyOfficeAcademics.get(i).getTitle();
				temp2 += ",,,,,";
				temp2 += "," + facultyOfficeAcademics.get(i).getEmail();
				temp2 += "," + facultyOfficeAcademics.get(i).getCellPhone();
				temp2 += ",,,,,,,";
				temp2 += ",,,,,,";
				temp2 += ",,,,,,";
				
				writer.println(temp2);
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
	
	public Application getApplicationOfApplicant(String applicantNumber)
	{
		for (int i=0; i<applicationReferences.size(); i++)
		{
			if (applicationReferences.get(i).getApplicantRef().getApplicantNumber().equals(applicantNumber))
			{
				return applicationReferences.get(i).getApplicationRef();
			}
		}
		return null;
	}
	
	public int getMaxApplicationNumber()
	{
		return maxApplicationNumber;
	}
	
	public void setMaximumApplicationNumber(int max)
	{
		maxApplicationNumber = max;
	}
	
	public void setApplicationOfApplicant(String applicantNumber, Application app)
	{
		for (int i=0; i<applicationReferences.size(); i++)
		{
			if (applicationReferences.get(i).getApplicantRef().getApplicantNumber().equals(applicantNumber))
			{
				applicationReferences.get(i).setApplicationRef(app);
			}
		}
	}
	
	public ApplicantApplicationReference getApplicantApplicationRefByApplication(String applicationNumber)
	{
		for (int i=0; i<applicationReferences.size(); i++)
		{
			if (applicationReferences.get(i).getApplicationRef().getApplicationNumber().equals(applicationNumber))
			{
				return applicationReferences.get(i);
			}
		}
		return null;
	}
	
	public ApplicantApplicationReference getApplicantApplicationRefByApplicant(String applicantNumber)
	{
		for (int i=0; i<applicationReferences.size(); i++)
		{
			if (applicationReferences.get(i).getApplicantRef().getApplicantNumber().equals(applicantNumber))
			{
				return applicationReferences.get(i);
			}
		}
		return null;
	}
	
	public ArrayList<ApplicantApplicationReference> filterByStudyProgram(ArrayList<ApplicantApplicationReference> applicantsAndTheirApplications, String studyProgram)
	{
		ArrayList<ApplicantApplicationReference> temp = new ArrayList<ApplicantApplicationReference>();
		temp.trimToSize();
		
		for (int i=0; i<applicantsAndTheirApplications.size(); i++)
		{
			if (studyProgram.equals("Other"))
			{
				if (!applicantsAndTheirApplications.get(i).getApplicationRef().getStudyProgram().getAcademicQualification().equals("Honours in Computer Science (full-time)")
					&& (!applicantsAndTheirApplications.get(i).getApplicationRef().getStudyProgram().getAcademicQualification().equals("Masters in Information Technology (MIT)"))
					&& (!applicantsAndTheirApplications.get(i).getApplicationRef().getStudyProgram().getAcademicQualification().equals("Masters by Coursework and Dissertation (MSc by C+D)"))
					&& (!applicantsAndTheirApplications.get(i).getApplicationRef().getStudyProgram().getAcademicQualification().equals("Masters by Dissertation (MSc by D)"))
					&& (!applicantsAndTheirApplications.get(i).getApplicationRef().getStudyProgram().getAcademicQualification().equals("PhD in Computer Science"))
					&& (!applicantsAndTheirApplications.get(i).getApplicationRef().getStudyProgram().getAcademicQualification().equals("Honours in Information Systems (full-time)"))
					&& (!applicantsAndTheirApplications.get(i).getApplicationRef().getStudyProgram().getAcademicQualification().equals("Honours in Management Information Systems (part-time)"))
					&& (!applicantsAndTheirApplications.get(i).getApplicationRef().getStudyProgram().getAcademicQualification().equals("Postgraduate Diploma in Management in Information Systems (part-time)"))
					&& (!applicantsAndTheirApplications.get(i).getApplicationRef().getStudyProgram().getAcademicQualification().equals("Master of Commerce in Information Systems"))
					&& (!applicantsAndTheirApplications.get(i).getApplicationRef().getStudyProgram().getAcademicQualification().equals("PhD in Information Systems")))
				{
					temp.add(applicantsAndTheirApplications.get(i));
				}
			}
			else
			{
				if (applicantsAndTheirApplications.get(i).getApplicationRef().getStudyProgram().getAcademicQualification().contains(studyProgram.trim()))
				{
					temp.add(applicantsAndTheirApplications.get(i));
				}
			}
		}
		
		if (temp.size() == 0) {return applicantsAndTheirApplications;}
		return temp;
	}
	
	/**
	 * Method add a new application to array list and textfile
	 * @param applicantAndTheirApplication Specified applicant and their application
	 */
	public void addNewApplicationRecord(ApplicantApplicationReference applicantAndTheirApplication)
	{
		applicationReferences.add(applicantAndTheirApplication);
	}
	
	/**
	 * Method update existing application 
	 * @param applicantAndTheirApplication Specified applicant and their application
	 */
	public void updateApplicationRecord(ApplicantApplicationReference applicantAndTheirApplication)
	{
		applicationReferences.remove(getApplicantApplicationRefByApplicant(applicantAndTheirApplication.getApplicantRef().getApplicantNumber()));
		applicationReferences.add(applicantAndTheirApplication);
	}
	
	/**
	 * Methods add record line to textfile
	 * @param applicantAndTheirApplication Specified applicant and their application
	 */
	public void appendToTextfile(ApplicantApplicationReference applicantAndTheirApplication)
	{
		
	}

	
	public ArrayList<ApplicantApplicationReference> filterByLevel(ArrayList<ApplicantApplicationReference> applicantsAndTheirApplications, String level)
	{
		ArrayList<ApplicantApplicationReference> temp = new ArrayList<ApplicantApplicationReference>();
		temp.trimToSize();
		
		for (int i=0; i<applicantsAndTheirApplications.size(); i++)
		{
			if (applicantsAndTheirApplications.get(i).getApplicationRef().getStudyProgram().getAcademicQualification().contains(level.trim()))
			{
					temp.add(applicantsAndTheirApplications.get(i));
			}
		}
		
		if (temp.size() == 0) {return applicantsAndTheirApplications;}
		return temp;
	}
	
	public ArrayList<ApplicantApplicationReference> filterByApplicationStatus(ArrayList<ApplicantApplicationReference> applicantsAndTheirApplications, String status)
	{
		ArrayList<ApplicantApplicationReference> temp = new ArrayList<ApplicantApplicationReference>();
		temp.trimToSize();
		
		for (int i=0; i<applicantsAndTheirApplications.size(); i++)
		{
			if (applicantsAndTheirApplications.get(i).getApplicationRef().getApplicationStatus().getStatusDescripition().contains(status.trim()))
			{
					temp.add(applicantsAndTheirApplications.get(i));
			}
		}
		
		if (temp.size() == 0) {return applicantsAndTheirApplications;}
		return temp;
	}
}
