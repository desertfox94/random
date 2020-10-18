package de.desertfox.random;

import java.util.List;

import static de.desertfox.random.Collections.randomOf;
import static de.desertfox.random.Utils.load;
import static de.desertfox.random.names.Names.firstName;
import static de.desertfox.random.names.Names.surName;

public class Email {

	public static List<String> emailDomains;

	private static final String FORMAT = "%s.%s@%s";

	public static String random() {
		return of(firstName(), surName());
	}

	public static String of(String firstName, String lastName) {
		if (emailDomains == null) {
			emailDomains = load("email_domains.txt");
		}
		return String.format(FORMAT, firstName, lastName, randomOf(emailDomains));
	}
}
