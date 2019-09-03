/**
 * Class UserController manages applicants and academics as well as the sign-in/sign-up
 * process involved.
 * @author  FYTTAN001, LXXWEN005, MCKROB018
 */
public class UserController {
	
	private Applicant applicant;
	private FOacademic academic;
	private DataReaderWriter dataAccess;
	
	/**
	 * Method creates a UserController object.
	 */
	public UserController(DataReaderWriter data)
	{
		dataAccess = data;
	}
	
	/**
	 * Checks if the given parameters specify an applicant that currently exists in the system.
	 * @param applicantNumber The number of the applicant.
	 * @param password The password of the applicant.
	 * @param email The email of the applicant.
	 * @return Whether or not the given parameters specify an applicant that currently exists in the system.
	 */
	public boolean isApplicant(String applicantNumber, String password, String email)
	{
		if(dataAccess.getApplicant(applicantNumber) == null)
		{
			return false;
		}
		return dataAccess.getApplicant(applicantNumber).getPassword().equals(password) && dataAccess.getApplicant(applicantNumber).getEmail().equals(email);
	}
	
	/**
	 * Method returns an applicant object which corresponds to the given applicant number.
	 * @param applicantNumber The number of the applicant.
	 * @return The applicant object which corresponds to the given applicant number.
	 */
	public Applicant getApplicant(String applicantNumber)
	{
		return dataAccess.getApplicantApplicationRefByApplicant(applicantNumber).getApplicantRef();
	}
	
	/**
	 * Sets the provided applicant as the applicant of focus.
	 * @param applicant Specified applicant to focus on.
	 */
	public void setApplicantOfFocus(Applicant applicant)
	{
		this.applicant = applicant;
	}
	
	/**
	 * Checks if the given parameters specify an academic that currently exists in the system.
	 * @param staffNumber The number of the academic.
	 * @param password The password of the academic.
	 * @param email The email of the academic.
	 * @return Whether or not the given parameters specify an academic that currently exists in the system.
	 */
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
	
	/**
	 * Method returns an academic object which corresponds to the given staff number.
	 * @param staffNumber The number of the academic.
	 * @return The academic object which corresponds to the given staff number.
	 */
	public FOacademic getFOacademic(String staffNumber)
	{
		FOacademic academic = dataAccess.getAcademic(staffNumber);
		return academic;
	}
	
	/**
	 * Sets the given academic as the academic who processed the applications whose statuses 
	 * he/she changed during this session.
	 * @param academic Specified academic who is processing applications. 
	 */
	public void setFOAcademicEvaluating(FOacademic academic)
	{
		this.academic = academic; 
	}
	
	/**
	 * Creates and returns a new applicant object using the supplied fields.
	 * @param applicantNumber The number of the new applicant.
	 * @param email The email of the new applicant.
	 * @param password The password of the new applicant.
	 * @param confirmPassword The confirmed password of the new applicant.
	 * @return The new applicant object.
	 */
	public Applicant registerNewApplicant(String applicantNumber, String email, String password, String confirmPassword)
	{
		if (password.equals(confirmPassword))
		{
			applicant = new Applicant(applicantNumber, email, password, confirmPassword);
			return applicant;
		}
		return null;
	}
}
