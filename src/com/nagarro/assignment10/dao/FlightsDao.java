package com.nagarro.assignment10.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.nagarro.assignment10.dto.FlightDetailDto;
import com.nagarro.assignment10.forms.FlightSearchForm;

/**
 * The Dao Layer for CRUD operations on Flights Database using the Mongo DB
 * using collection <b>flightsData</b> and Database <b>flightsDb</b>
 */
public interface FlightsDao {

	/**
	 * The contex object of the XML configuration to get the mongoTemplateBean
	 */
	static ApplicationContext ctx = new GenericXmlApplicationContext("classpath:mongo.xml");

	/** The mongo operation operation on the mongoTemplate Bean */
	static MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

	/**
	 * Gets the flights data from the Mongo DB according to the fields entered
	 * by the user in the <code>FlightSearchForm</code>
	 *
	 * @param flightSearchForm
	 *            the flight search form entered by the user comprissing of the
	 *            fields
	 *            <ul>
	 *            <li>Arrival Location</li>
	 *            <li>Departure Location</li>
	 *            <li>Flight Class</li>
	 *            <li>Date of Departure</li>
	 *            <li>Sorting preference</li>
	 *            </ul>
	 * @return the flights data result after gettting the filtered data from DB
	 */
	public List<FlightDetailDto> getFlightsData(final FlightSearchForm flightSearchForm);


	/**
	 * Insert flights data to the Mongo database from the List of
	 * FlightsDetailsDto..
	 *
	 * @param listFlightDto
	 *            the list flight dto
	 */
	public void insertFlightsData(final List<FlightDetailDto> listFlightDto);


}
