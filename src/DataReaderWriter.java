import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;

public class DataReaderWriter {
	//private ArrayList<ApplicantApplicationReference> applicationReferences; //mapping between applicant number and application number
	//private ArrayList<FOacademic> facultyOfficeAcademics;
	public int maxApplicationNumber;
	static Connection con = null;
	static String dbName = "";
	static String url = "jdbc:mysql://localhost:3306/?allowPublicKeyRetrieval=true&useSSL=false" + dbName;
	static String username = "root";
	static String password = "root";
	
	public DataReaderWriter()
	{
		maxApplicationNumber = 0;
		//applicationReferences  = new ArrayList<ApplicantApplicationReference>(); //mapping between applicant number and application number
		//facultyOfficeAcademics = new ArrayList<FOacademic>();
		connectToDB();
	}
	
	private void connectToDB()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Successfully connect to the database");
		}
		catch(Exception e)
		{
			System.out.println("Error in connecting to the database.");
		}
	}
	
	/*public ArrayList<ApplicantApplicationReference> getApplicantsAndTheirApplications()
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
	}*/
	
	
	/*public void writeDataBack()
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
	}*/
	
	public Applicant getApplicant(String applicantNumber)
	{
		PreparedStatement getApplicant;
		PreparedStatement getApplication;
		ResultSet rs = null;
		ResultSet rs2 = null;
		String applicantNum = "";
		String surname = "";
		String firstName = "";
		String title = "";
		String email = "";
		String cellphone = "";
		String password = "";
		String citizenship = "";
		String citizenshipCountry = "";
		String residenceAddress = "";
		String residenceCountry = "";
		String id = "";
		String race = "";
		String passport = "";
		String previousDegree = "";
		String previousDegreeUniversity = "";
		String previousDegreeCountry = "";
		int previousDegreeDuration = 0;
		String previousDegreeNQF = "";
		int iTExperience = 0;
		String previousDegreeThesis = "";
		int highestMathLevel = 0;
		int mathLevel1 = 0;
		int mathLevel2 = 0;
		int mathLevel3 = 0;
		Applicant applicant = null;
		
		try
		{
			getApplicant = con.prepareStatement("SELECT * FROM applicant WHERE applicantNumber = " + applicantNumber.toUpperCase() + ";");
			rs = getApplicant.executeQuery();
			
			applicantNum = rs.getString("applicantNumber");
			surname = rs.getString("applicantSurname");
			firstName = rs.getString("applicantName");
			title = rs.getString("applicantTitle");
			email = rs.getString("applicantEmail");
			cellphone = rs.getString("applicantCellphone");
			password = rs.getString("applicantPassword");
			citizenship = rs.getString("applicantCitizenship");
			citizenshipCountry = rs.getString("applicantCitizenshipCountry");
			residenceAddress = rs.getString("applicantResidenceLineAddress");
			residenceCountry = rs.getString("applicantResidenceCountry");
			iTExperience = rs.getInt("iTExperience");
			previousDegreeThesis = rs.getString("previousDegreeThesis");
			highestMathLevel = rs.getInt("highestMathLevel");
			mathLevel1 = rs.getInt("mathLevel1");
			mathLevel2 = rs.getInt("mathLevel2");
			mathLevel3 = rs.getInt("mathLevel3");
			
			getApplication = con.prepareStatement("SELECT * FROM application WHERE applicantNumber = " + applicantNumber.toUpperCase() + ";");
			rs2 = getApplication.executeQuery();
			
			if(rs.getString("applicantCitizenship").equals("International"))
			{
				applicant = new InternationalApplicant();
				passport = rs.getString("applicantPassport");
				((InternationalApplicant)applicant).setPassport(passport);
			}
			
			else
			{
				applicant = new SouthAfricanApplicant();
				id = rs.getString("applicantID");
				race = rs.getString("applicantRace");
				((SouthAfricanApplicant)applicant).setID(id);
				((SouthAfricanApplicant)applicant).setRace(race);
			}
			
			if(rs2.getString("studyProgram").contains("MIT"))
			{
				UndergraduateMathematics[] maths = new UndergraduateMathematics[highestMathLevel - 1];
				boolean hadThesis = !previousDegreeThesis.equals("");
				if(highestMathLevel > 0)
				{
					maths[0] = new UndergraduateMathematics(1, mathLevel1);
					maths[1] = new UndergraduateMathematics(2, mathLevel2);
					maths[2] = new UndergraduateMathematics(3, mathLevel3);
				}
				 
			 	applicant.setPreviousQualification(new TertiaryQualificationForMIT(previousDegree, previousDegreeUniversity, previousDegreeCountry, previousDegreeDuration, previousDegreeNQF, iTExperience, hadThesis, previousDegreeThesis, highestMathLevel, maths));
				 
			}
			
			else
			{
				applicant.setPreviousQualification(new TertiaryQualification(previousDegree, previousDegreeUniversity, previousDegreeCountry, previousDegreeDuration, previousDegreeNQF));
			}
			
			applicant.setApplicantNumber(applicantNum);
			applicant.setSurname(surname);
			applicant.setFirstName(firstName);
			applicant.setTitle(title);
			applicant.setEmail(email);
			applicant.setCellPhone(cellphone);
			applicant.setPassword(password);
			applicant.setCitizenship(citizenship);
			applicant.setCitizenshipCountry(citizenshipCountry);
			applicant.setResidenceAddress(new Address(residenceAddress, residenceCountry));
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return applicant;
	}
	
	public Application getApplicationOfApplicant(String applicantNumber)
	{
		/*for (int i=0; i<applicationReferences.size(); i++)
		{
			if (applicationReferences.get(i).getApplicantRef().getApplicantNumber().equals(applicantNumber))
			{
				return applicationReferences.get(i).getApplicationRef();
			}
		}
		return null;*/
		PreparedStatement getApplication;
		ResultSet rs = null;
		String applicationNumber = "";
		String applicantNum = "";
		String applicationStatus = "";
		String studyProgram = "";
		Application application = null;
		
		try
		{
			getApplication = con.prepareStatement("SELECT * FROM application WHERE applicantNumber = " + applicantNumber.toUpperCase() + ";");
			rs = getApplication.executeQuery();
			
			while(rs.next())
			{
				applicationNumber = rs.getString("applicationNumber");
				applicantNum = rs.getString("applicantNumber");
				applicationStatus = rs.getString("applicationStatus");
				studyProgram = rs.getString("studyProgram");
			}
			
			application = new Application(applicationNumber, applicantNum);
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return application;
	}
	
	public Application getApplicationOfApplicant2(String appNumber)
	{
		/*for (int i=0; i<applicationReferences.size(); i++)
		{
			if (applicationReferences.get(i).getApplicantRef().getApplicantNumber().equals(applicantNumber))
			{
				return applicationReferences.get(i).getApplicationRef();
			}
		}
		return null;*/
		PreparedStatement getApplication;
		ResultSet rs = null;
		String applicationNumber = "";
		String applicantNum = "";
		String applicationStatus = "";
		String studyProgram = "";
		Application application = null;
		
		try
		{
			getApplication = con.prepareStatement("SELECT * FROM application WHERE applicationNumber = " + appNumber.toUpperCase() + ";");
			rs = getApplication.executeQuery();
			
			while(rs.next())
			{
				applicationNumber = rs.getString("applicationNumber");
				applicantNum = rs.getString("applicantNumber");
				applicationStatus = rs.getString("applicationStatus");
				studyProgram = rs.getString("studyProgram");
			}
			
			application = new Application(applicationNumber, applicantNum);
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return application;
	}
	
	public int getMaxApplicationNumber()
	{
		return maxApplicationNumber;
	}
	
	public void setMaximumApplicationNumber(int max)
	{
		maxApplicationNumber = max;
	}
	
	/*public void setApplicationOfApplicant(String applicantNumber, Application app)
	{
		for (int i=0; i<applicationReferences.size(); i++)
		{
			if (applicationReferences.get(i).getApplicantRef().getApplicantNumber().equals(applicantNumber))
			{
				applicationReferences.get(i).setApplicationRef(app);
			}
		}
	}*/
	
	public ApplicantApplicationReference getApplicantApplicationRefByApplication(String applicationNumber)
	{
		Applicant applicant = null;
		Application application = null;
		
		application = getApplicationOfApplicant2(applicationNumber);
		applicant = getApplicant(application.getApplicantNumber());
		ApplicantApplicationReference aar = new ApplicantApplicationReference(applicant, application);
		
		return aar;
	}
	
	public ApplicantApplicationReference getApplicantApplicationRefByApplicant(String applicantNumber)
	{
		Applicant applicant = null;
		Application application = null;
		
		application = getApplicationOfApplicant(applicantNumber);
		applicant = getApplicant(applicantNumber);
		ApplicantApplicationReference aar = new ApplicantApplicationReference(applicant, application);
		
		return aar;
	}
	
	/*public ArrayList<ApplicantApplicationReference> filterByStudyProgram(ArrayList<ApplicantApplicationReference> applicantsAndTheirApplications, String studyProgram)
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
	}*/
	
	/**
	 * Method add a new application to array list and textfile
	 * @param applicantAndTheirApplication Specified applicant and their application
	 */
	/*public void addNewApplicationRecord(ApplicantApplicationReference applicantAndTheirApplication)
	{
		applicationReferences.add(applicantAndTheirApplication);
	}*/
	
	/**
	 * Method update existing application 
	 * @param applicantAndTheirApplication Specified applicant and their application
	 */
	public void updateApplicationRecord(ApplicantApplicationReference applicantAndTheirApplication)
	{
		Applicant applicant = applicantAndTheirApplication.getApplicantRef();
		Application application = applicantAndTheirApplication.getApplicationRef();
		PreparedStatement update;
		ResultSet rs = null;
		
		try
		{
			update = con.prepareStatement("UPDATE TABLE applicant SET applicantName = " + applicant.getFirstName() + ", applicantSurname = " + applicant.getSurname() + ", applicantPassword =  " + applicant.getPassword() + ", applicantTitle = " + applicant.getTitle() + ", applicantCitizenship = "  + applicant.getCitizenship() + ", applicantCitizenshipCountry = "  + applicant.getCitizenshipCountry() + ", applicantPassport = "  + ((InternationalApplicant)applicant).getPassport() + ", applicantID = "  + ((SouthAfricanApplicant)applicant).getID() + ", applicantRace = "  + ((SouthAfricanApplicant)applicant).getRace() + ", applicantEmail = "  + applicant.getEmail() + ", applicantCellphone = "  + applicant.getCellPhone() + ", applicantResidenceLineAddress = "  + applicant.getResidenceAddress().getLineAddress() + ", applicantResidenceCountry = "  + applicant.getResidenceAddress().getCountry() + ", previousDegree = " + applicant.getPreviousQualification().getDegree() + ", previousDegreeUniversity = " + applicant.getPreviousQualification().getTertiaryInstitution() + ", previousDegreeCountry = " + applicant.getPreviousQualification().getCountry() + ", previousDegreeDuration = " + applicant.getPreviousQualification().getMinDuration() + ", previousDegreeNQF = " + applicant.getPreviousQualification().getNQFEquivalence() + ", iTExperience = " + ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getPriorITExperience() + ", previousDegreeThesis = " + ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getDescriptionProjectThesis() + ", highestMathLevel = " + ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getHighestLevelUndergradMathematcs() + ", mathLevel1 = " + ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getUndergradMaths()[0] + ", mathLevel2 = " + ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getUndergradMaths()[1] + ", mathLevel3 = " + ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getUndergradMaths()[2] + ";");
			update.executeUpdate();
		}
		
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	/*public ArrayList<ApplicantApplicationReference> filterByLevel(ArrayList<ApplicantApplicationReference> applicantsAndTheirApplications, String level)
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
	}*/
	
	/*public ArrayList<ApplicantApplicationReference> filterByApplicationStatus(ArrayList<ApplicantApplicationReference> applicantsAndTheirApplications, String status)
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
	}*/
}
