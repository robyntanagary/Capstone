
public class Application {
	private String applicantNumber;
	private String applicationNumber;
	private ApplicationStatus applicationStatus;
	private StudyProgram studyProgram;
	private String pdfName;
	private String pdfPath;
	
	public Application()
	{
		applicationNumber = "";
		studyProgram = new StudyProgram();
		pdfName = "";
		pdfPath = "";
		applicationStatus = new ApplicationStatus();
	}
	
	public Application(String applicationNumber, String applicantNumber)
	{
		this.applicationNumber = applicationNumber;
		this.applicantNumber = applicantNumber;
	}
	
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
	/**
	 * @return the pdfName
	 */
	public String getPdfName() {
		return pdfName;
	}
	/**
	 * @param pdfName the pdfName to set
	 */
	public void setPdfName(String pdfName) {
		this.pdfName = pdfName;
	}
	/**
	 * @return the pdfPath
	 */
	public String getPdfPath() {
		return pdfPath;
	}
	/**
	 * @param pdfPath the pdfPath to set
	 */
	public void setPdfPath(String pdfPath) {
		this.pdfPath = pdfPath;
	}
	
	public void setApplicantNumber(String appNumber)
	{
		applicantNumber = appNumber;
	}
	
	public String getApplicantNumber()
	{
		return applicantNumber;
	}
}
