#include "Powers.h"

namespace QMath {
	// Babylonian algorithm
	float Powers::getSqrt(float n) {
		float guess, div;

		guess = n / 2;

		for (int i = 0; i < 10; i++) {
			guess = (guess + (n / guess)) / 2;
		}

		return guess;
	}
}