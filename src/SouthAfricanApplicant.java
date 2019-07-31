
public class SouthAfricanApplicant extends Applicant{
	
	private String ID;
	private String race;
	
	public SouthAfricanApplicant()
	{
		super();
		ID = "";
		race = "";
	}
	
	public SouthAfricanApplicant(Applicant applicant)
	{
		super(applicant);
		
		ID = "";
		race = "";
	}

	/**
	 * Return RSA applicant's ID number
	 * @return The ID number belonging to this RSA applicant.
	 */
	public String getID() {
		return ID;
	}

	/**
	 * Set this RSA applicant's ID number to the specified ID number.
	 * @param iD The specified ID number of this RSA applicant.
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * Return this RSA applicant's race.
	 * @return this RSA applicant's race.
	 */
	public String getRace() {
		return race;
	}

	/**
	 * Sets this RSA applicant's race
	 * @param race The specified race of this RSA applicant. 
	 */
	public void setRace(String race) {
		this.race = race;
	}
}
