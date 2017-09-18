package com.nagarro.assignment10.session;

/**
 * The Class Session to store the Session Attributes for the user logged in as
 * User or Admin
 */
public class Session {


	/** The username. */
	private static String username;

	/** The password. */
	private static String password;

	/** If the user is in session */
	private static boolean isLoggedIn = false;

	/** If the user in session is Admin */
	private static boolean isAdmin = false;

	private Session() {
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public static String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username
	 *            the username to set
	 */
	public static void setUsername(String username) {
		Session.username = username;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public static String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password
	 *            the password to set
	 */
	public static void setPassword(String password) {
		Session.password = password;
	}

	/**
	 * Checks if is logged in.
	 *
	 * @return the isLoggedIn
	 */
	public static boolean isLoggedIn() {
		return isLoggedIn;
	}

	/**
	 * Sets the logged in.
	 *
	 * @param isLoggedIn
	 *            the isLoggedIn to set
	 */
	public static void setLoggedIn(boolean isLoggedIn) {
		Session.isLoggedIn = isLoggedIn;
	}

	/**
	 * Checks if is admin.
	 *
	 * @return the isAdmin
	 */
	public static boolean isAdmin() {
		return isAdmin;
	}

	/**
	 * Sets the admin.
	 *
	 * @param isAdmin
	 *            the isAdmin to set
	 */
	public static void setAdmin(boolean isAdmin) {
		Session.isAdmin = isAdmin;
	}

}
