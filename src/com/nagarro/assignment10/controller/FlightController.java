package com.nagarro.assignment10.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.assignment10.constants.TileViews;
import com.nagarro.assignment10.dto.FlightDetailDto;
import com.nagarro.assignment10.forms.FlightSearchForm;
import com.nagarro.assignment10.forms.LoginForm;
import com.nagarro.assignment10.resourceconstants.ResLogger;
import com.nagarro.assignment10.service.FlightCommonService;
import com.nagarro.assignment10.session.Session;

/**
 * The Controller FlightController to handle the Url requests for the flight
 * searches which can be given by users logged in as <i>user</i> or <i>admin</i>
 * 
 */
@Controller
public class FlightController {

	@Autowired(required=false)
	private FlightCommonService flightservice;

	/**
	 * Loads the tileview for the user for the URL request
	 * <code>/flightSearch</code> and give appropiate Tile (if logged in then
	 * <b>flightsearchform</b> else <b>loginTile</b>)
	 *
	 * @param model
	 *            the model object for flightSearchForm
	 * @param model2
	 *            the model object for LoginpageForm
	 * @return the ModelandView object with the appropiate tileview for
	 *         tileresolver
	 */
	@RequestMapping("flightSearch")
	public ModelAndView loadFlightSearchForm(final Map<String, FlightSearchForm> model,
			final Map<String, LoginForm> model2) {
		String result;
		if (Session.isLoggedIn()) {
			final FlightSearchForm flightSearchForm = new FlightSearchForm();
			model.put("flightSearchForm", flightSearchForm);
			result = TileViews.FLIGHT_SEARCH_TILE;
		} else {
			ResLogger.log.debug("user not logged in.. sending back to login page");
			final LoginForm loginForm = new LoginForm();
			model2.put("loginForm", loginForm);
			result = TileViews.LOGIN_TILE;
		}
		return new ModelAndView(result, "isSearch", false);
	}

	/**
	 * Process the flightsearch form after the URL
	 * <code>/processFlightSearch</code> is called by the browser. the @Valid
	 * annotaion checks the validations on the form and binds the result
	 * <code>result</code> to <code>flightSearchForm</code>
	 *
	 * @param flightSearchForm
	 *            the flight search form
	 * @param result
	 *            the result of validations
	 * @param model
	 *            the model
	 * @return the model and view as <code>flightSearchTile</code> with the
	 */

	@RequestMapping("processFlightSearch")
	public ModelAndView processSubmit(@Valid final FlightSearchForm flightSearchForm, final BindingResult result,
			final Map<String, Object> model) {

		if (result.hasErrors()) {
			ResLogger.log.debug("Flight search form has errors.. reloading the search form");
			return new ModelAndView("flightSearchTile", "isSearch", false);
		}
		final List<FlightDetailDto> matchedFlight = flightservice.flightSearch(flightSearchForm);
		model.put("result", result);
		model.put("formdata", flightSearchForm);
		model.put("matchedFlight", matchedFlight);
		return new ModelAndView("flightSearchTile", "isSearch", true);

	}

	/**
	 * Interceptor to set the Date format to <code>dd-mm-yyyy</code>
	 *
	 * @param binder
	 *            the binder
	 */
	@InitBinder
	public void initBinder(final WebDataBinder binder) {
		final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

}
