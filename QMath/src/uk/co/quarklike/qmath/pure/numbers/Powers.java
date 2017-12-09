package uk.co.quarklike.qmath.pure.numbers;

public class Powers {
	public static long[] squares(int start, int end) {
		long[] output = new long[end - start + 1];

		for (int i = start; i <= end; i++) {
			output[i - start] = square(i);
		}

		return output;
	}

	public static long square(long num) {
		return num * num;
	}

	public static double square(double num) {
		return num * num;
	}

	public static Complex raiseToPower(Complex a, int b) {
		Complex out = a;
		for (int i = 0; i < b; i++) {
			out = out.multiply(a);
		}
		return out;
	}

	/**
	 * Babylonian method
	 * 
	 * @param num
	 *            number to be square rooted
	 * @return
	 */
	public static double sqrt(double num) {
		double guess = num / 2;
		double lastGuess = 0;
		while (guess - lastGuess != 0) {
			lastGuess = guess;
			guess = (guess + (num / guess)) / 2;
		}

		return guess;
	}
}
