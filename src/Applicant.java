
public class Applicant extends User {
private String applicantNumber;
private String citizenship; 
private String citizenshipCountry;
private Address residenceAddress;
private TertiaryQualification previousQualification;

public Applicant()
{
	super();
	this.applicantNumber = "";
	this.citizenship = "";
	this.citizenshipCountry = "";
	this.residenceAddress = new Address();
	this.previousQualification = new TertiaryQualification();
}

public Applicant(Applicant applicant) //NEVER GETS RUN!
{
	super((User) applicant);
	this.applicantNumber = applicant.getApplicantNumber();
	System.out.println("tracer Applicant 18 " + applicantNumber);
	this.citizenship = applicant.getCitizenship();
	System.out.println("tracer Applicant 20 " + citizenship);
	this.citizenshipCountry = applicant.getCitizenshipCountry();
	this.residenceAddress = applicant.getResidenceAddress();
	this.previousQualification = applicant.getPreviousQualification();
}

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
 * Method return the country in which thus applicant has citizenship.
 * @return Country in which applicant has this applicant has citizenship
 */
public String getCitizenshipCountry() {
	return citizenshipCountry;
}

/**
 * Method set the county in which this applicant has citizenship to the specified country.
 * @param citizenshipCountry
 */
public void setCitizenshipCountry(String citizenshipCountry) {
	this.citizenshipCountry = citizenshipCountry;
}

/**
 * Method return whether applicant is a RSA citizen, permanent RSA resident, or an international applicant.
 * @return whether applicant is a RSA citizen, permanent RSA resident, or an international applicant.
 */
public String getCitizenship() {
	return citizenship;
}

/**
 * Method sets whether applicant is a RSA citizen, permanent RSA resident, or an international applicant.
 * @param citizenshipCountry Specify whether applicant is a RSA citizen, permanent RSA resident, or an international applicant.
 */
public void setCitizenship(String citizenship) {
	this.citizenship = citizenship;
}


/**
 * Method return the applicant number of this applicant.
 * @return the applicant number belong to this applicant. 
 */
public String getApplicantNumber() {
	return applicantNumber;
}


/**
 * Method sets the applicant number of this applicant.
 * @param applicantNumber The specified applicant number belonging to this applicant.
 */
public void setApplicantNumber(String applicantNumber) {
	this.applicantNumber = applicantNumber;
}


/**
 * Method returns the residence address of this applicant.
 * @return the residence address of this applicant.
 */
public Address getResidenceAddress() {
	return residenceAddress;
}


/**
 * Method sets the residence address of this applicant
 * @param residenceAddress The specified residence address of this applicant.
 */
public void setResidenceAddress(Address residenceAddress) {
	this.residenceAddress = residenceAddress;
}


/**
 * Method returns this applicant's previous qualification.
 * @return the previous qualification of this applicant.
 */
public TertiaryQualification getPreviousQualification() {
	return previousQualification;
}


/**
 * Method sets this applicant's previous qualification.
 * @param previousQualification The specified previous qualification of this applicant.
 */
public void setPreviousQualification(TertiaryQualification previousQualification) {
	this.previousQualification = previousQualification;
} 
}
