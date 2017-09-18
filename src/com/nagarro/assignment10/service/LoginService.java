package com.nagarro.assignment10.service;

import com.nagarro.assignment10.dao.LoginDao;

/**
 * The Service Class LoginService to give the Singleton instance of the Login
 * Service class to the COntroller and perform the Login check from the Dao
 * layer
 */
public interface LoginService {

	/**
	 * Check login details of the user y sending the username and password to
	 * the Dao later function
	 *
	 * @param userName
	 *            the user name
	 * @param password
	 *            the password
	 * @param type
	 *            the type if user or Admin
	 * @return true, if successful
	 */
	public boolean checkLogin(String userName, String password, String type);

}
