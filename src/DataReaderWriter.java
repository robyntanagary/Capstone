import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import com.itextpdf.text.pdf.codec.Base64.InputStream;


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
		initializeMaxAppNum();
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
			e.printStackTrace();
		}
	}
	
	public void initializeMaxAppNum()
	{
		PreparedStatement getMax;
		ResultSet rs;
		
		try
		{
			getMax = con.prepareStatement("SELECT MAX(applicationNumber) FROM capstonedb.application");
			rs = getMax.executeQuery();
			rs.next();
			setMaximumApplicationNumber(rs.getInt("MAX(applicationNumber)") + 1);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public ArrayList<ApplicantApplicationReference> getApplicantsAndTheirApplications()
	{
		PreparedStatement getApplicationNumbers ;
		ResultSet rs;
		ArrayList<ApplicantApplicationReference> list = new ArrayList<ApplicantApplicationReference>();
		
		try
		{
			getApplicationNumbers = con.prepareStatement("SELECT applicationNumber FROM capstonedb.application");
			rs = getApplicationNumbers.executeQuery();
			
			while(rs.next())
			{
				list.add(getApplicantApplicationRefByApplication(rs.getString("applicationNumber")));
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	public FOacademic getAcademic(String staffNumber)
	{
		FOacademic academic = null;
		String academicNumber;
		String academicName;
		String academicSurname;
		String academicPassword;
		String academicTitle;
		String academicEmail;
		String academicCellphone;
		
		PreparedStatement getAcademic;
		ResultSet rs;
		
		try
		{
			getAcademic = con.prepareStatement("SELECT * FROM capstonedb.academic WHERE academicNumber = ?;");
			getAcademic.setString(1, staffNumber);
			rs = getAcademic.executeQuery();
			rs.next();
			academicNumber = rs.getString("academicNumber");
			academicName = rs.getString("academicName");
			academicSurname = rs.getString("academicSurname");
			academicPassword = rs.getString("academicPassword");
			academicTitle = rs.getString("academicTitle");
			academicEmail = rs.getString("academicEmail");
			academicCellphone = rs.getString("academicCellphone");
			
			academic = new FOacademic(academicSurname, academicName, academicNumber, academicPassword, academicTitle, academicEmail, academicCellphone);
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return academic;
	}
	
	/*public void setApplicantsAndTheirApplications(ArrayList<ApplicantApplicationReference> references)
	{
		applicationReferences = references;
	}
	
	public void setAcademics(ArrayList<FOacademic> academics)
	{
		facultyOfficeAcademics = academics;
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
			getApplicant = con.prepareStatement("SELECT * FROM capstonedb.applicant WHERE applicantNumber = ?;");
			getApplicant.setString(1, applicantNumber.toUpperCase());
			rs = getApplicant.executeQuery();
			rs.next();
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
			
			getApplication = con.prepareStatement("SELECT * FROM capstonedb.application WHERE applicantNumber = ?;");
			getApplication.setString(1, applicantNumber.toUpperCase());
			rs2 = getApplication.executeQuery();
			rs2.next();
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
				UndergraduateMathematics[] maths = new UndergraduateMathematics[highestMathLevel];
				boolean hadThesis = !previousDegreeThesis.equals("");
				for (int j = 0; j < highestMathLevel; ++j)
				{
					if (j == 0) maths[0] = new UndergraduateMathematics(1, mathLevel1);
					else if (j == 1) maths[1] = new UndergraduateMathematics(2, mathLevel2);
					else maths[2] = new UndergraduateMathematics(3, mathLevel3);
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
			getApplication = con.prepareStatement("SELECT * FROM capstonedb.application WHERE applicantNumber = ?;");
			getApplication.setString(1, applicantNumber.toUpperCase());
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
			getApplication = con.prepareStatement("SELECT * FROM capstonedb.application WHERE applicationNumber = ?;");
			getApplication.setString(1, appNumber.toUpperCase());
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
	
	public ArrayList<ApplicantApplicationReference> filterLevel(String level, String applicationStatus)
	{
		ArrayList<ApplicantApplicationReference> list = new ArrayList<ApplicantApplicationReference>();
		PreparedStatement filter;
		ResultSet rs;
		
		try
		{
			filter = con.prepareStatement("SELECT applicationNumber FROM capstonedb.application WHERE studyProgram LIKE ? % AND applicationStatus = ?;");//TODO
			filter.setString(1, level);
			filter.setString(2, applicationStatus);
			rs = filter.executeQuery();
			
			while(rs.next())
			{
				list.add(getApplicantApplicationRefByApplication(rs.getString("applicationNumber")));
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList<ApplicantApplicationReference> filterStudyProgram(String studyProgram, String applicationStatus)
	{
		ArrayList<ApplicantApplicationReference> list = new ArrayList<ApplicantApplicationReference>();
		PreparedStatement filter;
		ResultSet rs;
		
		try
		{
			filter = con.prepareStatement("SELECT applicationNumber FROM capstonedb.application WHERE studyProgram = ? AND applicationStatus = ?;");
			filter.setString(1, studyProgram);
			filter.setString(2, applicationStatus);
			rs = filter.executeQuery();
			
			while(rs.next())
			{
				list.add(getApplicantApplicationRefByApplication(rs.getString("applicationNumber")));
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	/**
	 * Method add a new application to array list and textfile
	 * @param applicantAndTheirApplication Specified applicant and their application
	 */
	/*
	 * public void addNewApplicationRecord(ApplicantApplicationReference
	 * applicantAndTheirApplication) {
	 * applicationReferences.add(applicantAndTheirApplication); }
	 */
	
	/**
	 * Method update existing application 
	 * @param applicantAndTheirApplication Specified applicant and their application
	 */
	public void updateApplicationRecord(ApplicantApplicationReference applicantAndTheirApplication)
	{
		Applicant applicant = applicantAndTheirApplication.getApplicantRef();
		Application application = applicantAndTheirApplication.getApplicationRef();
		PreparedStatement updateApplicant;
		PreparedStatement updateApplication;
		
		try
		{
			updateApplicant = con.prepareStatement("REPLACE INTO capstonedb.applicant(applicantNumber, applicantName, applicantSurname, applicantPassword, applicantTitle, applicantEmail, applicantCellphone, applicantResidenceLineAddress, applicantResidenceCountry, previousDegree, previousDegreeUniversity, previousDegreeCountry, previousDegreeDuration, previousDegreeNQF, iTExperience, previousDegreeThesis, highestMathLevel, mathLevel1, mathLevel2, mathLevel3, ) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
			updateApplicant.setString(1, applicant.getApplicantNumber());
			updateApplicant.setString(2, applicant.getFirstName());
			updateApplicant.setString(3, applicant.getSurname());
			updateApplicant.setString(4, applicant.getPassword());
			updateApplicant.setString(5, applicant.getTitle());
			updateApplicant.setString(6, applicant.getEmail());
			updateApplicant.setString(7, applicant.getCellPhone());
			updateApplicant.setString(8, applicant.getResidenceAddress().getLineAddress());
			updateApplicant.setString(9, applicant.getResidenceAddress().getCountry());
			updateApplicant.setString(10, applicant.getPreviousQualification().getDegree());
			updateApplicant.setString(11, applicant.getPreviousQualification().getTertiaryInstitution());
			updateApplicant.setString(12, applicant.getPreviousQualification().getCountry());
			updateApplicant.setInt(13, applicant.getPreviousQualification().getMinDuration());
			updateApplicant.setString(14, applicant.getPreviousQualification().getNQFEquivalence());
			if (applicant.getPreviousQualification() instanceof TertiaryQualificationForMIT) {
				updateApplicant.setInt(15, ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getPriorITExperience());
				updateApplicant.setString(16, ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getDescriptionProjectThesis());
				updateApplicant.setInt(17, ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getHighestLevelUndergradMathematcs());
				updateApplicant.setDouble(18, ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getUndergradMaths()[0].getAverage());
				updateApplicant.setDouble(19, ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getUndergradMaths()[1].getAverage());
				updateApplicant.setDouble(20, ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getUndergradMaths()[2].getAverage());
			} else {
				updateApplicant.setInt(15, 0);
				updateApplicant.setString(16, "");
				updateApplicant.setInt(17, 0);
				updateApplicant.setDouble(18, 0);
				updateApplicant.setDouble(19, 0);
				updateApplicant.setDouble(20, 0);
			}
			//updateApplicant = con.prepareStatement("UPDATE TABLE applicant SET applicantName = " + applicant.getFirstName() + ", applicantSurname = " + applicant.getSurname() + ", applicantPassword =  " + applicant.getPassword() + ", applicantTitle = " + applicant.getTitle() + ", applicantCitizenship = "  + applicant.getCitizenship() + ", applicantCitizenshipCountry = "  + applicant.getCitizenshipCountry() + ", applicantPassport = "  + ((InternationalApplicant)applicant).getPassport() + ", applicantID = "  + ((SouthAfricanApplicant)applicant).getID() + ", applicantRace = "  + ((SouthAfricanApplicant)applicant).getRace() + ", applicantEmail = "  + applicant.getEmail() + ", applicantCellphone = "  + applicant.getCellPhone() + ", applicantResidenceLineAddress = "  + applicant.getResidenceAddress().getLineAddress() + ", applicantResidenceCountry = "  + applicant.getResidenceAddress().getCountry() + ", previousDegree = " + applicant.getPreviousQualification().getDegree() + ", previousDegreeUniversity = " + applicant.getPreviousQualification().getTertiaryInstitution() + ", previousDegreeCountry = " + applicant.getPreviousQualification().getCountry() + ", previousDegreeDuration = " + applicant.getPreviousQualification().getMinDuration() + ", previousDegreeNQF = " + applicant.getPreviousQualification().getNQFEquivalence() + ", iTExperience = " + ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getPriorITExperience() + ", previousDegreeThesis = " + ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getDescriptionProjectThesis() + ", highestMathLevel = " + ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getHighestLevelUndergradMathematcs() + ", mathLevel1 = " + ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getUndergradMaths()[0] + ", mathLevel2 = " + ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getUndergradMaths()[1] + ", mathLevel3 = " + ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getUndergradMaths()[2] + ";");
			updateApplicant.executeUpdate();
			
			updateApplication = con.prepareStatement("REPLACE INTO capstonedb.application(applicationNumber, applicantNumber, studyProgram, applicationStatus, statusReason) "
					+ "VALUES(?, ?, ?, ?, ?);");
			updateApplication.setString(1, application.getApplicationNumber());
			updateApplication.setString(2, application.getApplicantNumber());
			updateApplication.setString(3, application.getStudyProgram().getAcademicQualification());
			updateApplication.setString(4, application.getApplicationStatus().getStatusDescripition());
			updateApplication.setString(5, application.getApplicationStatus().getReasonDescription());
			//updateApplication = con.prepareStatement("UPDATE TABLE application SET applicationNumber = " + application.getApplicationNumber() + ", applicantNumber = " + application.getApplicantNumber() + ", studyProgram = " + application.getStudyProgram() + ", applicationStatus = " + application.getApplicationStatus().getStatusDescripition() + ", statusReason = " + application.getApplicationStatus().getReasonDescription() + ";");
			updateApplication.executeUpdate();
		}
		
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void updateApplicationRecordSA(ApplicantApplicationReference applicantAndTheirApplication)
	{
		Applicant applicant = applicantAndTheirApplication.getApplicantRef();
		Application application = applicantAndTheirApplication.getApplicationRef();
		PreparedStatement updateApplicant;
		PreparedStatement updateApplication;
		
		try
		{
			updateApplicant = con.prepareStatement("REPLACE INTO capstonedb.applicant(applicantNumber, applicantName, applicantSurname, applicantPassword, applicantTitle, applicantCitizenship, applicantCitizenshipCountry, applicantID, applicantRace, applicantEmail, applicantCellphone, applicantResidenceLineAddress, applicantResidenceCountry, previousDegree, previousDegreeUniversity, previousDegreeCountry, previousDegreeDuration, previousDegreeNQF, iTExperience, previousDegreeThesis, highestMathLevel, mathLevel1, mathLevel2, mathLevel3, ) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
			updateApplicant.setString(1, applicant.getApplicantNumber());
			updateApplicant.setString(2, applicant.getFirstName());
			updateApplicant.setString(3, applicant.getSurname());
			updateApplicant.setString(4, applicant.getPassword());
			updateApplicant.setString(5, applicant.getTitle());
			updateApplicant.setString(6, applicant.getCitizenship());
			updateApplicant.setString(7, applicant.getCitizenshipCountry());
			updateApplicant.setString(8, ((SouthAfricanApplicant)applicant).getID());
			updateApplicant.setString(9, ((SouthAfricanApplicant)applicant).getRace());
			updateApplicant.setString(10, applicant.getEmail());
			updateApplicant.setString(11, applicant.getCellPhone());
			updateApplicant.setString(12, applicant.getResidenceAddress().getLineAddress());
			updateApplicant.setString(13, applicant.getResidenceAddress().getCountry());
			updateApplicant.setString(14, applicant.getPreviousQualification().getDegree());
			updateApplicant.setString(15, applicant.getPreviousQualification().getTertiaryInstitution());
			updateApplicant.setString(16, applicant.getPreviousQualification().getCountry());
			updateApplicant.setInt(17, applicant.getPreviousQualification().getMinDuration());
			updateApplicant.setString(18, applicant.getPreviousQualification().getNQFEquivalence());
			if (applicant.getPreviousQualification() instanceof TertiaryQualificationForMIT) {
				updateApplicant.setInt(19, ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getPriorITExperience());
				updateApplicant.setString(20, ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getDescriptionProjectThesis());
				updateApplicant.setInt(21, ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getHighestLevelUndergradMathematcs());
				updateApplicant.setDouble(22, ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getUndergradMaths()[0].getAverage());
				updateApplicant.setDouble(23, ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getUndergradMaths()[1].getAverage());
				updateApplicant.setDouble(24, ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getUndergradMaths()[2].getAverage());
			} else {
				updateApplicant.setInt(19, 0);
				updateApplicant.setString(20, "");
				updateApplicant.setInt(21, 0);
				updateApplicant.setDouble(22, 0);
				updateApplicant.setDouble(23, 0);
				updateApplicant.setDouble(24, 0);
			}
			//updateApplicant = con.prepareStatement("UPDATE TABLE applicant SET applicantName = " + applicant.getFirstName() + ", applicantSurname = " + applicant.getSurname() + ", applicantPassword =  " + applicant.getPassword() + ", applicantTitle = " + applicant.getTitle() + ", applicantCitizenship = "  + applicant.getCitizenship() + ", applicantCitizenshipCountry = "  + applicant.getCitizenshipCountry() + ", applicantPassport = "  + ((InternationalApplicant)applicant).getPassport() + ", applicantID = "  + ((SouthAfricanApplicant)applicant).getID() + ", applicantRace = "  + ((SouthAfricanApplicant)applicant).getRace() + ", applicantEmail = "  + applicant.getEmail() + ", applicantCellphone = "  + applicant.getCellPhone() + ", applicantResidenceLineAddress = "  + applicant.getResidenceAddress().getLineAddress() + ", applicantResidenceCountry = "  + applicant.getResidenceAddress().getCountry() + ", previousDegree = " + applicant.getPreviousQualification().getDegree() + ", previousDegreeUniversity = " + applicant.getPreviousQualification().getTertiaryInstitution() + ", previousDegreeCountry = " + applicant.getPreviousQualification().getCountry() + ", previousDegreeDuration = " + applicant.getPreviousQualification().getMinDuration() + ", previousDegreeNQF = " + applicant.getPreviousQualification().getNQFEquivalence() + ", iTExperience = " + ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getPriorITExperience() + ", previousDegreeThesis = " + ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getDescriptionProjectThesis() + ", highestMathLevel = " + ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getHighestLevelUndergradMathematcs() + ", mathLevel1 = " + ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getUndergradMaths()[0] + ", mathLevel2 = " + ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getUndergradMaths()[1] + ", mathLevel3 = " + ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getUndergradMaths()[2] + ";");
			updateApplicant.executeUpdate();
			
			updateApplication = con.prepareStatement("REPLACE INTO capstonedb.application(applicationNumber, applicantNumber, studyProgram, applicationStatus, statusReason) "
					+ "VALUES(?, ?, ?, ?, ?);");
			updateApplication.setString(1, application.getApplicationNumber());
			updateApplication.setString(2, application.getApplicantNumber());
			updateApplication.setString(3, application.getStudyProgram().getAcademicQualification());
			updateApplication.setString(4, application.getApplicationStatus().getStatusDescripition());
			updateApplication.setString(5, application.getApplicationStatus().getReasonDescription());
			//updateApplication = con.prepareStatement("UPDATE TABLE application SET applicationNumber = " + application.getApplicationNumber() + ", applicantNumber = " + application.getApplicantNumber() + ", studyProgram = " + application.getStudyProgram() + ", applicationStatus = " + application.getApplicationStatus().getStatusDescripition() + ", statusReason = " + application.getApplicationStatus().getReasonDescription() + ";");
			updateApplication.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void updateApplicationRecordInt(ApplicantApplicationReference applicantAndTheirApplication)
	{
		Applicant applicant = applicantAndTheirApplication.getApplicantRef();
		Application application = applicantAndTheirApplication.getApplicationRef();
		PreparedStatement updateApplicant;
		PreparedStatement updateApplication;
		
		try
		{
			updateApplicant = con.prepareStatement("REPLACE INTO capstonedb.applicant(applicantNumber, applicantName, applicantSurname, applicantPassword, applicantTitle, applicantCitizenship, applicantCitizenshipCountry, applicantPassport, applicantEmail, applicantCellphone, applicantResidenceLineAddress, applicantResidenceCountry, previousDegree, previousDegreeUniversity, previousDegreeCountry, previousDegreeDuration, previousDegreeNQF, iTExperience, previousDegreeThesis, highestMathLevel, mathLevel1, mathLevel2, mathLevel3, ) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
			updateApplicant.setString(1, applicant.getApplicantNumber());
			updateApplicant.setString(2, applicant.getFirstName());
			updateApplicant.setString(3, applicant.getSurname());
			updateApplicant.setString(4, applicant.getPassword());
			updateApplicant.setString(5, applicant.getTitle());
			updateApplicant.setString(6, applicant.getCitizenship());
			updateApplicant.setString(7, applicant.getCitizenshipCountry());
			updateApplicant.setString(8, ((InternationalApplicant)applicant).getPassport());
			updateApplicant.setString(9, applicant.getEmail());
			updateApplicant.setString(10, applicant.getCellPhone());
			updateApplicant.setString(11, applicant.getResidenceAddress().getLineAddress());
			updateApplicant.setString(12, applicant.getResidenceAddress().getCountry());
			updateApplicant.setString(13, applicant.getPreviousQualification().getDegree());
			updateApplicant.setString(14, applicant.getPreviousQualification().getTertiaryInstitution());
			updateApplicant.setString(15, applicant.getPreviousQualification().getCountry());
			updateApplicant.setInt(16, applicant.getPreviousQualification().getMinDuration());
			updateApplicant.setString(17, applicant.getPreviousQualification().getNQFEquivalence());
			if (applicant.getPreviousQualification() instanceof TertiaryQualificationForMIT) {
				updateApplicant.setInt(18, ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getPriorITExperience());
				updateApplicant.setString(19, ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getDescriptionProjectThesis());
				updateApplicant.setInt(20, ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getHighestLevelUndergradMathematcs());
				updateApplicant.setDouble(21, ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getUndergradMaths()[0].getAverage());
				updateApplicant.setDouble(22, ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getUndergradMaths()[1].getAverage());
				updateApplicant.setDouble(23, ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getUndergradMaths()[2].getAverage());
			} else {
				updateApplicant.setInt(18, 0);
				updateApplicant.setString(19, "");
				updateApplicant.setInt(20, 0);
				updateApplicant.setDouble(21, 0);
				updateApplicant.setDouble(22, 0);
				updateApplicant.setDouble(23, 0);
			}
			//updateApplicant = con.prepareStatement("UPDATE TABLE applicant SET applicantName = " + applicant.getFirstName() + ", applicantSurname = " + applicant.getSurname() + ", applicantPassword =  " + applicant.getPassword() + ", applicantTitle = " + applicant.getTitle() + ", applicantCitizenship = "  + applicant.getCitizenship() + ", applicantCitizenshipCountry = "  + applicant.getCitizenshipCountry() + ", applicantPassport = "  + ((InternationalApplicant)applicant).getPassport() + ", applicantID = "  + ((SouthAfricanApplicant)applicant).getID() + ", applicantRace = "  + ((SouthAfricanApplicant)applicant).getRace() + ", applicantEmail = "  + applicant.getEmail() + ", applicantCellphone = "  + applicant.getCellPhone() + ", applicantResidenceLineAddress = "  + applicant.getResidenceAddress().getLineAddress() + ", applicantResidenceCountry = "  + applicant.getResidenceAddress().getCountry() + ", previousDegree = " + applicant.getPreviousQualification().getDegree() + ", previousDegreeUniversity = " + applicant.getPreviousQualification().getTertiaryInstitution() + ", previousDegreeCountry = " + applicant.getPreviousQualification().getCountry() + ", previousDegreeDuration = " + applicant.getPreviousQualification().getMinDuration() + ", previousDegreeNQF = " + applicant.getPreviousQualification().getNQFEquivalence() + ", iTExperience = " + ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getPriorITExperience() + ", previousDegreeThesis = " + ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getDescriptionProjectThesis() + ", highestMathLevel = " + ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getHighestLevelUndergradMathematcs() + ", mathLevel1 = " + ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getUndergradMaths()[0] + ", mathLevel2 = " + ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getUndergradMaths()[1] + ", mathLevel3 = " + ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getUndergradMaths()[2] + ";");
			updateApplicant.executeUpdate();
			
			updateApplication = con.prepareStatement("REPLACE INTO capstonedb.application(applicationNumber, applicantNumber, studyProgram, applicationStatus, statusReason) "
					+ "VALUES(?, ?, ?, ?, ?);");
			updateApplication.setString(1, application.getApplicationNumber());
			updateApplication.setString(2, application.getApplicantNumber());
			updateApplication.setString(3, application.getStudyProgram().getAcademicQualification());
			updateApplication.setString(4, application.getApplicationStatus().getStatusDescripition());
			updateApplication.setString(5, application.getApplicationStatus().getReasonDescription());
			//updateApplication = con.prepareStatement("UPDATE TABLE application SET applicationNumber = " + application.getApplicationNumber() + ", applicantNumber = " + application.getApplicantNumber() + ", studyProgram = " + application.getStudyProgram() + ", applicationStatus = " + application.getApplicationStatus().getStatusDescripition() + ", statusReason = " + application.getApplicationStatus().getReasonDescription() + ";");
			updateApplication.executeUpdate();
		}
		
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean writePDFtoDB(File file, String applicationNumber)
	{
		String query = "UPDATE capstonedb.pdf SET pdfFile = ?  WHERE applicationNumber = ?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(query);
			FileInputStream input = new FileInputStream(file);

			// set parameters
			ps.setBinaryStream(1, input);
			ps.setString(2, applicationNumber);
			ps.executeUpdate();

			ps.close();
		} catch (SQLException | FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean readPDFfromDB(File file, String applicationNumber)
	{
		String query = "SELECT pdfFile FROM capstonedb.pdf WHERE applicationNumber = ?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(query);
			FileOutputStream output = new FileOutputStream(file);

			ps.setString(1, applicationNumber);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				InputStream input = (InputStream) rs.getBinaryStream("pdf");
				byte[] buffer = new byte[1024];
				while (input.read(buffer) > 0) {
					output.write(buffer);
				}
			}
			output.close();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
