package de.desertfox.random;

import de.desertfox.random.person.Names;

import java.util.List;

import static de.desertfox.random.Collections.randomOf;
import static de.desertfox.random.Utils.load;

public class Email {

	public static List<String> emailDomains;

	private static final String FORMAT = "%s.%s@%s";

	private static final Names names = Names.getInstance();

	public static String random() {
		return of(names.foreName(), names.surName());
	}

	public static String of(String firstName, String lastName) {
		if (emailDomains == null) {
			emailDomains = load("email_domains.txt");
		}
		return String.format(FORMAT, firstName, lastName, randomOf(emailDomains));
	}
}
