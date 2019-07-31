
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
		//needs logic!!!
		return application;
	}
	
	public boolean submitApplication(Application anApplication)
	{
		//needs logic
		
		return true;
	}
	
	public boolean insertOrUpdateApplication(Application anApplication)
	{
		//needs logic
		
		return true;
	}
	
	public boolean uploadPDF(String pdfName)
	{
		//needs logic!!!
		return true;
	}
	
	public String showChosenPDF()
	{
		//needs logic!
		return "";
	}
	
	public String downloadPDF(String pdfName)
	{
		//needs logic
		return "";
	}
	
	public boolean applicantionEditable(String applicationNumber)
	{
		//needs logic
		return true;
	}
	
	public boolean applicantionViewable(String applicationNumber)
	{
		//needs logic
		return true;
	}
}
