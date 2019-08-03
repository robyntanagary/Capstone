import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DataReaderWriter {
	private ArrayList<ApplicantApplicationReference> applicationRefererences; //mapping between applicant number and application number
	private ArrayList<FOacademic> facultyOfficeAcademics;
	public int maxApplicationNumber;
	
	public DataReaderWriter()
	{
		maxApplicationNumber = 0;
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
					String applicationNumber = fields[19].trim();
					theirApplication.setApplicationNumber(applicationNumber);
					maxApplicationNumber = Math.max(Integer.valueOf(applicationNumber), maxApplicationNumber);
					theirApplication.setStudyProgram(new StudyProgram(fields[26].trim()));
					theirApplication.setApplicationStatus(new ApplicationStatus(fields[27].trim(), fields[28].trim()));
					theirApplication.setPdfName(fields[29].trim());
					theirApplication.setPdfPath(fields[30].trim());
				
					if (theirApplication.getStudyProgram().getAcademicQualification().contains("MIT"))
					{
						int itExperience = Integer.valueOf(fields[19]);
						String thesis = fields[20].trim();
						boolean prevDegreeHadThesis = true;
						if (thesis.equals("")) {prevDegreeHadThesis = false;}
						int highestMLevel = Integer.valueOf(fields[21].trim());
						UndergraduateMathematics[] maths= new UndergraduateMathematics[highestMLevel];
						
						if (highestMLevel > 0) {maths[0] = new UndergraduateMathematics(1, Integer.valueOf(fields[22].trim()));}
						if (highestMLevel > 1) {maths[1] = new UndergraduateMathematics(2, Integer.valueOf(fields[23].trim()));}
						if (highestMLevel > 2) {maths[3] = new UndergraduateMathematics(3, Integer.valueOf(fields[24].trim()));}
						
						anApplicant.setPreviousQualification(new TertiaryQualificationForMIT(prevDegree, prevDegreeUniversity, prevDegreeCountry, prevDegreeDuration, prevDegreeNQF, itExperience, prevDegreeHadThesis, thesis, highestMLevel, maths));
					}
					else
					{
						anApplicant.setPreviousQualification(new TertiaryQualification(prevDegree, prevDegreeUniversity, prevDegreeCountry, prevDegreeDuration, prevDegreeNQF));
					}
					
					if (anApplicant.getCitizenship().equals("International"))
					{
						anApplicant = new InternationalApplicant(anApplicant);
						((InternationalApplicant) anApplicant).setPassport(fields[7].trim());
					}
					else if (anApplicant.getCitizenship().contains("South African"))
					{
						anApplicant = new SouthAfricanApplicant();
						((SouthAfricanApplicant) anApplicant).setID(fields[8].trim());
						((SouthAfricanApplicant) anApplicant).setRace(fields[9].trim());				
					}
					
					applicationRefererences.add(new ApplicantApplicationReference(anApplicant, theirApplication));
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
		return applicationRefererences;
	}
	
	public ArrayList<FOacademic> getAcademics()
	{
		return facultyOfficeAcademics;
	}
	
	public void setApplicantsAndTheirApplications(ArrayList<ApplicantApplicationReference> references)
	{
		applicationRefererences = references;
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
			
			applicationRefererences.trimToSize(); 
			
			for (int i=0; i<applicationRefererences.size(); i++)
			{
				String temp = applicationRefererences.get(i).getApplicantRef().getSurname();
				temp += "," + applicationRefererences.get(i).getApplicantRef().getFirstName();
				temp += "," + applicationRefererences.get(i).getApplicantRef().getApplicantNumber();
				temp += "," + applicationRefererences.get(i).getApplicantRef().getPassword();
				temp += "," + applicationRefererences.get(i).getApplicantRef().getTitle();
				temp += "," + applicationRefererences.get(i).getApplicantRef().getCitizenship();
				temp += "," +applicationRefererences.get(i).getApplicantRef().getCitizenshipCountry();
				
				if (applicationRefererences.get(i).getApplicantRef().getCitizenship().equalsIgnoreCase("International"))
				{
					temp += "," + ((InternationalApplicant) applicationRefererences.get(i).getApplicantRef()).getPassport();
				}
				else
				{
					temp += ",";
				}
				
				
				if ((applicationRefererences.get(i).getApplicantRef().getCitizenship().contains("South African")))
				{
					temp += "," + ((SouthAfricanApplicant) applicationRefererences.get(i).getApplicantRef()).getID();
					temp += "," + ((SouthAfricanApplicant) applicationRefererences.get(i).getApplicantRef()).getRace();
				}
				else
				{
					temp += ",,";
				}
				
				temp += "," + applicationRefererences.get(i).getApplicantRef().getEmail();
				temp += "," + applicationRefererences.get(i).getApplicantRef().getCellPhone();
				temp += "," + applicationRefererences.get(i).getApplicantRef().getResidenceAddress().getLineAddress();
				temp += "," + applicationRefererences.get(i).getApplicantRef().getResidenceAddress().getCountry();
				temp += "," + applicationRefererences.get(i).getApplicantRef().getPreviousQualification().getDegree();
				temp += "," + applicationRefererences.get(i).getApplicantRef().getPreviousQualification().getTertiaryInstitution();
				temp += "," + applicationRefererences.get(i).getApplicantRef().getPreviousQualification().getCountry();
				temp += "," + String.valueOf(applicationRefererences.get(i).getApplicantRef().getPreviousQualification().getMinDuration());
				temp += "," + applicationRefererences.get(i).getApplicantRef().getPreviousQualification().getNQFEquivalence();
				
				if (applicationRefererences.get(i).getApplicationRef().getStudyProgram().getAcademicQualification().contains("MIT"))
				{
					temp += "," + String.valueOf(((TertiaryQualificationForMIT) applicationRefererences.get(i).getApplicantRef().getPreviousQualification()).getPriorITExperience());
					temp += "," + String.valueOf(((TertiaryQualificationForMIT) applicationRefererences.get(i).getApplicantRef().getPreviousQualification()).getDescriptionProjectThesis());
					int MathLevel = ((TertiaryQualificationForMIT) applicationRefererences.get(i).getApplicantRef().getPreviousQualification()).getHighestLevelUndergradMathematcs();
					temp += "," + String.valueOf(MathLevel);
					if (MathLevel > 0)
					{
						temp += "," + String.valueOf(((TertiaryQualificationForMIT) applicationRefererences.get(i).getApplicantRef().getPreviousQualification()).getUndergradMaths()[0].getAverage());
					}
					else
					{
						temp += ",";
					}
					
					if (MathLevel > 1)
					{
						temp += "," + String.valueOf(((TertiaryQualificationForMIT) applicationRefererences.get(i).getApplicantRef().getPreviousQualification()).getUndergradMaths()[1].getAverage());
					}
					else
					{
						temp += ",";
					}
					
					if (MathLevel > 2)
					{
						temp += "," + String.valueOf(((TertiaryQualificationForMIT) applicationRefererences.get(i).getApplicantRef().getPreviousQualification()).getUndergradMaths()[2].getAverage());
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
				
				temp += "," + applicationRefererences.get(i).getApplicationRef().getApplicationNumber();
				temp += "," + applicationRefererences.get(i).getApplicationRef().getStudyProgram().getAcademicQualification();
				temp += "," + applicationRefererences.get(i).getApplicationRef().getApplicationStatus().getStatusDescripition();
				temp += "," + applicationRefererences.get(i).getApplicationRef().getApplicationStatus().getReasonDescription();
				temp += "," + applicationRefererences.get(i).getApplicationRef().getPdfName();
				temp += "," + applicationRefererences.get(i).getApplicationRef().getPdfPath();
				
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
			
		}
		finally
		{
			
		}
	}
	
	public Application getApplicationOfApplicant(String applicantNumber)
	{
		for (int i=0; i<applicationRefererences.size(); i++)
		{
			if (applicationRefererences.get(i).getApplicantRef().getApplicantNumber().equals(applicantNumber))
			{
				return applicationRefererences.get(i).getApplicationRef();
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
		for (int i=0; i<applicationRefererences.size(); i++)
		{
			if (applicationRefererences.get(i).getApplicantRef().getApplicantNumber().equals(applicantNumber))
			{
				applicationRefererences.get(i).setApplicationRef(app);;
			}
		}
	}
	
	public ApplicantApplicationReference getApplicantApplicationRefByApplication(String applicationNumber)
	{
		for (int i=0; i<applicationRefererences.size(); i++)
		{
			if (applicationRefererences.get(i).getApplicationRef().getApplicationNumber().equals(applicationNumber))
			{
				return applicationRefererences.get(i);
			}
		}
		return null;
	}
	
	public ApplicantApplicationReference getApplicantApplicationRefByApplicant(String applicantNumber)
	{
		for (int i=0; i<applicationRefererences.size(); i++)
		{
			if (applicationRefererences.get(i).getApplicantRef().getApplicantNumber().equals(applicantNumber))
			{
				return applicationRefererences.get(i);
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
				if (applicantsAndTheirApplications.get(i).getApplicationRef().getStudyProgram().getAcademicQualification().equals(studyProgram))
				{
					temp.add(applicantsAndTheirApplications.get(i));
				}
			}
		}
		
		if (temp.size() == 0) {return applicantsAndTheirApplications;}
		return temp;
	}

	
	public ArrayList<ApplicantApplicationReference> filterByLevel(ArrayList<ApplicantApplicationReference> applicantsAndTheirApplications, String level)
	{
		ArrayList<ApplicantApplicationReference> temp = new ArrayList<ApplicantApplicationReference>();
		temp.trimToSize();
		
		for (int i=0; i<applicantsAndTheirApplications.size(); i++)
		{
			if (applicantsAndTheirApplications.get(i).getApplicationRef().getStudyProgram().getAcademicQualification().contains(level))
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
			if (applicantsAndTheirApplications.get(i).getApplicationRef().getApplicationStatus().getStatusDescripition().equals(status))
			{
					temp.add(applicantsAndTheirApplications.get(i));
			}
		}
		
		if (temp.size() == 0) {return applicantsAndTheirApplications;}
		return temp;
	}
}
