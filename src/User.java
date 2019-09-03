/**
 * Class User models users of the systema and has Applicant and FOacademic as its subclasses.
 * @author FYTTAN001, LXXWEN005, MCKROB018
 */
public class User {
	private String surname;
	private String firstName;
	private String title;
	private String email;
	private String cellPhone;
	private String password;
	
	/**
	 * No parameter constructor, creates a basic user object.
	 */
	public User()
	{
		this.surname = "";
		this.firstName = "";
		this.title = "";
		this.email = "";
		this.cellPhone = "";
		this.password = "";
	}
	
	/**
	 * Copy constructor, creates a user object that is identical to the given user object.
	 * @param user The object to be copied.
	 */
	public User(User user)
	{
		this.surname = user.getSurname();
		this.firstName = user.getFirstName();
		this.title = user.getTitle();
		this.email = user.getEmail();
		this.cellPhone = user.getCellPhone();
		this.password = user.getPassword();
	}
	
	/**
	 * Standard constructor, creates a user object using the given fields.
	 * @param surname The surname of the user.
	 * @param firstName The first name of the user.
	 * @param password The password of the user.
	 * @param title The title of the user.
	 * @param email The email of the user.
	 * @param cellphone The cellphone of the user.
	 */
	public User(String surname, String firstName, String password, String title, String email, String cellphone)
	{
		this.surname = surname;
		this.firstName = firstName;
		this.title = title;
		this.email = email;
		this.cellPhone = cellphone;
		this.password = password;
	}
	
	public User(String email, String password)
	{
		this.surname = "";
		this.firstName = "";
		this.title = "";
		this.email = email;
		this.cellPhone = "";
		this.password = password;
	}
	
	/**
	 * Retrieve surname of the user.
	 * @return The surname of the user.
	 */
	public String getSurname() {
		return surname;
	}
	
	/**
	 * Set the surname of the user.
	 * @param surname Specified surname of the user.
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	/**
	 * Retrieve first name of the user.
	 * @return The first name of the user.
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * Set the first name of the user.
	 * @param firstName The specified first name of the user
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Retrieve the title of the user. 
	 * @return The title of the user.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set the title of the user.
	 * @param title The specified title of the user.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Retrieve the email address of the user.
	 * @return The email address of the user.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set the email address of the user.
	 * @param email The specified email address of the user.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Retrieve the cellPhone number of the user.
	 * @return The cellPhone number of the user.
	 */
	public String getCellPhone() {
		return cellPhone;
	}

	/**
	 * Set the cell phone number of the user.
	 * @param cellPhone The specified cellPhone number of the user.
	 */
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	/**
	 * Retrieve the password of the user.
	 * @return The password of the user.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set the password of the user.
	 * @param password The specified password of the user.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
