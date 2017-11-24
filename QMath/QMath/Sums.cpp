#include "Sums.h"

#include <iostream>

namespace QMath {
	int Sums::getSum(std::list<int> list) {
		int out = 0;
		for (int i : list) {
			out += i;
		}
		return out;
	}
}