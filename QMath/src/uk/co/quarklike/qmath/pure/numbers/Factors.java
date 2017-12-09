package uk.co.quarklike.qmath.pure.numbers;

import uk.co.quarklike.qmath.discrete.ArrayTools;

public class Factors {
	public static long[] getPrimeFactors(long n) {
		long[] factors = new long[100];
		int nextFactor = 0;
		long copy = n;

		long prime = 0;

		for (int i = 0; prime <= copy; i++) {
			prime = Primes.getPrime(i);

			while ((copy % prime) == 0) {
				factors[nextFactor] = prime;
				copy /= prime;
				nextFactor++;
			}
		}

		factors = ArrayTools.trim(factors, nextFactor);

		return factors;
	}

	public static long[] getFactors(long n) {
		long[] factors = new long[(int) n];
		int nextFactor = 0;

		double root = Powers.sqrt(n);
		if ((int) root == root) {
			factors[nextFactor] = (int) root;
			nextFactor++;
		}

		for (int i = 1; i < root; i++) {
			if ((n % i) == 0) {
				factors[nextFactor] = i;
				factors[nextFactor + 1] = n / i;
				nextFactor += 2;
			}
		}

		factors = ArrayTools.trim(factors, nextFactor);

		return factors;
	}

	public static int getFactorCount(long n) {
		if (n == 0) {
			return 0;
		}

		long[] pfs = getPrimeFactors(n);
		long[] exps = new long[pfs.length];
		long last = 0;
		int index = -1;

		for (long p : pfs) {
			if (p != last) {
				index++;
				exps[index] = 1;
			}

			exps[index]++;
			last = p;
		}

		return (int) Product.multiplyNumbers(ArrayTools.trim(exps, index + 1));
	}
}
