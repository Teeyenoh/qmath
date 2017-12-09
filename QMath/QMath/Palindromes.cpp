#include "Palindromes.h"

#include <iostream>

namespace QMath {
	// Returns the reverse order of n
	QLong Palindromes::getReverse(QLong n) {
		std::string asText = n;
		std::reverse(asText.begin(), asText.end());
		QLong back = std::stoi(asText);
		return back;
	}

	// Returns true if n is a palindrome (n == getReverse(n))
	bool Palindromes::isPalindrome(QLong n) {
		return n == getReverse(n);
	}
}