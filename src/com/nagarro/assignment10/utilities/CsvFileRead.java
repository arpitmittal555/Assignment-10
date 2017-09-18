package com.nagarro.assignment10.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.nagarro.assignment10.resourceconstants.ResLogger;

/**
 * converts the csv file to hashmap.
 *
 * @author arpitmittal01
 */
public final class CsvFileRead {

	private CsvFileRead() {
	}

	/**
	 * parses the csv file to the required hashmap.
	 *
	 * @param path
	 *            path of the csv file
	 * @param delimiter
	 *            the delimiter
	 * @return the list
	 */
	public static List<Map<String, String>> parser(final String path, char delimiter) {
		Map<String, String> hash;
		List<String> details = new ArrayList<>(9);
		List<String> heading = new ArrayList<>(9);
		List<Map<String, String>> result = new ArrayList<>(5);
		String line = null;
		try (BufferedReader reader = new BufferedReader(new FileReader(path));) {

			line = reader.readLine();
			heading = Split.splitString(line, delimiter);
			line = reader.readLine();
			while (line != null) {
				hash = new ConcurrentHashMap<>();
				details = Split.splitString(line, delimiter);
				StringBuffer strBfr = new StringBuffer();
				for (int i = 0; i < heading.size(); i++) {

					strBfr = strBfr.append(details.get(i).toString());
					hash.put(heading.get(i), details.get(i));
				}
				line = reader.readLine();
				result.add(hash);
			}
		} catch (final IOException e) {
			ResLogger.log.error(e);
		}

		return result;
	}
}
