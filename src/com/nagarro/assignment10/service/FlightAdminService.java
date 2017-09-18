package com.nagarro.assignment10.service;

import java.util.List;

import com.nagarro.assignment10.dto.FlightDetailDto;

/**
 * The Service FlightService interface to give the controller an interface to
 * connect to the Flight DAO Model Layer for admin only
 */
public interface FlightAdminService {

	/**
	 * Service function which call the Flight Dao layer method to insert the
	 * FLight list in the Database via Dao layer
	 * 
	 * @param listFlightDto
	 *            the list flight dto
	 */
	public void flightInsert(final List<FlightDetailDto> listFlightDto);

}
