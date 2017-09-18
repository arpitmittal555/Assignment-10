package com.nagarro.assignment10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.assignment10.dao.FlightsDao;
import com.nagarro.assignment10.dto.FlightDetailDto;
import com.nagarro.assignment10.resourceconstants.ResLogger;

/**
 * The Service FlightService interface to give the controller an interface to
 * connect to the Flight DAO Model Layer for admin only
 */
public class FlightAdminServiceImpl implements FlightAdminService {

	@Autowired(required = false)
	public FlightsDao flightsDao;

	/**
	 * Service function which call the Flight Dao layer method to insert the
	 * FLight list in the Database via Dao layer
	 * 
	 * @param listFlightDto
	 *            the list flight dto
	 */
	@Override
	public void flightInsert(List<FlightDetailDto> listFlightDto) {
		ResLogger.log.debug("Inserting Data in Flights Dao Layer");
		flightsDao.insertFlightsData(listFlightDto);
	}

}
