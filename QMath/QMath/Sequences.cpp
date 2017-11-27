#include "Sequences.h"

namespace QMath {
	long Sequences::getFibonacciNumber(long n) {
		return n == 1 ? 1 : n == 2 ? 2 : getFibonacciNumber(n - 2) + getFibonacciNumber(n - 1);
	}
}