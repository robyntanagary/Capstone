
public class StudyProgram {
	private String qualificationLevel;
	private String academicQualification;
	private String specialisationOrMajor;
	private boolean requireTranscript;
	private boolean requireCV;
	private boolean requireResearchStatement;
	private boolean requireRefereesNames;
	private boolean requireMotivation;
	private boolean requireFundingStatement;
	private boolean requireResearchSummary;
	private boolean requireSupervisors;
	private boolean requireStartDate;
	
	public StudyProgram()
	{
		this("");
	}
	
	public StudyProgram(String studyProgramName)
	{
		academicQualification = studyProgramName.trim();
		
		if (academicQualification.contains("Honours"))
		{
			qualificationLevel = "Honours";
		}
		else if (academicQualification.contains("Masters"))
		{
			qualificationLevel = "Masters";
		}
		else if (academicQualification.contains("PhD"))
		{
			qualificationLevel = "PhD";
		}
		else if (academicQualification.contains("Postgraduate Diploma"))
		{
			qualificationLevel = "Postgraduate Diploma";
		}
		else
		{
			qualificationLevel = "Unrecognised";
		}
		
		if (academicQualification.equals("Honours in Computer Science (full-time)"))
		{
			specialisationOrMajor = "Computer Science";
			requireTranscript = true;
			requireCV = true;
			requireResearchStatement = true;
			requireRefereesNames = false;
			requireMotivation = false;
			requireFundingStatement = false;
			requireResearchSummary = false;
			requireSupervisors = false;
			requireStartDate = false;
		}
		else if (academicQualification.equals("Masters in Information Technology (MIT)"))
		{
			specialisationOrMajor = "Information Technology";
			requireTranscript = true;
			requireCV = true;
			requireResearchStatement = true;
			requireRefereesNames = true;
			requireMotivation = false;
			requireFundingStatement = true;
			requireResearchSummary = false;
			requireSupervisors = false;
			requireStartDate = true;
		}
		else if (academicQualification.equals("Masters by Coursework and Dissertation (MSc by C+D)"))
		{
			specialisationOrMajor = "Computer Science";
			requireTranscript = true;
			requireCV = true;
			requireResearchStatement = true;
			requireRefereesNames = true;
			requireMotivation = false;
			requireFundingStatement = true;
			requireResearchSummary = false;
			requireSupervisors = true;
			requireStartDate = true;
		}
		else if (academicQualification.equals("Masters by Dissertation (MSc by D)"))
		{
			specialisationOrMajor = "Computer Science";
			requireTranscript = true;
			requireCV = true;
			requireResearchStatement = true;
			requireRefereesNames = true;
			requireMotivation = false;
			requireFundingStatement = true;
			requireResearchSummary = false;
			requireSupervisors = true;
			requireStartDate = true;
		}
		else if (academicQualification.equals("PhD in Computer Science"))
		{
			specialisationOrMajor = "Computer Science";
			requireTranscript = true;
			requireCV = true;
			requireResearchStatement = true;
			requireRefereesNames = false;
			requireMotivation = false;
			requireFundingStatement = true;
			requireResearchSummary = true;
			requireSupervisors = true;
			requireStartDate = true;
		}
		else if (academicQualification.equals("Honours in Information Systems (full-time)"))
		{
			specialisationOrMajor = "Computer Science";
			requireTranscript = false;
			requireCV = false;
			requireResearchStatement = false;
			requireRefereesNames = false;
			requireMotivation = false;
			requireFundingStatement = false;
			requireResearchSummary = false;
			requireSupervisors = false;
			requireStartDate = false;
		}
		else if (academicQualification.equals("Honours in Management Information Systems (part-time)"))
		{
			specialisationOrMajor = "Computer Science";
			requireTranscript = false;
			requireCV = false;
			requireResearchStatement = false;
			requireRefereesNames = false;
			requireMotivation = false;
			requireFundingStatement = false;
			requireResearchSummary = false;
			requireSupervisors = false;
			requireStartDate = false;
		}
		else if (academicQualification.equals("Postgraduate Diploma in Management in Information Systems (part-time)"))
		{
			specialisationOrMajor = "Computer Science";
			requireTranscript = false;
			requireCV = true;
			requireResearchStatement = false;
			requireRefereesNames = false;
			requireMotivation = true;
			requireFundingStatement = false;
			requireResearchSummary = false;
			requireSupervisors = false;
			requireStartDate = false;
		}
		else if (academicQualification.equals("Master of Commerce in Information Systems"))
		{
			specialisationOrMajor = "Computer Science";
			requireTranscript = false;
			requireCV = true;
			requireResearchStatement = false;
			requireRefereesNames = true;
			requireMotivation = true;
			requireFundingStatement = false;
			requireResearchSummary = false;
			requireSupervisors = false;
			requireStartDate = false;
		}
		else if (academicQualification.equals("PhD in Information Systems"))
		{
			specialisationOrMajor = "Computer Science";
			requireTranscript = false;
			requireCV = true;
			requireResearchStatement = false;
			requireRefereesNames = true;
			requireMotivation = true;
			requireFundingStatement = false;
			requireResearchSummary = false;
			requireSupervisors = false;
			requireStartDate = false;
		}
		else
		{
			specialisationOrMajor = "Unrecognised";
			requireTranscript = true;
			requireCV = true;
			requireResearchStatement = true;
			requireRefereesNames = true;
			requireMotivation = true;
			requireFundingStatement = true;
			requireResearchSummary = true;
			requireSupervisors = true;
			requireStartDate = true;
		}
		
		
	}
	
	public StudyProgram(String qualificationLevel, String academicQualification, String specialisationOrMajor, boolean requireTranscript, boolean requireCV, boolean requireResearchOutline, boolean requireRefereesNames, boolean requireMotivation, boolean requireFundingStatement, boolean requireResearchSummary, boolean requireSupervisors, boolean requireStartDate)
	{
		this.qualificationLevel = qualificationLevel;
		this.academicQualification = academicQualification;
		this.specialisationOrMajor = specialisationOrMajor;
		this.requireTranscript = requireTranscript;
		this.requireCV = requireCV;
		this.requireResearchStatement = requireResearchOutline;
		this.requireRefereesNames = requireRefereesNames;
		this.requireMotivation = requireMotivation;
		this.requireFundingStatement = requireFundingStatement;
		this.requireResearchSummary = requireResearchSummary;
		this.requireSupervisors = requireSupervisors;
		this.requireStartDate = requireStartDate;
	}
	/**
	 * @return the qualificationLevel
	 */
	public String getQualificationLevel() {
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
	public boolean requireTranscript() {
		return requireTranscript;
	}
	/**
	 * @return the requireCV
	 */
	public boolean requireCV() {
		return requireCV;
	}
	/**
	 * @return the requireResearchOutline
	 */
	public boolean requireResearchStatement() {
		return requireResearchStatement;
	}
	/**
	 * @return the requireRefereesNames
	 */
	public boolean requireRefereesNames() {
		return requireRefereesNames;
	}
	/**
	 * @return the requireMotivation
	 */
	public boolean requireMotivation() {
		return requireMotivation;
	}
	/**
	 * @return the requireFundingStatement
	 */
	public boolean requireFundingStatement() {
		return requireFundingStatement;
	}

	/**
	 * @return the requireResearchSummary
	 */
	public boolean requireResearchSummary() {
		return requireResearchSummary;
	}

	/**
	 * @return the requireSupervisors
	 */
	public boolean requireSupervisors() {
		return requireSupervisors;
	}

	/**
	 * @return the requireStartDate
	 */
	public boolean requireStartDate() {
		return requireStartDate;
	}
}
