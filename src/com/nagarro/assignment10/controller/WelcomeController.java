package com.nagarro.assignment10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nagarro.assignment10.constants.TileViews;

/**
 * The Controller WelcomeController to return the Welcome Page to the view
 * Resolver
 */
@Controller
public class WelcomeController {

	/**
	 * Loads the WelcomeTile in the browser
	 *
	 * @return the string
	 */
	@RequestMapping(value = "welcome")
	public String welcomeCall() {
		return TileViews.WELCOME_TILE;
	}
}
