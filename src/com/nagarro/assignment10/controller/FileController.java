package com.nagarro.assignment10.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.assignment10.constants.TileViews;
import com.nagarro.assignment10.dto.FlightDetailDto;
import com.nagarro.assignment10.forms.LoginForm;
import com.nagarro.assignment10.resourceconstants.Bundle;
import com.nagarro.assignment10.resourceconstants.ResLogger;
import com.nagarro.assignment10.service.FlightAdminService;
import com.nagarro.assignment10.session.Session;
import com.nagarro.assignment10.utilities.CsvFileRead;

/**
 * The Controller FileController to handle the Url requests for the File
 * uploading by the Admin when the user logs in with the admin username and
 * password
 */
@Controller
public class FileController {

	@Autowired(required = false)
	private FlightAdminService fservice;

	/**
	 * URL request for the URL <code>/uploadFile</code> is handled and the tile
	 * view of <b>uploadTile</b> is returned to the tileresolver with the
	 * appropiate message i.e.
	 * <ul>
	 * <li><b>invalid format</b>- if the csv does no contains the required
	 * columns</li>
	 * <li><b>upload successfull</b>- if the csv is apporpiate and csv data
	 * passed to the service layer</li>
	 * 
	 * If the admin is not logged in but requesting for the URL
	 * <code>/uploadFile</code>, then he will be redirected to the Login page
	 * 
	 * @param request
	 *            the request
	 * @param fileUpload
	 *            the file uploaded by the admin
	 * @param model
	 *            the model
	 * @return the model and view
	 */
	@RequestMapping("uploadFile")
	public ModelAndView uploadFile(final HttpServletRequest request,
			@RequestParam final CommonsMultipartFile[] fileUpload, final Map<String, LoginForm> model) {
		String result;
		if (Session.isLoggedIn()) {
			final String saveDirectory = "D:/Assignment10/tempFiles/";
			if (fileUpload != null && fileUpload.length > 0) {
				for (final CommonsMultipartFile aFile : fileUpload) {

					ResLogger.log.debug("Saving file: " + aFile.getOriginalFilename());

					final File tempFile = new File(saveDirectory, aFile.getOriginalFilename());

					try {
						aFile.transferTo(tempFile);
					} catch (final IllegalStateException e) {
						ResLogger.log.error(e);
					} catch (final IOException ie) {
						ResLogger.log.error(ie);
					}

					final String filePath = saveDirectory + aFile.getOriginalFilename();
					final List<FlightDetailDto> listFlightDto = new ArrayList<>(9);
					final List<Map<String, String>> hash = CsvFileRead.parser(filePath, '|');
					for (final Map<String, String> map : hash) {
						final FlightDetailDto newFlight = new FlightDetailDto();
						try {
							if (map.get("ARR_LOC") == null || map.get("DEP_LOC") == null
									|| map.get("VALID_TILL") == null || map.get("CLASS") == null
									|| map.get("FLIGHT_NO") == null) {

								return new ModelAndView("uploadTile", "resultMsg",
										Bundle.MSG_BUND.getString("invalidFile"));
							}
							newFlight.setArrLoc(map.get("ARR_LOC"));
							newFlight.setDepLoc(map.get("DEP_LOC"));
							newFlight.setFare(map.get("FARE"));
							newFlight.setFlightClass(map.get("CLASS"));
							newFlight.setFlightDur(map.get("FLIGHT_DUR"));
							newFlight.setFlightNo(map.get("FLIGHT_NO"));
							newFlight.setFlightTime(map.get("FLIGHT_TIME"));
							newFlight.setSeatAvailability(map.get("SEAT_AVAILABILITY"));

							final DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
							Date date = new Date();
							try {
								date = df.parse(map.get("VALID_TILL"));
							} catch (final ParseException e) {
								ResLogger.log.error(e);
							}
							newFlight.setValidTill(date);
						} catch (final NullPointerException ne) {
							ResLogger.log.error(ne);
						}
						listFlightDto.add(newFlight);
					}

					fservice.flightInsert(listFlightDto);

				}
			}
			result = TileViews.UPLOAD_TILE;
		} else {
			ResLogger.log.debug("user not logged in.. sending back to login page");
			final LoginForm loginForm = new LoginForm();
			model.put("loginForm", loginForm);
			result = TileViews.LOGIN_TILE;
		}
		return new ModelAndView(result, "resultMsg", "File Uploaded...");

	}
}
