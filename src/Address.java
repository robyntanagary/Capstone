/**
 * Class Address models addresses of Applicants.
 * @author FYTTAN001, LXXWEN005, MCKROB018
 */
public class Address {
	private String lineAddress;
	private String country;
	
	/**
	 * No parameter constructor, creates a basic address object.
	 */
	public Address()
	{
		setLineAddress("");
		setCountry("");
	}
	
	/**
	 * Standard constructor, creates an address object from the supplied fields.
	 * @param line The lineAdress of the address.
	 * @param country The country of the address.
	 */
	public Address(String line, String country)
	{
		setLineAddress(line);
		setCountry(country);
	}

	/**
	 * @return The lineAddress of this address.
	 */
	public String getLineAddress() {
		return lineAddress;
	}

	/** 
	 * @param lineAddress The lineAddress to be set.
	 */
	public void setLineAddress(String lineAddress) {
		this.lineAddress = lineAddress;
	}

	/**
	 * @return The country of this address.
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country The country to be set.
	 */
	public void setCountry(String country) {
		this.country = country;
	}
}
