#pragma once

#include "QMath.h"

#include "Powers.h"
#include "Factors.h"

namespace QMath {
	class Primes {
	public:
		static bool isPrime(QLong n);
		static QLong getPrime(QLong n);
		static std::list<QLong> getPrimeFactors(QLong n);
	};
}