package com.nagarro.assignment10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nagarro.assignment10.constants.TileViews;

/**
 * The Controller AdminController to handle the request for upload page by the
 * Admin when the user is logged in with the admin user and password
 */
@Controller
public class AdminController {

	/**
	 * URL request for the URL <code>/upload</code> is handled and the tile view
	 * of <b>uploadTile</b> is returned to the tile resolver
	 *
	 * @return the tile <i>uploadTile</i>
	 */
	@RequestMapping("upload")
	public String uploadData() {
		return TileViews.UPLOAD_TILE;
	}
}
