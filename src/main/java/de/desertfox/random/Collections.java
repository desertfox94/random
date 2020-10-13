package de.desertfox.random;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public final class Collections {

	private static final Random RANDOM = new Random();

	private Collections() {};

	public static char randomOf(char[] items) {
		return items[RANDOM.nextInt(items.length)];
	}

	public static long randomOf(long[] items) {
		return items[RANDOM.nextInt(items.length)];
	}

	public static int randomOf(int[] items) {
		return items[RANDOM.nextInt(items.length)];
	}

	public static double randomOf(double[] items) {
		return items[RANDOM.nextInt(items.length)];
	}

	public static float randomOf(float[] items) {
		return items[RANDOM.nextInt(items.length)];
	}

	public static byte randomOf(byte[] items) {
		return items[RANDOM.nextInt(items.length)];
	}

	public static short randomOf(short[] items) {
		return items[RANDOM.nextInt(items.length)];
	}

	public static <T> T randomOf(T[] items) {
		return items[RANDOM.nextInt(items.length)];
	}

	public static  <T> T randomOf(List<T> items) {
		return items.get(RANDOM.nextInt(items.size()));
	}

	public static <T> T randomOfButNotIn(List<T> items, List<T> excludes) {
		T item = randomOf(items);
		if (excludes != null && !excludes.isEmpty()) {
			while (excludes.contains(item)) { // NOSONAR
				item = randomOf(items);
			}
		}
		return item;
	}

	public static <T> List<T> randomsOf(List<T> items) {
		return randomsOf(items, RANDOM.nextInt(items.size()) + 1);
	}

	public static <T> List<T> randomsOf(List<T> items, int n) {
		assert n <= items.size() : "n must be smaller than size!";
		assert n > 0 : "n must be greater than 0!";

		if (n == items.size()) return items;

		Set<T> randoms = new HashSet<>(n);
		while (randoms.size() != n) {
			randoms.add(randomOf(items));
		}
		return new ArrayList<>(randoms);
	}
}
