#include "Primes.h"

#include <iostream>

namespace QMath {
	// Returns true if n is a prime number (only factors are 1 and itself)
	bool Primes::isPrime(QLong n) {
		double root = Powers::getSqrt(n); // Finds the square root of n

		for (QLong i = 2; i < root; i++) { // Iterates through each natural number less than the root of n
			if (Factors::hasFactor(n, i)) // Checks if i is a factor
				return false; // If it has factors, it isn't prime
		}

		return true;
	}

	// Returns the nth prime number
	QLong Primes::getPrime(int n) {
		int primes = 0; // Sets prime count to 0 (possible candidate for prime map to reduce time of later checks?)
		for (QLong i = 2; true; i++) { // Iterates through each natural number
			if (isPrime(i)) // If it's prime, add 1 to the prime count
				primes++;
			if (primes == n) // If done, return the prime
				return i;
		}
		return 0; // Shouldn't be reached
	}

	std::list<QLong> Primes::getPrimeFactors(QLong n) {
		std::cout << "Finding prime factors of " << n << std::endl;
		std::list<QLong> out = std::list<QLong>();

		double root = Powers::getSqrt(n);
		for (int i = 1; true; i++) {
			QLong prime = getPrime(i);
			if (prime <= root && n > 1) {
				while (Factors::hasFactor(n, prime)) {
					n /= prime;
					out.push_back(prime);
				}
			} else {
				break;
			}
		}

		return out;
	}
}