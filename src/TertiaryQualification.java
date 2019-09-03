/**
 * Class TertiaryQualification models tertiary qualifications.
 * @author FYTTAN001, LXXWEN005, MCKROB018
 */
public class TertiaryQualification {
	private String tertiaryInstitution;
	private String country;
	private String NQFEquivalence;
	private int minDuration;
	private String degree;
	
	/**
	 * No parameter constructor, creates a basic tertiary qualification object.
	 */
	public TertiaryQualification()
	{
		setTertiaryInstitution("");
		setCountry("");
		setNQFEquivalence("");
		setMinDuration(1);
		setDegree("");
	}
	
	/**
	 * Creates a tertiary qualification object using the supplied fields.
	 * @param degree The degree of the tertiary qualification.
	 * @param university The university that awarded the tertiary qualification.
	 * @param country The country in which the tertiary qualification was awarded.
	 * @param duration The minimum duration of the tertiary qualification.
	 * @param NQF The NQF equivalent of the of the tertiary qualification.
	 */
	public TertiaryQualification(String degree, String university, String country, int duration, String NQF)
	{
		this.tertiaryInstitution = university;
		this.country = country;
		this.NQFEquivalence = NQF;
		this.minDuration = duration;
		this.degree = degree;
	}
	/**
	 * Constructor, takes a TertiaryQualification object as a parameter.
	 * @param tq The TertiaryQualification object to copy from.
	 */
	public TertiaryQualification(TertiaryQualification tq)
	{
		this.tertiaryInstitution = tq.getTertiaryInstitution();
		this.country = tq.getCountry();
		this.NQFEquivalence = tq.getNQFEquivalence();
		this.minDuration = tq.getMinDuration();
		this.degree = tq.getDegree();
	}

	/**
	 * Return the tertiary institution at which this qualification has been obtained.
	 * @return the tertiary institution at which this qualification has been obtained.
	 */
	public String getTertiaryInstitution() {
		return tertiaryInstitution;
	}

	/**
	 * Set the tertiary institution at which this qualification has been obtained.
	 * @param tertiaryInstituition The specified tertiary institution at which this qualification has been obtained.
	 */
	public void setTertiaryInstitution(String tertiaryInstituition) {
		this.tertiaryInstitution = tertiaryInstituition;
	}

	/**
	 * Retrieve the country in which this qualification has been obtained.
	 * @return the country in which this qualification has been obtained.
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the country in which this qualification has been obtained.
	 * @param country The specified the country in which this qualification has been obtained.
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Return the NQF Equivalent of this qualification if known else "Not Known".
	 * @return the NQF Equivalent of this qualification if known else "Not Known".
	 */
	public String getNQFEquivalence() {
		return NQFEquivalence;
	}

	/**
	 * Set the NQF Equivalent of this qualification if known else "Not Known"
	 * @param nQFEquivalence The specified the NQF Equivalent of this qualification if known else "Not Known".
	 */
	public void setNQFEquivalence(String nQFEquivalence) {
		NQFEquivalence = nQFEquivalence;
	}

	/**
	 * Returns the minimum number of years in which this qualification can be obtained.
	 * @return the minimum number of years in which this qualification can be obtained.
	 */
	public int getMinDuration() {
		return minDuration;
	}

	/**
	 * Set the minimum number of years in which this qualification can be obtained.
	 * @param minDuration The specified minimum number of years in which this qualification can be obtained.
	 */
	public void setMinDuration(int minDuration) {
		this.minDuration = minDuration;
	}

	/**
	 * @return the degree
	 */
	public String getDegree() {
		return degree;
	}

	/**
	 * @param degree the degree to set
	 */
	public void setDegree(String degree) {
		this.degree = degree;
	}
}
