#pragma once

#include "QMath.h"

namespace QMath {
	// Andrew, put the binomial expansion in here and generalise these cases
	// So, leave the functions in, but have them reroute
	// getPowerProduct(n, p) == getBinomialExpansion(n, p)

	class Powers {
	public:
		static QLong getPowerProduct(QLong n, QLong power = QLong(2));
		static QLong getSqrt(QLong n);
	};
}