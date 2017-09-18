package com.nagarro.assignment10.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.assignment10.constants.TileViews;
import com.nagarro.assignment10.forms.LoginForm;
import com.nagarro.assignment10.resourceconstants.ResLogger;
import com.nagarro.assignment10.service.LoginService;
import com.nagarro.assignment10.session.Session;

/**
 * The Controller LoginController to handle the Url requests for the
 * Login/logout requests to let the user log in as User or Admin
 */
@Controller
public class LoginController {

	@Autowired
	public LoginService loginService;

	/**
	 * Loads the Login Form <code>loginTile</code> for the user if the user is
	 * not already logged in .
	 *
	 * @param model
	 *            the model
	 * @return the model and view as <code>loginTile</code>
	 */
	@RequestMapping("login")
	public ModelAndView loginTile(final Map<String, LoginForm> model) {

		String result;
		if (!Session.isLoggedIn()) {
			final LoginForm loginForm = new LoginForm();
			model.put("loginForm", loginForm);
			result = TileViews.LOGIN_TILE;
		} else {
			result = TileViews.WELCOME_TILE;
		}
		return new ModelAndView(result);
	}

	/**
	 * Removes the Session attribute and Logs out the user from the Session
	 *
	 * @param model
	 *            the model
	 * @return the <code>welcomeTile</code> view after the user logs out with an
	 *         option to log in again
	 */
	@RequestMapping("logout")

	public String logoutTile(final Map<String, LoginForm> model) {
		if (Session.isLoggedIn()) {
			Session.setLoggedIn(false);
			Session.setAdmin(false);

		}
		return "welcomeTile";
	}

	/**
	 * Process loginForm entered by the user and sends a request to LoginService
	 * to check for the Username and Password combination. if the user logs in
	 * as Admin, it sets <code>isAdmin</code> as true and provide the option to
	 * upload csv data
	 *
	 * @param loginForm
	 *            the login form entered by the user
	 * @param result
	 *            the Binding result after the Validations on fields of Login
	 *            Form
	 * @return the view <b>welcomeTile</b> if the user successfully logs in or
	 *         login page
	 */

	@RequestMapping("loginForm")
	public String processLogin(@Valid final LoginForm loginForm, final BindingResult result) {

		if (result.hasErrors()) {
			ResLogger.log.debug("Login form has errors.. reloading the search form");
			return "loginTile";
		}

		final boolean userExists = loginService.checkLogin(loginForm.getUserName(), loginForm.getPassword(),
				loginForm.getUserType());

		if (userExists) {
			Session.setLoggedIn(true);
			if (("admin").equals(loginForm.getUserType())) {
				Session.setAdmin(true);
			}
			return "welcomeTile";
		} else {
			ResLogger.log.debug("Invalid Username Password Combination");
			result.rejectValue("userName", "invaliduser");
			return "loginTile";
		}
	}

}
