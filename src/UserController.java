
public class UserController {
	/**
	 * Method creates a controller object responsible for managing applicants and academics.
	 */
	private Applicant applicant;
	private SouthAfricanApplicant rsaApplicant;
	private InternationalApplicant internationalApplicant;
	private FOacademic academic;
	private DataReaderWriter dataAccess;
	
	public UserController()
	{
		applicant = new Applicant();
		academic = new FOacademic();
	}
	
	public UserController(DataReaderWriter data)
	{
		this();
		dataAccess = data;
	}
	
	public boolean isApplicant(String applicantNumber, String password)
	{
		return false; //needs logic!!!
	}
	
	/**
	 * Method returns applicant object having the corresponding applicant number.
	 * @param applicantNumber Specifies the applicant to be return.
	 * @return Applicant having the specified applicant number.
	 */
	public Applicant getApplicant(String applicantNumber)
	{
		return applicant; //needs logic!!!
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
		return false; //needs logic!!!
	}
	
	public FOacademic getFOacademic(String staffNumber)
	{
		return academic; //needs logic!!!
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
		return internationalApplicant; //needs logic!!!
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
		return rsaApplicant; //needs logic!!!
	}
	
	/**
	 * Method makes the provided international applicant the applicant of focus.
	 * @param applicant Specified international applicant to focus on.
	 */
	public void setInternationalApplicantOfFocus(InternationalApplicant internationalApplicant)
	{
		this.internationalApplicant = internationalApplicant;
	}
	
	public boolean registerNewApplicant(String applicantNumber, String email, String password, String confirmPassword)
	{
		if (password.equals(confirmPassword))
		{
			applicant = new Applicant(applicantNumber, email, password, confirmPassword);
			Application theirApplication = new Application();
			dataAccess.getApplicantsAndTheirApplications().add(new ApplicantApplicationReference(applicant, theirApplication));
			return true;
		}
		return false;
	}
	
	public boolean insertOrUpdateApplicant(Applicant applicant)
	{
		//needs logic!!!
		return true;
	}
	
	public boolean insertOrUpdateInternationalApplicant(InternationalApplicant internationalApplicant)
	{
		//needs logic!!!
		return true;
	}
	
	public boolean insertOrUpdateSouthAfricanApplicant(SouthAfricanApplicant southAfricanApplicant)
	{
		//needs logic!!!
		return true;
	}
}
