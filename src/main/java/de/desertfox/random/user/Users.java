package de.desertfox.random.user;

import de.desertfox.random.Email;
import de.desertfox.random.names.Names;

public class Users {

	public static DummyUser random() {
		String firstName = Names.firstName();
		String lastName = Names.surName();
		String username = (firstName.charAt(0) + lastName).toLowerCase();
		String email = Email.of(firstName, lastName);
		return new DummyUser(username, firstName, lastName, email);
	}
}
