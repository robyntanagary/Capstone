/**
 * Class FOacademic models academics. It is a subclass of User.
 * @author FYTTAN001, LXXWEN005, MCKROB018
 */
public class FOacademic extends User {
	
	private String staffNumber;
	
	/**
	 * No parameter constructor, creates a basic academic object.
	 */
	public FOacademic()
	{
		super();
	}
	
	/**
	 * Creates an academic using the supplied fields.
	 * @param surname The surname of the academic.
	 * @param firstName The first name of the academic.
	 * @param number The staff number of the academic.
	 * @param password The password of the academic.
	 * @param title The title of the academic.
	 * @param email The email of the academic.
	 * @param cellphone The cellphone number of the academic.
	 */
	public FOacademic(String surname, String firstName, String number, String password, String title, String email, String cellphone)
	{
		super(surname, firstName, password, title, email, cellphone);
		staffNumber = number;
	}

	/**
	 * @return the staffNumber of this academic processing applications for the Faculty Offices.
	 */
	public String getStaffNumber() {
		return staffNumber;
	}

	/**
	 * @param staffNumber The Specified staffNumber of this academic processing applications for the Faculty Offices.
	 */
	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}

}
