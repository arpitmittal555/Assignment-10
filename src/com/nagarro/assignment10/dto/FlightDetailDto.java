package com.nagarro.assignment10.dto;

import java.util.Date;

/**
 * The DTO Class FlightDetail to be mapped to the Database Table 
 * .
 */

public class FlightDetailDto {

	/** The primary key flight no. */
	private String flightNo;

	/** The departure location. */
	private String depLoc;

	/** The arrival location. */
	private String arrLoc;

	/** The date flight is valid till. */
	private Date validTill;

	/** The flight time. */
	private String flightTime;

	/** The flight duration. */
	private String flightDur;

	/** The flight fare. */
	private String fare;

	/** The seat availability in flight. */
	private String seatAvailability;

	/** The flight class. */
	private String flightClass;

	/**
	 * Gets the arr loc.
	 *
	 * @return the arrLoc
	 */
	public String getArrLoc() {
		return arrLoc;
	}

	/**
	 * Gets the dep loc.
	 *
	 * @return the depLoc
	 */
	public String getDepLoc() {
		return depLoc;
	}

	/**
	 * Gets the fare.
	 *
	 * @return the fare
	 */
	public String getFare() {
		return fare;
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
	 * Gets the flight dur.
	 *
	 * @return the flightDur
	 */
	public String getFlightDur() {
		return flightDur;
	}

	/**
	 * Gets the flight no.
	 *
	 * @return the flightNo
	 */
	public String getFlightNo() {
		return flightNo;
	}

	/**
	 * Gets the flight time.
	 *
	 * @return the flightTime
	 */
	public String getFlightTime() {
		return flightTime;
	}

	/**
	 * Gets the seat availability.
	 *
	 * @return the seatAvailability
	 */
	public String getSeatAvailability() {
		return seatAvailability;
	}

	/**
	 * Gets the valid till.
	 *
	 * @return the validTill
	 */
	public Date getValidTill() {
		return validTill;
	}

	/**
	 * Sets the arr loc.
	 *
	 * @param arrLoc
	 *            the arrLoc to set
	 */
	public void setArrLoc(final String arrLoc) {
		this.arrLoc = arrLoc;
	}

	/**
	 * Sets the dep loc.
	 *
	 * @param depLoc
	 *            the depLoc to set
	 */
	public void setDepLoc(final String depLoc) {
		this.depLoc = depLoc;
	}

	/**
	 * Sets the fare.
	 *
	 * @param fare
	 *            the fare to set
	 */
	public void setFare(final String fare) {
		this.fare = fare;
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
	 * Sets the flight dur.
	 *
	 * @param flightDur
	 *            the flightDur to set
	 */
	public void setFlightDur(final String flightDur) {
		this.flightDur = flightDur;
	}

	/**
	 * Sets the flight no.
	 *
	 * @param flightNo
	 *            the flightNo to set
	 */
	public void setFlightNo(final String flightNo) {
		this.flightNo = flightNo;
	}

	/**
	 * Sets the flight time.
	 *
	 * @param flightTime
	 *            the flightTime to set
	 */
	public void setFlightTime(final String flightTime) {
		this.flightTime = flightTime;
	}

	/**
	 * Sets the seat availability.
	 *
	 * @param seatAvailability
	 *            the seatAvailability to set
	 */
	public void setSeatAvailability(final String seatAvailability) {
		this.seatAvailability = seatAvailability;
	}

	/**
	 * Sets the valid till.
	 *
	 * @param validTill
	 *            the validTill to set
	 */
	public void setValidTill(final Date validTill) {
		this.validTill = validTill;
	}

}
