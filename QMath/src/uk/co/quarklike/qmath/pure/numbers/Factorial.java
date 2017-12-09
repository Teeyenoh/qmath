package uk.co.quarklike.qmath.pure.numbers;

import java.util.HashMap;

public class Factorial {
	private static HashMap<Long, Long> cache_factorial = new HashMap<Long, Long>();

	public static long factorial(long n) {
		if (cache_factorial.containsKey(n))
			return cache_factorial.get(n);

		long out = 1;
		for (long i = n; i > 0; i--) {
			out *= i;
			if (out >= Long.MAX_VALUE)
				return 1;
		}
		cache_factorial.put(n, out);
		return out;
	}
}
