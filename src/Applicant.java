/**
 * Class Applicant models applicants. It is a subclass of User and has two subclasses.
 * @author FYTTAN001, LXXWEN005, MCKROB018
 */
public class Applicant extends User {
	private String applicantNumber;
	private String citizenship; 
	private String citizenshipCountry;
	private Address residenceAddress;
	private TertiaryQualification previousQualification;
	
	/**
	 * No parameter constructor, create a basic applicant object.
	 */
	public Applicant()
	{
		super();
		this.applicantNumber = "";
		this.citizenship = "";
		this.citizenshipCountry = "";
		this.residenceAddress = new Address();
		this.previousQualification = new TertiaryQualification();
	}
	
	/**
	 * Copy constructor, create an applicant object that is identical to the given applicant object.
	 * @param applicant The applicant object to be copied.
	 */
	public Applicant(Applicant applicant)
	{
		super((User) applicant);
		this.applicantNumber = applicant.getApplicantNumber();
		this.citizenship = applicant.getCitizenship();
		this.citizenshipCountry = applicant.getCitizenshipCountry();
		this.residenceAddress = applicant.getResidenceAddress();
		this.previousQualification = applicant.getPreviousQualification();
	}
	
	/**
	 * Standard constructor, create an applicant object using the given fields.
	 * @param applicantNumber The applicant number for the new applicant.
	 * @param email The email for the new applicant.
	 * @param password The password for the new applicant.
	 * @param confirmPassword The confirmed password for the new applicant.
	 */
	public Applicant(String applicantNumber, String email, String password, String confirmPassword)
	{
		super(email, password);
		this.applicantNumber = applicantNumber;
		this.citizenship = "";
		this.citizenshipCountry = "";
		this.residenceAddress = new Address();
		this.previousQualification = new TertiaryQualification();
	}
	
	/**
	 * @return Country in which this applicant has citizenship.
	 */
	public String getCitizenshipCountry() {
		return citizenshipCountry;
	}
	
	/**
	 * @param citizenshipCountry The county in which this applicant has citizenship.
	 */
	public void setCitizenshipCountry(String citizenshipCountry) {
		this.citizenshipCountry = citizenshipCountry;
	}
	
	/**
	 * @return Whether applicant is a RSA citizen, permanent RSA resident, or an international applicant.
	 */
	public String getCitizenship() {
		return citizenship;
	}
	
	/**
	 * @param citizenshipCountry Whether applicant is a RSA citizen, permanent RSA resident, or an international applicant.
	 */
	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}
	
	/**
	 * @return The applicant number of this applicant. 
	 */
	public String getApplicantNumber() {
		return applicantNumber;
	}
	
	/**
	 * @param applicantNumber The applicant number to be set.
	 */
	public void setApplicantNumber(String applicantNumber) {
		this.applicantNumber = applicantNumber;
	}
	
	/**
	 * @return The residence address of the applicant.
	 */
	public Address getResidenceAddress() {
		return residenceAddress;
	}
	
	/**
	 * @param residenceAddress The residence address to be set.
	 */
	public void setResidenceAddress(Address residenceAddress) {
		this.residenceAddress = residenceAddress;
	}
	
	/**
	 * @return The previous qualification of this applicant.
	 */
	public TertiaryQualification getPreviousQualification() {
		return previousQualification;
	}
	
	/**
	 * @param previousQualification The previous qualification to be set.
	 */
	public void setPreviousQualification(TertiaryQualification previousQualification) {
		this.previousQualification = previousQualification;
	} 
}
