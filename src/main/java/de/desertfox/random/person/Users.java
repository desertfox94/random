package de.desertfox.random.person;

import de.desertfox.random.Email;

public class Users {

	public static DummyUser random() {
		Names names = Names.getInstance();
		String firstName = names.foreName();
		String lastName = names.surName();
		String username = (firstName.charAt(0) + lastName).toLowerCase();
		String email = Email.of(firstName, lastName);
		return new DummyUser(username, firstName, lastName, email);
	}
}
