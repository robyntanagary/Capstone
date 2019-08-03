
public class FOacademic extends User {
	
	private String staffNumber;
	
	public FOacademic()
	{
		super();
	}
	
	public FOacademic(String surname, String firstName, String number, String password, String title, String email, String cellphone)
	{
		super(surname, firstName, password, title, email, cellphone);
		staffNumber = number;
	}

	/**
	 * Retrieve the staff number of this academic processing applications for the Faculty Offices.
	 * @return the staffNumber of this academic processing applications for the Faculty Offices.
	 */
	public String getStaffNumber() {
		return staffNumber;
	}

	/**
	 * Set the staff number belonging to this academic processing applications for the Faculty Offices.
	 * @param staffNumber The Specified staffNumber of this academic processing applications for the Faculty Offices.
	 */
	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}

}
