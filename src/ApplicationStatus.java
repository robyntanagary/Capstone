
public class ApplicationStatus {
	private String statusCode;
	private String statusDescripition;
	private String reasonCode;
	private String reasonDescription;
	
	public ApplicationStatus()
	{
		
	}
	
	public ApplicationStatus(String statusCode, String reasonCode)
	{
		
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
		return statusDescripition;
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
}
