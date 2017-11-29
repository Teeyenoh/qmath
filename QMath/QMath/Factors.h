#pragma once

#include "QMath.h"

#include "Primes.h"

namespace QMath {
	class Factors {
	public:
		static bool hasFactor(QLong n, QLong f);
		static QLong getLCM(QLong n, QLong n2);
		static QLong getLCM(QLong ns[], int length);
		static std::list<QLong> getAllMultiplesBelow(QLong n, QLong f);
	};
}