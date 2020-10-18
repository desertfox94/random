package de.desertfox.random.names;

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

	public static String surName() {
		if (surNames == null) {
			surNames = load("sur_name.txt");
		}
		return randomOf(surNames);
	}

	public static String firstName() {
		return bool() ? femaleName() : maleName();
	}

	public static String femaleName() {
		if (femaleNames == null) {
			femaleNames = load("female.txt");
		}
		return randomOf(femaleNames);
	}

	public static String maleName() {
		if (maleNames == null) {
			maleNames = load("male.txt");
		}
		return randomOf(maleNames);
	}

	public static String fullName() {
		return format(firstName(), surName());
	}

	public static String fullFemaleName() {
		return format(femaleName(), surName());
	}

	public static String fullMaleName() {
		return format(maleName(), surName());
	}

	public static String userName() {
		return (RandomStrings.alpha(1).toLowerCase() + surName()).toLowerCase();
	}

	private static String format(String firstName, String lastName) {
		return String.format(FORMAT, firstName, lastName);
	}

}
