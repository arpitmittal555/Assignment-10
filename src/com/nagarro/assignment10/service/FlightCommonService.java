package com.nagarro.assignment10.service;

import java.util.List;

import com.nagarro.assignment10.dao.FlightsDao;
import com.nagarro.assignment10.dto.FlightDetailDto;
import com.nagarro.assignment10.forms.FlightSearchForm;

/**
 * The Service FlightService interface to give the controller an interface to connect to
 * the Flight DAO Model Layer for users of type client and admin
 */
public interface FlightCommonService {

	/**
	 * Service function which call the Flight Dao layer method to search the
	 * FLight list from the Dao layer based on the flightSearchForm entered by
	 * the user
	 *
	 * @param flightSearchForm
	 *            the flight search form
	 * @return the result list of all Flights
	 */
	public List<FlightDetailDto> flightSearch(final FlightSearchForm flightSearchForm);

}
