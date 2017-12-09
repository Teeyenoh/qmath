#pragma once

#include "QMath.h"

#include <string>

namespace QMath {
	class Palindromes {
	public:
		static QLong getReverse(QLong n);
		static bool isPalindrome(QLong n);
	};
}