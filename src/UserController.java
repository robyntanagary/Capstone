import java.util.ArrayList;

public class UserController {
	/**
	 * Method creates a controller object responsible for managing applicants and academics.
	 */
	private Applicant applicant;
	private SouthAfricanApplicant rsaApplicant;
	private InternationalApplicant internationalApplicant;
	private FOacademic academic;
	private DataReaderWriter dataAccess;
	
//	public UserController()
//	{
//		applicant = new Applicant();
//		academic = new FOacademic();
//	}
	
	public UserController(DataReaderWriter data)
	{
		//this();
		dataAccess = data;
	}
	
	public boolean isApplicant(String applicantNumber, String password)
	{
		return (dataAccess.getApplicantApplicationRefByApplicant(applicantNumber)!=null) && (dataAccess.getApplicantApplicationRefByApplicant(applicantNumber).getApplicantRef().getPassword().equals(password));
	}
	
	/**
	 * Method returns applicant object having the corresponding applicant number.
	 * @param applicantNumber Specifies the applicant to be return.
	 * @return Applicant having the specified applicant number.
	 */
	public Applicant getApplicant(String applicantNumber)
	{
		return dataAccess.getApplicantApplicationRefByApplicant(applicantNumber).getApplicantRef();
	}
	
	/**
	 * Method makes the provided applicant the applicant of focus.
	 * @param applicant Specified applicant to focus on.
	 */
	public void setApplicantOfFocus(Applicant applicant)
	{
		this.applicant = applicant;
	}
	
	public boolean isFOacademic(String staffNumber, String password)
	{
		FOacademic academic = dataAccess.getAcademic(staffNumber);
		
		if (academic.getStaffNumber().equalsIgnoreCase(staffNumber) && (academic.getPassword().equals(password)))
		{
			return true;
		}
		
		return false; 
	}
	
	public FOacademic getFOacademic(String staffNumber)
	{
		FOacademic academic = dataAccess.getAcademic(staffNumber);
		
		return academic;
	}
	
	/**
	 * Sets the logged-in academic as the academic who processed the application whose statuses he / she changes during this session.
	 * @param academic Specified academic processing applications by changing their statuses. 
	 */
	public void setFOAcademicEvaluating(FOacademic academic)
	{
		this.academic = academic; 
	}
	
	public InternationalApplicant getInternationalApplicant(String applicantNumber)
	{
		Applicant app = dataAccess.getApplicantApplicationRefByApplicant(applicantNumber).getApplicantRef();
		if ((app != null) && (app.getCitizenship().equalsIgnoreCase("International")))
		{
			internationalApplicant = (InternationalApplicant) app;
			return internationalApplicant;
		}
		return null;
	}
	
	/**
	 * Method makes the provided South African applicant the applicant of focus.
	 * @param applicant Specified South African applicant to focus on.
	 */
	public void setSouthAfricanApplicantOfFocus(SouthAfricanApplicant rsaApplicant)
	{
		this.rsaApplicant = rsaApplicant;
	}
	
	public SouthAfricanApplicant getSouthAfricanApplicant(String applicantNumber)
	{
		Applicant app = dataAccess.getApplicantApplicationRefByApplicant(applicantNumber).getApplicantRef();
		if ((app != null) && (app.getCitizenship().contains("South African")))
		{
			rsaApplicant = (SouthAfricanApplicant) app;
			return (SouthAfricanApplicant)app;
		}
		return null;
	}
	
	/**
	 * Method makes the provided international applicant the applicant of focus.
	 * @param applicant Specified international applicant to focus on.
	 */
	public void setInternationalApplicantOfFocus(InternationalApplicant internationalApplicant)
	{
		this.internationalApplicant = internationalApplicant;
	}
	
	public Applicant registerNewApplicant(String applicantNumber, String email, String password, String confirmPassword)
	{
		if (password.equals(confirmPassword))
		{
			applicant = new Applicant(applicantNumber, email, password, confirmPassword);
			//Application theirApplication = new Application();
			//dataAccess.getApplicantsAndTheirApplications().add(new ApplicantApplicationReference(applicant, theirApplication));
			//with DB, insert new applicant
			return applicant;
		}
		return null;
	}
	
//	public boolean insertOrUpdateApplicant(Applicant applicant)
//	{
//		dataAccess.addNewApplicationRecord(dataAccess.getApplicantApplicationRefByApplicant(applicant.getApplicantNumber()));
//		return true;
//	}
//	
//	public boolean insertOrUpdateInternationalApplicant(InternationalApplicant intApplicant)
//	{
//		dataAccess.addNewApplicationRecord(dataAccess.getApplicantApplicationRefByApplicant(intApplicant.getApplicantNumber()));
//		return true;
//	}
//	
//	public boolean insertOrUpdateSouthAfricanApplicant(SouthAfricanApplicant southAfricanApplicant)
//	{
//		dataAccess.addNewApplicationRecord(dataAccess.getApplicantApplicationRefByApplicant(southAfricanApplicant.getApplicantNumber()));
//		return true;
//	}
}
