#pragma once

#include "QMath.h"

namespace QMath {
	class Factors {
	public:
		static bool hasFactor(QLong n, QLong f);
		static std::list<QLong> getAllMultiplesBelow(QLong n, QLong f);
	};
}