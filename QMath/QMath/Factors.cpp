#include "Factors.h"

#include <iostream>

namespace QMath {
	// Returns true if f is a factor of n
	bool Factors::hasFactor(QLong n, QLong f) {
		return n % f == 0; // Using basic modulus mathematics
	}

	// Returns all multiples of f below n
	std::list<QLong> Factors::getAllMultiplesBelow(QLong n, QLong f) {
		std::list<QLong> out = std::list<QLong>(); // Creates a list to hold all of the multiples
		for (int i = f; i < n; i += f) { // Iterates through each multiple until it reaches n
			out.push_back(i); // Adds i to the end of the list
		}
		return out;
	}
}