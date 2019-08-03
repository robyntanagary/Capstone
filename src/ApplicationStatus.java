
public class ApplicationStatus {
	private String statusCode;
	private String statusDescription;
	private String reasonCode;
	private String reasonDescription;
	
	public ApplicationStatus()
	{
		setStatus("Created");	
		setReason("Applicant started application process");
	}
	
	public ApplicationStatus(String statusDescription, String reasonDescription)
	{
		setStatus(statusDescription);	
		setReason(reasonDescription);
	}
	
	public String generateMessageForApplicant()
	{
		return "";
		//needs logic!!!
	}

	/**
	 * Return code for status of application
	 * @return the code for status of application
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * Return the description of status of this application.
	 * @return the statusDescripition
	 */
	public String getStatusDescripition() {
		return statusDescription;
	}

	/**
	 * Return code of the reason referenced for status of application
	 * @return the code of the reason referenced for status of application
	 */
	public String getReasonCode() {
		return reasonCode;
	}

	/**
	 * Return code of the reason referenced for status of application
	 * @return the reasonDescription
	 */
	public String getReasonDescription() {
		return reasonDescription;
	}
	
	private void setStatus(String statusDescription)
	{
		this.statusDescription = statusDescription;
		if (statusDescription.equalsIgnoreCase("Created")) {this.statusCode = "CRTD";}
		if (statusDescription.equalsIgnoreCase("Applied")) {this.statusCode = "APPL";}
		if (statusDescription.equalsIgnoreCase("Denied")) {this.statusCode = "DENY";}
		if (statusDescription.equalsIgnoreCase("Conditionally Admitted")) {this.statusCode = "COND";}
		if (statusDescription.equalsIgnoreCase("Admitted")) {this.statusCode = "ADMT";}
		if (statusDescription.equalsIgnoreCase("Withdrawn")) {this.statusCode = "WADM";}
		if (statusDescription.equalsIgnoreCase("Offer Accepted")) {this.statusCode = "DEIN";}
		if (statusDescription.equalsIgnoreCase("Decision Deffered")) {this.statusCode = "DDEF";}
		if (statusDescription.equalsIgnoreCase("On Waiting List")) {this.statusCode = "WAIT";}
		if (statusDescription.equalsIgnoreCase("Firm Offer Deferred")) {this.statusCode = "WAPP";}
		if (statusDescription.equalsIgnoreCase("Conditional Admittance Revoked")) {this.statusCode = "ADRV";}
		if (statusDescription.equalsIgnoreCase("Offer Rejected")) {this.statusCode = "WAPP";}
		if (statusDescription.equalsIgnoreCase("Deffered")) {this.statusCode = "DEFR";}
	}
	
	private void setReason(String statusReason)
	{
		reasonDescription = statusReason;
		if (statusReason.equalsIgnoreCase("Applicant started application process")) {this.reasonCode = "STRT";}
		if (statusReason.equalsIgnoreCase("Applicant submitted application")) {this.reasonCode = "SBMT";}
		if (statusReason.equalsIgnoreCase("Applicant withdraws application")) {this.reasonCode = "WDRN";}
		if (statusReason.equalsIgnoreCase("Applicant reconsider programme of study")) {this.reasonCode = "ALT";}
		if (statusReason.equalsIgnoreCase("HOD / Programme Convenor must decide")) {this.reasonCode = "HOD";}
		if (statusReason.equalsIgnoreCase("Faculty Admittance Committee must decide")) {this.reasonCode = "RFAC";}
		if (statusReason.equalsIgnoreCase("Waiting for Information")) {this.reasonCode = "INFO";}
		if (statusReason.equalsIgnoreCase("Waiting for English Proficiency Results")) {this.reasonCode = "LANG";}
		if (statusReason.equalsIgnoreCase("Waiting for External Tertiary results")) {this.reasonCode = "TERT";}
		if (statusReason.equalsIgnoreCase("Waiting for UCT results")) {this.reasonCode = "TUCT";}
		if (statusReason.equalsIgnoreCase("No Special Reason")) {this.reasonCode = "GENW";}
		if (statusReason.equalsIgnoreCase("Defer decision of making firm offer")) {this.reasonCode = "GAP";}
		if (statusReason.equalsIgnoreCase("Application re-instated")) {this.reasonCode = "REIN";}
		if (statusReason.equalsIgnoreCase("Faculty Office withdraws application due to applicant changing programme choice")) {this.reasonCode = "CHNG";}
		if (statusReason.equalsIgnoreCase("Faculty Office withdraws application due to fraudalent information")) {this.reasonCode = "RFAD";}
		if (statusReason.equalsIgnoreCase("Faculty Office withdraws application due to necessary documentation not provided")) {this.reasonCode = "ICOM";}
		if (statusReason.equalsIgnoreCase("Faculty Office withdraws application due to offer beinf made on another application in faculty")) {this.reasonCode = "OFFER";}
		if (statusReason.equalsIgnoreCase("Faculty Office withdraws application due to programme unavailability")) {this.reasonCode = "PWIT";}
		if (statusReason.equalsIgnoreCase("Faculty Office withdraws application due to never registered")) {this.reasonCode = "CLAP";}
		if (statusReason.equalsIgnoreCase("Conditional Offer withdrawn as admission conditions not met")) {this.reasonCode = "COND";}
		if (statusReason.equalsIgnoreCase("On condition of cetified transcript")) {this.reasonCode = "CERT";}
		if (statusReason.equalsIgnoreCase("On condition of receipt of relevant information")) {this.reasonCode = "RCPT";}
		if (statusReason.equalsIgnoreCase("On condition of school-leaving results")) {this.reasonCode = "RSLT";}
		if (statusReason.equalsIgnoreCase("On condition of final results")) {this.reasonCode = "RES";}
		if (statusReason.equalsIgnoreCase("On condition of final tertiary results")) {this.reasonCode = "TERT";}
		if (statusReason.equalsIgnoreCase("Special Offer for Top Applicants")) {this.reasonCode = "STAR";}
		if (statusReason.equalsIgnoreCase("Firm Offer Made")) {this.reasonCode = "CONF";}
		if (statusReason.equalsIgnoreCase("Application denied due to competition")) {this.reasonCode = "COMP";}
		if (statusReason.equalsIgnoreCase("Application denied due to late application")) {this.reasonCode = "LATE";}
		if (statusReason.equalsIgnoreCase("Application denied due to inadequate research proposal")) {this.reasonCode = "PROP";}
		if (statusReason.equalsIgnoreCase("Application denied due to inappropriate supervisor")) {this.reasonCode = "SUPV";}
		
	}
}
