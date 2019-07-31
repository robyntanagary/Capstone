
public class StudyProgram {
	private QualificationLevel qualificationLevel;
	private String academicQualification;
	private String specialisationOrMajor;
	private boolean requireTranscript;
	private boolean requireCV;
	private boolean requireResearchStatement;
	private boolean requireRefereesNames;
	private boolean requireMotivation;
	private boolean requireFundingStatement;
	
	public StudyProgram(QualificationLevel qualificationLevel, String academicQualification, String specialisationOrMajor, boolean requireTranscript, boolean requireCV, boolean requireResearchOutline, boolean requireRefereesNames, boolean requireMotivation)
	{
		this.qualificationLevel = qualificationLevel;
		this.academicQualification = academicQualification;
		this.specialisationOrMajor = specialisationOrMajor;
		this.requireTranscript = requireTranscript;
		this.requireCV = requireCV;
		this.requireResearchStatement = requireResearchOutline;
		this.requireRefereesNames = requireRefereesNames;
		this.requireMotivation = requireMotivation;
	}
	/**
	 * @return the qualificationLevel
	 */
	public QualificationLevel getQualificationLevel() {
		return qualificationLevel;
	}
	/**
	 * @return the academicQualification
	 */
	public String getAcademicQualification() {
		return academicQualification;
	}
	/**
	 * @return the specialisationOrMajor
	 */
	public String getSpecialisationOrMajor() {
		return specialisationOrMajor;
	}
	/**
	 * @return the requireTranscript
	 */
	public boolean isRequireTranscript() {
		return requireTranscript;
	}
	/**
	 * @return the requireCV
	 */
	public boolean isRequireCV() {
		return requireCV;
	}
	/**
	 * @return the requireResearchOutline
	 */
	public boolean isRequireResearchStatement() {
		return requireResearchStatement;
	}
	/**
	 * @return the requireRefereesNames
	 */
	public boolean isRequireRefereesNames() {
		return requireRefereesNames;
	}
	/**
	 * @return the requireMotivation
	 */
	public boolean isRequireMotivation() {
		return requireMotivation;
	}
	/**
	 * @return the requireFundingStatement
	 */
	public boolean isRequireFundingStatement() {
		return requireFundingStatement;
	}
}
