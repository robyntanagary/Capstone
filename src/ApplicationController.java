
public class ApplicationController {
	private Application application;
	/**
	 * Method creates a controller object responsible for managing applications.
	 */
	public ApplicationController()
	{
		
	}
	
	public Application getApplicationOfApplicant(String applicantNumber)
	{
		return application; //needs logic!!!
	}
	
	/**
	 * Method makes the provided application the application of focus.
	 * @param application The specified application that is of focus.
	 */
	public void setApplicationOfFocus(Application application)
	{
		this.application = application;
	}
	
	public boolean noExistingApplication(String applicantNumber)
	{
		return true; //needs logic!!!
	}
	
	public Application createNewApplication(String applicantNumber)
	{
		return application;
	}
	
	
}
