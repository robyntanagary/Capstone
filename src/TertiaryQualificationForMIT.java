
public class TertiaryQualificationForMIT extends TertiaryQualification {
	private int priorITExperience;
	private boolean presenceProjectThesis;
	private String descriptionProjectThesis;
	private int highestLevelUndergradMathematcs;
	private UndergraduateMathematics[] undergradMaths;
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
