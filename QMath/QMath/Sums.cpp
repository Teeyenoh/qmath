#include "Sums.h"

#include <iostream>

namespace QMath {
	long Sums::getSum(std::list<long> list) {
		long out = 0;
		for (long i : list) {
			out += i;
		}
		return out;
	}
}