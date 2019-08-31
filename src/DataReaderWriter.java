import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.sql.*;

public class DataReaderWriter {
	public int maxApplicationNumber;
	static Connection con = null;
	static String dbName = "";
	static String url = "jdbc:mysql://localhost:3306/?allowPublicKeyRetrieval=true&useSSL=false" + dbName;
	static String username = "root";
	static String password = "root";
	
	public DataReaderWriter()
	{
		maxApplicationNumber = 0;
		connectToDB();
		initializeMaxAppNum();
	}
	
	private void connectToDB()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Successfully connected to the database");
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
			if(rs.next())
			{
				if(rs.getString("academicNumber").equals(""))
				{
					return null;
				}
				
				academicNumber = rs.getString("academicNumber");
				academicName = rs.getString("academicName");
				academicSurname = rs.getString("academicSurname");
				academicPassword = rs.getString("academicPassword");
				academicTitle = rs.getString("academicTitle");
				academicEmail = rs.getString("academicEmail");
				academicCellphone = rs.getString("academicCellphone");
				
				academic = new FOacademic(academicSurname, academicName, academicNumber, academicPassword, academicTitle, academicEmail, academicCellphone);
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return academic;
	}
	
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
			
			if(rs.next())
			{
				if(rs.getString("applicantNumber").equals(""))
				{
					return null;
				}
				
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
				previousDegree = rs.getString("previousDegree");
				previousDegreeUniversity = rs.getString("previousDegreeUniversity");
				previousDegreeCountry = rs.getString("previousDegreeCountry");
				previousDegreeDuration = rs.getInt("previousDegreeDuration");
				previousDegreeNQF = rs.getString("previousDegreeNQF");
				
				getApplication = con.prepareStatement("SELECT * FROM capstonedb.application WHERE applicantNumber = ?;");
				getApplication.setString(1, applicantNumber.toUpperCase());
				rs2 = getApplication.executeQuery();
				
				if(rs2.next())
				{
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
			}
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return applicant;
	}
	/**
	 * 
	 * @param applicantNumber The applicant number of of the Application to be fetched.
	 * @return The fetched Application.
	 */
	public Application getApplicationOfApplicant(String applicantNumber)
	{
		PreparedStatement getApplication;
		ResultSet rs = null;
		String applicationNumber = "";
		String applicantNum = "";
		String applicationStatus = "";
		String statusReason = "";
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
				statusReason = rs.getString("statusReason");
			}
			
			application = new Application(applicationNumber, applicantNum, applicationStatus, statusReason, studyProgram);
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return application;
	}
	/**
	 * 
	 * @param appNumber The application number of the Application to be fetched.
	 * @return The fetched application.
	 */
	public Application getApplicationOfApplicant2(String appNumber)
	{
		PreparedStatement getApplication;
		ResultSet rs = null;
		String applicationNumber = "";
		String applicantNum = "";
		String applicationStatus = "";
		String statusReason = "";
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
				statusReason = rs.getString("statusReason");
			}
			
			application = new Application(applicationNumber, applicantNum, applicationStatus, statusReason, studyProgram);
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
			filter = con.prepareStatement("SELECT applicationNumber FROM capstonedb.application WHERE studyProgram LIKE ? AND applicationStatus = ?;");
			filter.setString(1, level + "%");
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
		System.out.println("omghello?");
		try
		{
			filter = con.prepareStatement("SELECT applicationNumber FROM capstonedb.application WHERE studyProgram = ? AND applicationStatus = ?;");
			filter.setString(1, studyProgram);
			filter.setString(2, applicationStatus);
			rs = filter.executeQuery();
			
			while(rs.next())
			{
				System.out.println(rs.getString("applicationNumber"));
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
			updateApplicant = con.prepareStatement("REPLACE INTO capstonedb.applicant(applicantNumber, applicantName, applicantSurname, applicantPassword, applicantTitle, applicantCitizenship, applicantCitizenshipCountry, applicantPassport, applicantID, applicantRace, applicantEmail, applicantCellphone, applicantResidenceLineAddress, applicantResidenceCountry, previousDegree, previousDegreeUniversity, previousDegreeCountry, previousDegreeDuration, previousDegreeNQF, iTExperience, previousDegreeThesis, highestMathLevel, mathLevel1, mathLevel2, mathLevel3) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
			updateApplicant.setString(1, applicant.getApplicantNumber());
			updateApplicant.setString(2, applicant.getFirstName());
			updateApplicant.setString(3, applicant.getSurname());
			updateApplicant.setString(4, applicant.getPassword());
			updateApplicant.setString(5, applicant.getTitle());
			updateApplicant.setString(6, applicant.getCitizenship());
			updateApplicant.setString(7, applicant.getCitizenshipCountry());
			if (applicant instanceof InternationalApplicant) {
				updateApplicant.setString(8, ((InternationalApplicant)applicant).getPassport());
				updateApplicant.setString(9, "");
				updateApplicant.setString(10, "");
			} else if (applicant instanceof SouthAfricanApplicant) {
				updateApplicant.setString(8, "");
				updateApplicant.setString(9, ((SouthAfricanApplicant)applicant).getID());
				updateApplicant.setString(10, ((SouthAfricanApplicant)applicant).getRace());
			} else {
				updateApplicant.setString(8, "");
				updateApplicant.setString(9, "");
				updateApplicant.setString(10, "");
			}
			updateApplicant.setString(11, applicant.getEmail());
			updateApplicant.setString(12, applicant.getCellPhone());
			updateApplicant.setString(13, applicant.getResidenceAddress().getLineAddress());
			updateApplicant.setString(14, applicant.getResidenceAddress().getCountry());
			updateApplicant.setString(15, applicant.getPreviousQualification().getDegree());
			updateApplicant.setString(16, applicant.getPreviousQualification().getTertiaryInstitution());
			updateApplicant.setString(17, applicant.getPreviousQualification().getCountry());
			updateApplicant.setInt(18, applicant.getPreviousQualification().getMinDuration());
			updateApplicant.setString(19, applicant.getPreviousQualification().getNQFEquivalence());
			if (applicant.getPreviousQualification() instanceof TertiaryQualificationForMIT) {
				updateApplicant.setInt(20, ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getPriorITExperience());
				updateApplicant.setString(21, ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getDescriptionProjectThesis());
				updateApplicant.setInt(22, ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getHighestLevelUndergradMathematcs());
				for (int i = 0; i < 3; ++i) {
					if (((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getHighestLevelUndergradMathematcs() > i) {
						updateApplicant.setDouble(23+i, ((TertiaryQualificationForMIT)applicant.getPreviousQualification()).getUndergradMaths()[i].getAverage());
					} else {
						updateApplicant.setDouble(23+i, 0);
					}
				}
			} else {
				updateApplicant.setInt(20, 0);
				updateApplicant.setString(21, "");
				updateApplicant.setInt(22, 0);
				updateApplicant.setDouble(23, 0);
				updateApplicant.setDouble(24, 0);
				updateApplicant.setDouble(25, 0);
			}
			updateApplicant.executeUpdate();
			
			updateApplication = con.prepareStatement("REPLACE INTO capstonedb.application(applicationNumber, applicantNumber, studyProgram, applicationStatus, statusReason) "
					+ "VALUES(?, ?, ?, ?, ?);");
			updateApplication.setString(1, application.getApplicationNumber());
			updateApplication.setString(2, application.getApplicantNumber());
			updateApplication.setString(3, application.getStudyProgram().getAcademicQualification());
			updateApplication.setString(4, application.getApplicationStatus().getStatusDescripition());
			updateApplication.setString(5, application.getApplicationStatus().getReasonDescription());
			updateApplication.executeUpdate();
		}
		
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Accesses the database and writes to the pdfFile column of the pdf table. The entry will be added if it is not currently present.
	 * @param file The PDF file to be uploaded
	 * @param applicationNumber The application corresponding to the PDF to be saved.
	 * @return Whether the file was successfully saved or not.
	 */
	public boolean writePDFtoDB(File file, String applicationNumber)
	{
		//TODO
		PreparedStatement check;
		PreparedStatement add;
		PreparedStatement update;
		try
		{
			//check if the applicationUmber is already in the database
			check = con.prepareStatement("SELECT * from capstonedb.pdf WHERE applicationNumber = ?;");
			check.setString(1, applicationNumber);
			ResultSet rs = check.executeQuery();
			if (!rs.first()) {
				add = con.prepareStatement("INSERT INTO capstonedb.pdf(applicationNumber, pdfFile) " + 
						"VALUES (?, ?);");
				add.setString(1, applicationNumber);
				add.setNull(2, Types.BLOB);
				add.executeUpdate();
			}
			update = con.prepareStatement("UPDATE capstonedb.pdf SET pdfFile = ?  WHERE applicationNumber = ?;");
			FileInputStream input = new FileInputStream(file);

			update.setBinaryStream(1, input);
			update.setString(2, applicationNumber);
			update.executeUpdate();

			update.close();
			input.close();
		} catch (SQLException | IOException e) {
			return false;
		}
		return true;
	}
	/**
	 * Accesses the database and reads from the pdfFile column of the pdf table.
	 * @param file The location to which the file will be saved.
	 * @param applicationNumber The application corresponding to the requested PDF.
	 * @return Whether the file was successfully saved or not.
	 */
	public boolean readPDFfromDB(File file, String applicationNumber)
	{
		//TODO
		PreparedStatement select;
		try {
			select = con.prepareStatement("SELECT pdfFile FROM capstonedb.pdf WHERE applicationNumber = ?;");
			FileOutputStream output = new FileOutputStream(file);

			select.setString(1, applicationNumber);
			ResultSet rs = select.executeQuery();

			if (rs.first()) {
				InputStream input = (InputStream) rs.getBinaryStream("pdfFile");
				byte[] buffer = new byte[1024];
				while (input.read(buffer) > 0) {
					output.write(buffer);
				}
			}
			output.close();
			select.close();
		} catch (SQLException | IOException e) {
			return false;
		}
		return true;
	}
}
