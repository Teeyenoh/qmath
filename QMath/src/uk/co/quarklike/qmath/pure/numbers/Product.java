package uk.co.quarklike.qmath.pure.numbers;

public class Product {
	/**
	 * Returns the multiples of n between start and end (inclusive)
	 * 
	 * @param n
	 *            the number you are finding multiples of
	 * @param start
	 *            the first number to look at
	 * @param end
	 *            the last number to look at
	 * @return
	 */
	public static long[] multiplesOf(long n, int start, int end) {
		long actualStart = start % n == 0 ? start : start + (n - (start % n));
		int length = (int) (((end - actualStart) / n) + 1);
		long[] out = new long[length];

		for (int i = 0; i < out.length; i++) {
			out[i] = actualStart + (n * i);
		}

		return out;
	}

	public static long multiplyNumbers(long[] list) {
		long out = 1;

		for (long l : list) {
			out *= l;
		}

		return out;
	}
}
