public class UserController {
	
	private Applicant applicant;
	private FOacademic academic;
	private DataReaderWriter dataAccess;
	
	/**
	 * Method creates a controller object responsible for managing applicants and academics.
	 */
	public UserController(DataReaderWriter data)
	{
		//this();
		dataAccess = data;
	}
	
	public boolean isApplicant(String applicantNumber, String password, String email)
	{
		if(dataAccess.getApplicant(applicantNumber) == null)
		{
			return false;
		}
		return dataAccess.getApplicant(applicantNumber).getPassword().equals(password) && dataAccess.getApplicant(applicantNumber).getEmail().equals(email);
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
	
	public boolean isFOacademic(String staffNumber, String password, String email)
	{
		FOacademic academic = dataAccess.getAcademic(staffNumber);
		
		if(academic == null)
		{
			return false;
		}
		
		if (academic.getPassword().equals(password) && academic.getEmail().equals(email))
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
}
