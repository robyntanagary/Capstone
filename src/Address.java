
public class Address {
	private String lineAddress;
	private String country;
	
	public Address()
	{
		setLineAddress("");
		setCountry("Unknown");
	}
	
	public Address(String line, String country)
	{
		setLineAddress(line);
		setCountry(country);
	}

	/**
	 * Retrieves the lineAddress
	 * @return the lineAddress
	 */
	public String getLineAddress() {
		return lineAddress;
	}

	/** 
	 * Set lineAddress of this address.
	 * @param lineAddress the Specified lineAddress to set
	 */
	public void setLineAddress(String lineAddress) {
		this.lineAddress = lineAddress;
	}

	/**
	 * Returns the country of this address
	 * @return the country specified in this address.
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Set the specified county to this address.
	 * @param country The specified country to set.
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
