/**
 * Class InternationalApplicant models international applicants, it is a subclass of Applicant.
 * @author FYTTAN001, LXXWEN005, MCKROB018
 */
public class InternationalApplicant extends Applicant {
	private String passport;
	
	/**
	 * No parameter constructor, creates a basic international applicant.
	 */
	public InternationalApplicant()
	{
		super();
		setPassport("");
	}
	
	/**
	 * Creates an international applicant using all the available details from an applicant object.
	 * @param applicant The applicant object to copy.
	 */
	public InternationalApplicant(Applicant applicant)
	{
		super(applicant);
		if (applicant instanceof InternationalApplicant) {
			setPassport(((InternationalApplicant) applicant).getPassport());
		} else {
			setPassport("");
		}
	}

	/**
	 * @return the international applicant's passport number.
	 */
	public String getPassport() {
		return passport;
	}

	/**
	 * @param passport The specified passport number belonging to this international applicant.
	 */
	public void setPassport(String passport) {
		this.passport = passport;
	}
	
}
