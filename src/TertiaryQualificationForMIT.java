/**
 * Class TertiaryQualificationForMIT models tertiary qualifications specific to MIT applications.
 * @author TertiaryQualificationForMIT
 */
public class TertiaryQualificationForMIT extends TertiaryQualification {
	private int priorITExperience;
	private boolean presenceProjectThesis;
	private String descriptionProjectThesis;
	private int highestLevelUndergradMathematcs;
	private UndergraduateMathematics[] undergradMaths;
	
	/**
	 * No parameter constructor, creates a basic tertiary qualifcation for MIT object.
	 */
	public TertiaryQualificationForMIT()
	{
		super();
		this.presenceProjectThesis = false;
		this.descriptionProjectThesis = "";
	}
	 
	/**
	 * Creates a tertiary qualification for MIT object using the supplied fields.
	 * @param degree The degree of the tertiary qualification.
	 * @param university The university that awarded the tertiary qualification.
	 * @param country The country in which the tertiary qualification was awarded.
	 * @param duration The minimum duration of the tertiary qualification.
	 * @param NQF The NQF equivalent of the of the tertiary qualification.
	 */
	public TertiaryQualificationForMIT(String degree, String university, String country, int duration, String NQF)
	{
		super(degree, university, country, duration, NQF);
		this.presenceProjectThesis = false;
		this.descriptionProjectThesis = "";
	}
	
	/**
	 * Creates a tertiary qualification for MIT object using the supplied fields.
	 * @param degree The degree of the tertiary qualification.
	 * @param university The university that awarded the tertiary qualification.
	 * @param country The country in which the tertiary qualification was awarded.
	 * @param duration The minimum duration of the tertiary qualification.
	 * @param NQF The NQF equivalent of the of the tertiary qualification.
	 * @param itExperience The number of years of IT experience.
	 * @param hasThesis Whether or not the tertiary qualification has a thesis.
	 * @param thesis The thesis of the tertiary qualification.
	 * @param HighestLevel The highest level of undergraduate math achieved.
	 * @param undergradMaths Array containing the undergraduates math details.
	 */
	public TertiaryQualificationForMIT(String degree, String university, String country, int duration, String NQF, int itExperience, boolean hasThesis, String thesis, int HighestLevel, UndergraduateMathematics[] undergradMaths)
	{
		super(degree, university, country, duration, NQF);
		this.priorITExperience = itExperience;
		this.presenceProjectThesis = hasThesis;
		this.descriptionProjectThesis = thesis;
		this.highestLevelUndergradMathematcs = HighestLevel;
		this.undergradMaths = undergradMaths;
	}
	/**
	 * Constructor, takes a TertiaryQualification object as a parameter.
	 * @param tq The TertiaryQualification object to copy from.
	 */
	public TertiaryQualificationForMIT(TertiaryQualification tq)
	{
		super(tq);
		if (tq instanceof TertiaryQualificationForMIT) {
			setPriorITExperience(((TertiaryQualificationForMIT) tq).getPriorITExperience());
			PresenceProjectThesisPresent(((TertiaryQualificationForMIT) tq).hasProjectThesis());
			setDescriptionProjectThesis(((TertiaryQualificationForMIT) tq).getDescriptionProjectThesis());
			setHighestLevelUndergradMathematcs(((TertiaryQualificationForMIT) tq).getHighestLevelUndergradMathematcs());
			setUndergradMaths(((TertiaryQualificationForMIT) tq).getUndergradMaths());
		} else {
			PresenceProjectThesisPresent(false);
			setDescriptionProjectThesis("");
		}
	}
	
	/**
	 * @return the priorITExperience
	 */
	public int getPriorITExperience() {
		return priorITExperience;
	}
	/**
	 * @param priorITExperience the priorITExperience to set
	 */
	public void setPriorITExperience(int priorITExperience) {
		this.priorITExperience = priorITExperience;
	}
	/**
	 * @return the presenceProjectThesis
	 */
	public boolean hasProjectThesis() {
		return presenceProjectThesis;
	}
	/**
	 * @param presenceProjectThesis the presenceProjectThesis to set
	 */
	public void PresenceProjectThesisPresent(boolean presenceProjectThesis) {
		this.presenceProjectThesis = presenceProjectThesis;
	}
	/**
	 * @return the descriptionProjectThesis
	 */
	public String getDescriptionProjectThesis() {
		return descriptionProjectThesis;
	}
	/**
	 * @param descriptionProjectThesis the descriptionProjectThesis to set
	 */
	public void setDescriptionProjectThesis(String descriptionProjectThesis) {
		this.descriptionProjectThesis = descriptionProjectThesis;
	}
	/**
	 * @return the undergradMaths
	 */
	public UndergraduateMathematics[] getUndergradMaths() {
		return undergradMaths;
	}
	/**
	 * @param undergradMaths the undergradMaths to set
	 */
	public void setUndergradMaths(UndergraduateMathematics[] undergradMaths) {
		this.undergradMaths = undergradMaths;
	}
	/**
	 * @return the highestLevelUndergradMathematcs
	 */
	public int getHighestLevelUndergradMathematcs() {
		return highestLevelUndergradMathematcs;
	}
	/**
	 * @param highestLevelUndergradMathematcs the highestLevelUndergradMathematcs to set
	 */
	public void setHighestLevelUndergradMathematcs(int highestLevelUndergradMathematcs) {
		this.highestLevelUndergradMathematcs = highestLevelUndergradMathematcs;
	}
}
