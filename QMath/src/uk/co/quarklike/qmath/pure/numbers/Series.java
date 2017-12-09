package uk.co.quarklike.qmath.pure.numbers;

import java.util.HashMap;

public class Series {
	/**
	 * 
	 * @param a
	 *            n - 1
	 * @param b
	 *            n
	 * @param c
	 *            n + 1
	 * @return
	 */
	public static double shanksTransform_1(double a, double b, double c) {
		double top = Powers.square(c - b);
		double bottom = (c - b) - (b - a);
		return c - (top / bottom);
	}

	public static double shanksTransform_2(double a, double b, double c, double d, double e) {
		return shanksTransform_1(shanksTransform_1(a, b, c), shanksTransform_1(b, c, d), shanksTransform_1(c, d, e));
	}

	public static double shanksTransform_3(double a, double b, double c, double d, double e, double f, double g) {
		return shanksTransform_1(shanksTransform_2(a, b, c, d, e), shanksTransform_2(b, c, d, e, f), shanksTransform_2(c, d, e, f, g));
	}

	public static int kroneckerDelta(int i, int j) {
		return i == j ? 1 : 0;
	}

	private static HashMap<Integer, Double> cache_bernoulli = new HashMap<Integer, Double>();

	public static double bernoulliNumber(int m) {
		if (cache_bernoulli.containsKey(m))
			return cache_bernoulli.get(m);

		double[] nums = new double[m];

		for (int k = 0; k <= m - 1; k++) {
			nums[k] = (biCoeff(m, k) * ((bernoulliNumber(k)) / (m - k + 1)));
		}

		double out = kroneckerDelta(m, 0) - Sum.sumNumbers(nums);
		cache_bernoulli.put(m, out);
		return out;
	}

	// public static double eulerNumber(int n) {
	// if (n % 2 == 1)
	// return 0;
	//
	// }

	/**
	 * Binomial coefficient i.e. "n choose k"
	 */
	public static long biCoeff(int n, int k) {
		if (k > n || k < 0)
			return 0;

		return (Factorial.factorial(n)) / (Factorial.factorial(k) * Factorial.factorial(n - k));
	}
}
