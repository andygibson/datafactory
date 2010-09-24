package org.fluttercode.datafactory;


public interface AddressDataValues {
	
	/**
	 * @return Array of street address
	 */
	String[] getStreetNames();

	/**
	 * @return Array of cities
	 */
	String[] getCities();

	/**
	 * Returns a list of address suffixes such as "Lane", "Drive","Parkway"
	 * @return Array of address suffixes
	 */
	String[] getAddressSuffixes();

}
