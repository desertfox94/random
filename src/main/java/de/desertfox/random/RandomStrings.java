package de.desertfox.random;

public final class RandomStrings {

	private static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String NUMERIC = "0123456789";
	private static final String ALPHA_LOWER = ALPHA.toLowerCase();
	private static final String ALPHA_WITH_LOWER = ALPHA + ALPHA_LOWER;
	private static final String ALPHA_NUMERIC = ALPHA + NUMERIC;
	private static final String ALPHA_WITH_LOWER_AND_NUMERIC = ALPHA_WITH_LOWER + NUMERIC;

	private RandomStrings() {	}

	public static String alpha(int length) {
		return create(ALPHA, length);
	}

	public static String alphaWithLower(int length) {
		return create(ALPHA_WITH_LOWER, length);
	}

	public static String alphaNumeric(int length) {
		return create(ALPHA_NUMERIC, length);
	}

	public static String numeric(int length) {
		return create(NUMERIC, length);
	}

	public static String create(String alphabet, int length) {
		return create(alphabet.toCharArray(), length);
	}

	public static String create(char[] chars, int length) {
		char[] result = new char[length];
		for (int i = 0; i <= length; i++) {
			result[i] = Collections.randomOf(chars);
		}
		return new String(result);
	}


}
