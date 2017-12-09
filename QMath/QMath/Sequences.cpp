#include "Sequences.h"

namespace QMath {
	QLong Sequences::getFibonacciNumber(QLong n) {
		return n == QLong(1) ? 1 : n == QLong(2) ? 2 : getFibonacciNumber(n - QLong(2)) + getFibonacciNumber(n - QLong(1));
	}
}