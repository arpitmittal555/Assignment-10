package com.nagarro.assignment10.utilities;

import java.util.ArrayList;
import java.util.List;

/**
 * The utility to Split any String.
 *
 * @author arpitmittal01
 */
public final class Split {

	/**
	 * Instantiates a new split.
	 */
	private Split() {
	}

	/**
	 * splits the string according to the delimiter.
	 *
	 * @param str
	 *            string sent by the calling function
	 * @param delimiter
	 *            char to determine from where the string is divided
	 * @return the list
	 */
	public static List<String> splitString(final String str, final char delimiter) {

		final List<String> list = new ArrayList<>();

		int stringStarter = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == delimiter) {
				if (i == 0) {
					stringStarter = 1;
				} else {
					list.add(str.substring(stringStarter, i));
					stringStarter = i + 1;
				}

			}
		}

		list.add(str.substring(stringStarter, str.length()));

		return list;

	}

}
