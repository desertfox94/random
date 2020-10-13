package de.desertfox.random;

public class Randoms {

	private Randoms() {
	}

	static final java.util.Random RANDOM = new java.util.Random();

	public static char random(final char lower, final char upper) {
		return random(lower, upper);
	}

	public static int random(final int lower, final int upper) {
		return lower + RANDOM.nextInt(upper - lower);
	}
}
