
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
		if ((statusCode.equalsIgnoreCase("ADMT")) && (reasonCode.equalsIgnoreCase("FIRM")))
		{
			return "Firm offer of place made. Letter to follow.";
		}
		else if ((statusCode.equalsIgnoreCase("ADRV")) && (reasonCode.equalsIgnoreCase("COND")))
		{
			return "Offer revoked as conditions have not been met.";
		}
		else if ((statusCode.equalsIgnoreCase("APPL")) && (reasonCode.equalsIgnoreCase("REIN")))
		{
			return "Your application has been reinstated.";
		}
		else if ((statusCode.equalsIgnoreCase("COND")) && (reasonCode.equalsIgnoreCase("CERT")))
		{
			return "Your offer will be confirmed upon receipt of a certified copy of your transcript, see letter for details";
		}
		else if ((statusCode.equalsIgnoreCase("COND")) && (reasonCode.equalsIgnoreCase("RCPT") || reasonCode.equalsIgnoreCase("RSLT") || reasonCode.contains("RES") || reasonCode.equalsIgnoreCase("TERT")))
		{
			return "Conditional offer made. See letter with conditions.";
		}
		else if ((statusCode.equalsIgnoreCase("COND")) && (reasonCode.equalsIgnoreCase("STAR")))
		{
			return "Offer made. See letter for conditions.";
		}
		else if ((statusCode.equalsIgnoreCase("ADMT")) && (reasonCode.equalsIgnoreCase("CONF")))
		{
			return "Condition of offer met. Your offer of a place has been confirmed";
		}
		else if ((statusCode.equalsIgnoreCase("DDEF")) && (reasonCode.equalsIgnoreCase("ALT")))
		{
			return "Decision deferred pending response from applicant";
		}
		else if ((statusCode.equalsIgnoreCase("DDEF")) && (reasonCode.equalsIgnoreCase("HOD")))
		{
			return "Application under consideration by the Head of Department";
		}
		else if ((statusCode.equalsIgnoreCase("DDEF")) && (reasonCode.equalsIgnoreCase("INFO")))
		{
			return "Further information/documentation required. Check your “to-do” list.";
		}
		else if ((statusCode.equalsIgnoreCase("DDEF")) && (reasonCode.equalsIgnoreCase("LANG")))
		{
			return "Proof of English Proficiency required.";
		}
		else if ((statusCode.equalsIgnoreCase("DDEF")) && (reasonCode.equalsIgnoreCase("RFAC")))
		{
			return "Your application is under consideration by the Faculty Admissions Committee";
		}
		else if ((statusCode.equalsIgnoreCase("DDEF")) && (reasonCode.equalsIgnoreCase("RPL")))
		{
			return "Your application is pending the outcome of the evaluation assessment (RPL)";
		}
		else if ((statusCode.equalsIgnoreCase("DDEF")) && (reasonCode.equalsIgnoreCase("TERT")))
		{
			return "Your application will be decided when we receive your tertiary results.";
		}
		else if ((statusCode.equalsIgnoreCase("DDEF")) && (reasonCode.equalsIgnoreCase("TUCT")))
		{
			return "Your application will be decided when we know your UCT results";
		}
		else if ((statusCode.equalsIgnoreCase("DEFR")))
		{
			return "Application deferred to the next semester.";
		}
		else if ((statusCode.equalsIgnoreCase("DEIN")))
		{
			return "We have received your acceptance of our offer.";
		}
		else if ((statusCode.equalsIgnoreCase("DENY")) && (reasonCode.equalsIgnoreCase("COMP")))
		{
			return "Application unsuccessful –not competitive. For undergraduate study options contact http://cach.dhet.gov.za or 0860 111 673";
		}
		else if ((statusCode.equalsIgnoreCase("DENY")) && (reasonCode.equalsIgnoreCase("LATE")))
		{
			return "Ineligible late application. For undergraduate study options contact http://cach.dhet.gov.za or 0860 111 673";
		}
		else if ((statusCode.equalsIgnoreCase("DENY")) && (reasonCode.equalsIgnoreCase("PROP")))
		{
			return "Application unsuccessful –inadequate research outline.";
		}
		else if ((statusCode.equalsIgnoreCase("DENY")) && (reasonCode.equalsIgnoreCase("SUPV")))
		{
			return "Application unsuccessful – no suitable supervisor available for your research.";
		}
		else if ((statusCode.equalsIgnoreCase("WADM")) && (reasonCode.equalsIgnoreCase("CHNG")))
		{
			return "Your application has been cancelled and changed to a different programme.";
		}
		else if ((statusCode.equalsIgnoreCase("WADM")) && (reasonCode.equalsIgnoreCase("CLAP") || reasonCode.equalsIgnoreCase("FRAD")))
		{
			return "Your offer has been withdrawn. Please contact the Faculty Office for further details.";
		}
		else if ((statusCode.equalsIgnoreCase("WADM")) && (reasonCode.equalsIgnoreCase("ICOM")))
		{
			return "Application cancelled. University has not been provided with information requested.";
		}
		else if ((statusCode.equalsIgnoreCase("WADM")) && (reasonCode.equalsIgnoreCase("OFFER")))
		{
			return "Application for this qualification has been withdrawn. Offer made on your other application.";
		}
		else if ((statusCode.equalsIgnoreCase("WADM")) && (reasonCode.equalsIgnoreCase("PWIT")))
		{
			return "Your application has been withdrawn due to the unavailability of the programme.";
		}
		else if ((statusCode.equalsIgnoreCase("WAIT")) && (reasonCode.equalsIgnoreCase("GENW")))
		{
			return "You have been placed on the waiting list. You will be advised when your status changes.";
		}
		else if ((statusCode.equalsIgnoreCase("WAPP")) && (reasonCode.equalsIgnoreCase("GAP")))
		{
			return "Your offer has been deferred at your request";
		}
		else if ((statusCode.equalsIgnoreCase("WAPP")) && (reasonCode.equalsIgnoreCase("REJO")))
		{
			return "Your offer has been cancelled at your request or on your indication of preference for another offer.";
		}
		else if ((statusCode.equalsIgnoreCase("WAPP")) && (reasonCode.equalsIgnoreCase("WDRN")))
		{
			return "Your application has beenwithdrawn at your request.";
		}
		return "";
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
