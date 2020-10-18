package de.desertfox.random;

import de.desertfox.random.person.Names;

public class App {

	public static void main(String[] args) {
		Names names = Names.getInstance();
		System.out.println(names.femaleName());
		System.out.println(names.maleName());
		System.out.println(names.surName());
		System.out.println(names.fullFemaleName());
		System.out.println(names.fullMaleName());
		System.out.println(names.fullName());
		System.out.println(names.userName());
	}

}
