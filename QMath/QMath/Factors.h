#pragma once

#include <list>

namespace QMath {
	class Factors {
	public:
		static bool hasFactor(int n, int f);
		static std::list<int> getAllMultiplesBelow(int n, int f);
	};
}