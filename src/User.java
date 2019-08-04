
public class User {
	private String surname;
	private String firstName;
	private String title;
	private String email;
	private String cellPhone;
	private String password;
	
	public User()
	{
		this.surname = "";
		this.firstName = "";
		this.title = "";
		this.email = "";
		this.cellPhone = "";
		this.password = "";
	}
	
	public User(User user)
	{
		this.surname = user.getSurname();
		this.firstName = user.getFirstName();
		this.title = user.getTitle();
		this.email = user.getEmail();
		this.cellPhone = user.getCellPhone();
		this.password = user.getPassword();
	}
	
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
	 * Retrieve surname of applicant or academic.
	 * @return the surname of the user.
	 */
	public String getSurname() {
		return surname;
	}
	
	/**
	 * Set the academic or applicant's surname.
	 * @param surname Specify the surname of the user.
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	/**
	 * Retrieve firstname of applicant or academic.
	 * @return the firstname of the user.
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * Set the academic or applicant's first name.
	 * @param firstName the specified first name of the applicant
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Retrieve the title of the applicant or academic. 
	 * @return the title of the user.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set the academic or applicant's title.
	 * @param title The specified title of the user.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Retrieve the email address belonging to the applicant or academic
	 * @return the email address of this user.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set the email address of applicant or academic.
	 * @param email The specified email address of this user.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Retrieve the cellPhone number of this user
	 * @return the cellPhone number of this user.
	 */
	public String getCellPhone() {
		return cellPhone;
	}

	/**
	 * Set the cell phone number of this user.
	 * @param cellPhone The specified cellPhone number of this user.
	 */
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	/**
	 * Retrieve the password of this user.
	 * @return the password of this user.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set the password belonging to this user.
	 * @param password The specified password of this user.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
