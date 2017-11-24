#include "Factors.h"

#include <iostream>

namespace QMath {
	// Returns true if f is a factor of n
	bool Factors::hasFactor(int n, int f) {
		return n % f == 0;
	}

	// Returns all multiples of f below n
	std::list<int> Factors::getAllMultiplesBelow(int n, int f) {
		std::list<int> out = std::list<int>();
		for (int i = f; i < n; i += f) {
			out.push_back(i);
		}
		return out;
	}
}