#include "Primes.h"

namespace QMath {
	bool Primes::isPrime(int n) {
		float root = Powers::getSqrt(n);

		for (int i = 2; i < root; i++) {
			if (n % i == 0)
				return false;
		}

		return true;
	}
}