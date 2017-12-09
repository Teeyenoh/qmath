#include "Sums.h"

#include <iostream>

namespace QMath {
	QLong Sums::getSum(std::list<QLong> list) {
		QLong out = 0;
		for (QLong i : list) {
			out += i;
		}
		return out;
	}
}