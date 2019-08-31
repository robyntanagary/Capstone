/**
 * Class models Addresses.
 * @author  FYTTAN001, LXXWEN005, MCKROB018
 */
public class Address {
	private String lineAddress;
	private String country;
	
	public Address()
	{
		setLineAddress("");
		setCountry("");
	}
	
	public Address(String line, String country)
	{
		setLineAddress(line);
		setCountry(country);
	}

	/**
	 * Retrieves the lineAddress of the address.
	 * @return The lineAddress of this address.
	 */
	public String getLineAddress() {
		return lineAddress;
	}

	/** 
	 * Sets the lineAddress of this address.
	 * @param lineAddress The  lineAddress to be set.
	 */
	public void setLineAddress(String lineAddress) {
		this.lineAddress = lineAddress;
	}

	/**
	 * Retrieves the country of the address.
	 * @return The country of this address.
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the county of this address.
	 * @param country The country to be set.
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
