package de.desertfox.random.person;

import de.desertfox.random.RandomStrings;

import java.util.List;

import static de.desertfox.random.Collections.randomOf;
import static de.desertfox.random.Randoms.bool;
import static de.desertfox.random.Utils.load;

public class Names {

	private static List<String> surNames;

	private static List<String> femaleNames;

	private static List<String> maleNames;

	private static final String FORMAT = "%s %s";

	private static Names instance;

	public static Names getInstance() {
		if (instance == null) {
			instance = new Names();
		}
		return instance;
	}

	public String surName() {
		if (surNames == null) {
			surNames = load("sur_name.txt");
		}
		return randomOf(surNames);
	}

	public String foreName() {
		return bool() ? femaleName() : maleName();
	}

	public String femaleName() {
		if (femaleNames == null) {
			femaleNames = load("female.txt");
		}
		return randomOf(femaleNames);
	}

	public String maleName() {
		if (maleNames == null) {
			maleNames = load("male.txt");
		}
		return randomOf(maleNames);
	}

	public String fullName() {
		return format(foreName(), surName());
	}

	public String fullFemaleName() {
		return format(femaleName(), surName());
	}

	public String fullMaleName() {
		return format(maleName(), surName());
	}

	public String userName() {
		return (RandomStrings.alpha(1).toLowerCase() + surName()).toLowerCase();
	}

	private String format(String firstName, String lastName) {
		return String.format(FORMAT, firstName, lastName);
	}

}
