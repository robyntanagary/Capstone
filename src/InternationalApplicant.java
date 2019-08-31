
public class InternationalApplicant extends Applicant {
	private String passport;
	
	public InternationalApplicant()
	{
		super();
		setPassport("");
	}
	
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
	 * Method return the passport number belonging to this international applicant.
	 * @return the international applicant's passport number.
	 */
	public String getPassport() {
		return passport;
	}

	/**
	 * Method sets this international applicant's passport number.
	 * @param passport The specified passport number belonging to this international applicant.
	 */
	public void setPassport(String passport) {
		this.passport = passport;
	}
	
}
