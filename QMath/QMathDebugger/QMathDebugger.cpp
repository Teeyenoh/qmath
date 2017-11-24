#include "stdafx.h"

#include "Primes.h"
#include "Sums.h"
#include "Factors.h"
#include "Sequences.h"

#include <list>
#include <iostream>

using namespace QMath;

int main() {
	int output = 0;

	int i = 1;
	int f = 0;
	while ((f = Sequences::getFibonacciNumber(i)) <= 4000000) {
		output += f % 2 == 0 ? f : 0;
		i++;
	}

	std::cout << output << std::endl;
	return 0;
}