package uk.co.quarklike.qmath.pure.numbers;

public class Sum {
	public static long sumNumbers(long[] numbers) {
		long out = 0;

		for (long i : numbers) {
			out += i;
		}

		return out;
	}

	public static double sumNumbers(double[] numbers) {
		double out = 0;
		

		for (double i : numbers) {
			out += i;
		}

		return out;
	}
}
