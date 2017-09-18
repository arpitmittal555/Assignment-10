package com.nagarro.assignment10.forms;

import javax.validation.constraints.Size;

/**
 * The Form Class LoginForm to model the Login Form for the user and store the
 * fields entered by the user
 */
public class LoginForm {

	/** The user name. */
	@Size(min = 1, max = 50)
	private String userName;

	/** The password. */
	@Size(min = 1, max = 20)
	private String password;

	/** The user type. */
	private String userType;

	/**
	 * Sets the user name.
	 *
	 * @param userName
	 *            the new user name
	 */
	public void setUserName(final String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the password.
	 *
	 * @param password
	 *            the new password
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Gets the user type.
	 *
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * Sets the user type.
	 *
	 * @param userType
	 *            the userType to set
	 */
	public void setUserType(final String userType) {
		this.userType = userType;
	}
}
