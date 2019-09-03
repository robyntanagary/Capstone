/**
 * Class SouthAfricanApplicant models South African applicants, it is a subclass of Applicant.
 * @author FYTTAN001, LXXWEN005, MCKROB018
 */
public class SouthAfricanApplicant extends Applicant{
	
	private String ID;
	private String race;
	
	/**
	 * No Parameter constructor, creates a basic south african applicant object.
	 */
	public SouthAfricanApplicant()
	{
		super();
		ID = "";
		race = "";
	}
	
	/**
	 * Creates an south african applicant using all the available details from an applicant object.
	 * @param applicant The applicant object to be copied.
	 */
	public SouthAfricanApplicant(Applicant applicant)
	{
		super(applicant);
		if (applicant instanceof SouthAfricanApplicant) {
			setRace(((SouthAfricanApplicant) applicant).getRace());
			setID(((SouthAfricanApplicant) applicant).getID());
		} else {
			setRace("");
			setID("");
		}
	}

	/**
	 * @return The ID number belonging to this RSA applicant.
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @param iD The specified ID number of this RSA applicant.
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * @return this RSA applicant's race.
	 */
	public String getRace() {
		return race;
	}

	/**
	 * @param race The specified race of this RSA applicant. 
	 */
	public void setRace(String race) {
		this.race = race;
	}
}
