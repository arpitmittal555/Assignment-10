package com.nagarro.assignment10.resourceconstants;

import org.apache.log4j.Logger;

/**
 * Resource Logger Class to store the Root Logger object
 */
public final class ResLogger {

	/** The logger object. */
	public static final Logger log = Logger.getRootLogger();

	private ResLogger() {
	}

}
