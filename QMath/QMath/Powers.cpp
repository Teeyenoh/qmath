#include "Powers.h"

namespace QMath {
	QLong Powers::getPowerProduct(QLong n, QLong p) {
		if (p == QLong(0))
			return QLong(1);

		QLong out = n;
		for (QLong i = 0; i < p - QLong(1); i++) {
			out *= n;
		}
		return out;
	}

	// Babylonian algorithm
	QLong Powers::getSqrt(QLong n) {
		QLong guess;

		guess = n / QLong(2); // Start by guessing half of n

		for (QLong i = 0; i < QLong(10); i++) {
			guess = (guess + (n / guess)) / QLong(2); // For each iteration, guess between n and the last guess
		}

		return guess;
	}
}