package com.exercises.maurycy.server;

import java.util.HashMap;
import java.util.Map;

import com.exercises.maurycy.client.MaurycyService;
import com.exercises.maurycy.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class MaurycyServiceImpl extends RemoteServiceServlet implements MaurycyService {

	public Map<Character, Integer> inspectString(String input) throws IllegalArgumentException {
		// Verify that the input is valid.
		if (!FieldVerifier.isValidName(input)) {
			// If the input is not valid, throw an IllegalArgumentException back
			// to
			// the client.
			throw new IllegalArgumentException("Name must be at least 4 characters long");
		}

		input = escapeHtml(input);

		// Linear speed + finite amount of entries so hash map is the best
		// solution
		final Map<Character, Integer> frequencies = new HashMap<Character, Integer>();
		for (Character c : input.toCharArray()) {
			frequencies.put(c, frequencies.containsKey(c) ? frequencies.get(c) + 1 : 1);
		}

		return frequencies;
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html
	 *            the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
	}
}
