#pragma once

#include "QMath.h"

#include "Powers.h"
#include "Factors.h"

namespace QMath {
	class Primes {
	public:
		static bool isPrime(QLong n);
		static QLong getPrime(int n);
		static std::list<QLong> getPrimeFactors(QLong n);
	};
}