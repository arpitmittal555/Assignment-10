package com.nagarro.assignment10.forms;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The Form Class FlightSearchForm to model the Flight Search Form for the user
 * and store the fields entered by the user
 */
public class FlightSearchForm {

	/** The departure loc. */
	@Size(min = 3, max = 3)
	private String departureLoc;

	/** The arrival loc. */
	@Size(min = 3, max = 3)
	private String arrivalLoc;

	/** The flight class. */
	private String flightClass;

	/** The flight date. */
	@NotNull(message = "Date Cannot Be Empty")
	private Date flightDate;

	/** The preference. */
	private String preference;

	/**
	 * Gets the departure loc.
	 *
	 * @return the departureLoc
	 */
	public String getDepartureLoc() {
		return departureLoc;
	}

	/**
	 * Sets the departure loc.
	 *
	 * @param departureLoc
	 *            the departureLoc to set
	 */
	public void setDepartureLoc(final String departureLoc) {
		this.departureLoc = departureLoc;
	}

	/**
	 * Gets the arrival loc.
	 *
	 * @return the arrivalLoc
	 */
	public String getArrivalLoc() {
		return arrivalLoc;
	}

	/**
	 * Sets the arrival loc.
	 *
	 * @param arrivalLoc
	 *            the arrivalLoc to set
	 */
	public void setArrivalLoc(final String arrivalLoc) {
		this.arrivalLoc = arrivalLoc;
	}

	/**
	 * Gets the flight class.
	 *
	 * @return the flightClass
	 */
	public String getFlightClass() {
		return flightClass;
	}

	/**
	 * Sets the flight class.
	 *
	 * @param flightClass
	 *            the flightClass to set
	 */
	public void setFlightClass(final String flightClass) {
		this.flightClass = flightClass;
	}

	/**
	 * Gets the flight date.
	 *
	 * @return the flightDate
	 */
	public Date getFlightDate() {
		return flightDate;
	}

	/**
	 * Sets the flight date.
	 *
	 * @param flightDate
	 *            the flightDate to set
	 */
	public void setFlightDate(final Date flightDate) {
		this.flightDate = flightDate;
	}

	/**
	 * Gets the preference.
	 *
	 * @return the preference
	 */
	public String getPreference() {
		return preference;
	}

	/**
	 * Sets the preference.
	 *
	 * @param preference
	 *            the preference to set
	 */
	public void setPreference(final String preference) {
		this.preference = preference;
	}
}
