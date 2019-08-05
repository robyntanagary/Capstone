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
		System.out.println("tracer UserController 27 " + applicantNumber + password);
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
		ArrayList<FOacademic> FOacademics = dataAccess.getAcademics();
		FOacademics.trimToSize();
		for (int i=0; i<FOacademics.size(); i++)
		{
			if ((FOacademics.get(i).getStaffNumber().equalsIgnoreCase(staffNumber)) && (FOacademics.get(i).getPassword().equals(password))) {return true; }
		}
		return false; 
	}
	
	public FOacademic getFOacademic(String staffNumber)
	{
		ArrayList<FOacademic> FOacademics = dataAccess.getAcademics();
		FOacademics.trimToSize();
		for (int i=0; i<FOacademics.size(); i++)
		{
			if ((FOacademics.get(i).getStaffNumber().equalsIgnoreCase(staffNumber))) 
			{	
				academic = FOacademics.get(i);
				return academic; }
		}
		return null;
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
			return null;
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
		dataAccess.getApplicantApplicationRefByApplicant(applicant.getApplicantNumber()).setApplicantRef(applicant);
		return true;
	}
	
	public boolean insertOrUpdateInternationalApplicant(InternationalApplicant intApplicant)
	{
		dataAccess.getApplicantApplicationRefByApplicant(intApplicant.getApplicantNumber()).setApplicantRef(intApplicant);
		return true;
	}
	
	public boolean insertOrUpdateSouthAfricanApplicant(SouthAfricanApplicant southAfricanApplicant)
	{
		dataAccess.getApplicantApplicationRefByApplicant(southAfricanApplicant.getApplicantNumber()).setApplicantRef(southAfricanApplicant);
		return true;
	}
}
