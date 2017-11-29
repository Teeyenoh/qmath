#include "Factors.h"

#include <iostream>

namespace QMath {
	// Returns true if f is a factor of n
	bool Factors::hasFactor(QLong n, QLong f) {
		return n % f == QLong(0); // Using basic modulus arithmetic
	}

	QLong Factors::getLCM(QLong n1, QLong n2) {
		std::list<QLong> p1 = Primes::getPrimeFactors(n1);
		std::list<QLong> p2 = Primes::getPrimeFactors(n2);

		QLong lcm = n1 * n2;

		for (QLong v : p1) {
			if (std::find(p2.begin(), p2.end(), v) != p2.end()) {
				p2.erase(std::find(p2.begin(), p2.end(), v));
				lcm /= v;
			}
		}

		return lcm;
	}

	QLong Factors::getLCM(QLong ns[], int length) {
		QLong lcf = ns[0];
		for (int i = 1; i < (int) length; i++) {
			lcf = getLCM(lcf, ns[i]);
		}
		return lcf;
	}

	// Returns all multiples of f below n
	std::list<QLong> Factors::getAllMultiplesBelow(QLong n, QLong f) {
		std::list<QLong> out = std::list<QLong>(); // Creates a list to hold all of the multiples
		for (QLong i = f; i < n; i += f) { // Iterates through each multiple until it reaches n
			out.push_back(i); // Adds i to the end of the list
		}
		return out;
	}
}