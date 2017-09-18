package com.nagarro.assignment10.dao;

/**
 * The Dao Layer for LoginDao which checks the login details of the user login
 * username and password and admin username and password
 */
public interface LoginDao {

	/**
	 * verifies if the username and Password entered by the User matches
	 *
	 * @param userName
	 *            the user name
	 * @param password
	 *            the password
	 * @return true, if successful
	 */
	public boolean checkUser(final String userName, final String password);

	
	/**
	 * verifies if the username and Password entered by the Admin matches
	 *
	 * @param userName
	 *            the user name
	 * @param password
	 *            the password
	 * @return true, if successful
	 */
	public boolean checkAdmin(final String userName, final String password);

}
