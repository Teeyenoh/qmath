#include "stdafx.h"

#include "QMath.h"
#include "Primes.h"
#include "Sums.h"
#include "Factors.h"
#include "Sequences.h"

#include <list>
#include <iostream>

using namespace QMath;

int main() {
	std::list<QLong> output = Primes::getPrimeFactors(600851475143);

	std::cout << output.back() << std::endl;
	return 0;
}