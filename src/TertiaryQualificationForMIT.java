
public class TertiaryQualificationForMIT extends TertiaryQualification {
	private int priorITExperience;
	private boolean presenceProjectThesis;
	private String descriptionProjectThesis;
	private int highestLevelUndergradMathematcs;
	private UndergraduateMathematics[] undergradMaths;
	
	/**
	 * No parameter constructor.
	 */
	public TertiaryQualificationForMIT()
	{
		super();
		this.presenceProjectThesis = false;
		this.descriptionProjectThesis = "";
	}
	 
	public TertiaryQualificationForMIT(String degree, String university, String country, int duration, String NQF)
	{
		super(degree, university, country, duration, NQF);
		this.presenceProjectThesis = false;
		this.descriptionProjectThesis = "";
	}
	
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
