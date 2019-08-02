
public class Application {
	private String applicationNumber;
	private ApplicationStatus applicationStatus;
	private StudyProgram studyProgram;
	//need to add PDF!!!
	/**
	 * @return the applicationNumber
	 */
	public String getApplicationNumber() {
		return applicationNumber;
	}
	/**
	 * @param applicationNumber the applicationNumber to set
	 */
	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}
	/**
	 * @return the applicationStatus
	 */
	public ApplicationStatus getApplicationStatus() {
		return applicationStatus;
	}
	/**
	 * @param applicationStatus the applicationStatus to set
	 */
	public void setApplicationStatus(ApplicationStatus applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	/**
	 * @return the studyProgram
	 */
	public StudyProgram getStudyProgram() {
		return studyProgram;
	}
	/**
	 * @param studyProgram the studyProgram to set
	 */
	public void setStudyProgram(StudyProgram studyProgram) {
		this.studyProgram = studyProgram;
	}
	
	public boolean changeStatus(String status)
	{
		//needs logic!!!
		return true;
	}
	
	public boolean addReasonForStatus(String statusReason)
	{
		//needs logic!!
		return true;
	}
}
