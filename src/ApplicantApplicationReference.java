/**
 * Class manages mapping between applicants and applications.
 * @author FYTTAN001, LXXWEN005, MCKROB018
 */
public class ApplicantApplicationReference
{
	private Applicant applicantRef;
	private Application applicationRef;
	
	public ApplicantApplicationReference(Applicant applicantRef, Application applicationRef)
	{
		//instantiate fields
		this.applicantRef = applicantRef;
		this.applicationRef = applicationRef;
	}

	/**
	 * @return the applicantRef
	 */
	public Applicant getApplicantRef() {
		return applicantRef;
	}

	/**
	 * @param applicantRef the applicantRef to set
	 */
	public void setApplicantRef(Applicant applicantRef) {
		this.applicantRef = applicantRef;
	}

	/**
	 * @return the applicationRef
	 */
	public Application getApplicationRef() {
		return applicationRef;
	}

	/**
	 * @param applicationRef the applicationRef to set
	 */
	public void setApplicationRef(Application applicationRef) {
		this.applicationRef = applicationRef;
	}
}