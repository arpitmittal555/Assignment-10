package com.nagarro.assignment10.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.nagarro.assignment10.dto.FlightDetailDto;
import com.nagarro.assignment10.forms.FlightSearchForm;
import com.nagarro.assignment10.resourceconstants.ResLogger;

public class FlightsDaoImpl implements FlightsDao {

	@Override
	public List<FlightDetailDto> getFlightsData(FlightSearchForm flightSearchForm) {
		final Query searchQuery = new Query(Criteria.where("arrLoc").is(flightSearchForm.getArrivalLoc().toUpperCase())
				.and("depLoc").is(flightSearchForm.getDepartureLoc().toUpperCase()).and("validTill")
				.gt(flightSearchForm.getFlightDate()).and("flightClass").regex(flightSearchForm.getFlightClass())
				.and("seatAvailability").is("Y"));
		ResLogger.log.debug("Query:-" + searchQuery);
		searchQuery.with(new Sort(new Order(Direction.ASC, flightSearchForm.getPreference())));
		List<FlightDetailDto> list = new ArrayList<>(9);
		try {
			list = mongoOperation.find(searchQuery, FlightDetailDto.class, "flightsData");
		} catch (Exception e) {
			ResLogger.log.error(e);
			return null;
		}
		return list;

	}

	@Override
	public void insertFlightsData(List<FlightDetailDto> listFlightDto) {

		for (final FlightDetailDto flight : listFlightDto) {
			try {
				mongoOperation.save(flight, "flightsData");
			} catch (Exception e) {
				ResLogger.log.error(e);
			}
		}
	}

}
