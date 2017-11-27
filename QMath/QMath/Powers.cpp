#include "Powers.h"

namespace QMath {
	// Babylonian algorithm
	double Powers::getSqrt(double n) {
		double guess;

		guess = n / 2; // Start by guessing half of n

		for (int i = 0; i < 10; i++) {
			guess = (guess + (n / guess)) / 2; // For each iteration, guess between n and the last guess
		}

		return guess;
	}
}