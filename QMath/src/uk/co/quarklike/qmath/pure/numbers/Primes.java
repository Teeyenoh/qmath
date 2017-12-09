package uk.co.quarklike.qmath.pure.numbers;

import java.util.HashMap;
import java.util.Set;

import uk.co.quarklike.qmath.discrete.ArrayTools;
import uk.co.quarklike.qmath.discrete.Sort;

public class Primes {
	private static HashMap<Integer, Long> primes = new HashMap<Integer, Long>();

	public static long getPrime(int n) {
		if (!primes.containsKey(0)) {
			primes.put(0, 2L);
			primes.put(1, 3L);
		}

		if (primes.containsKey(n)) {
			return primes.get(n);
		}

		int prime = getLargestStoredPrimeIndexBelow(n);
		long num = primes.get(prime);

		while (prime < n) {
			num += 2;

			if (isPrime(num))
				prime++;
		}

		primes.put(n, num);
		return num;
	}

	private static int getLargestStoredPrimeIndexBelow(int n) {
		Set<Integer> keys = primes.keySet();
		Integer[] arr = new Integer[keys.size()];
		keys.toArray(arr);

		long[] larr = new long[arr.length];
		for (int i = 0; i < arr.length; i++) {
			larr[i] = arr[i];
		}

		larr = Sort.shuttleSort(larr);
		int out = 0;
		int ind = larr.length - 1;
		while ((out = (int) larr[ind]) > n) {
			ind--;
		}
		return out;
	}

	public static long[] getPrimesBelow(int n) {
		long[] primes = ArrayTools.numberList(0, n - 1);

		primes[1] = 0;

		for (int i = 2; i < n / 2; i++) {
			for (int j = 2 * i; j < n; j += i) {
				primes[j] = 0;
			}
		}

		return ArrayTools.remove(primes, 0);
	}

	public static boolean isPrime(long n) {
		if (primes.containsValue(n))
			return true;

		for (int i = 2; i <= n / 2; i++) {
			if ((n % i) == 0) {
				return false;
			}
		}

		return true;
	}
}
