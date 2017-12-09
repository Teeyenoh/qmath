#pragma once

#include <list>
#include <string>

namespace QMath {
	class QLong {
	public:
		double num;
		int exp;

		QLong(double _num = 0, int _exp = 0) { num = _num, exp = _exp; };

		QLong operator=(const double&) const;
		QLong operator+(const QLong&) const;
		QLong operator+=(const QLong&) const;
		QLong operator-(const QLong&) const;
		QLong operator-=(const QLong&) const;
		QLong operator*(const QLong&) const;
		QLong operator*=(const QLong&) const;
		QLong operator/(const QLong&) const;
		QLong operator/=(const QLong&) const;
		QLong operator%(const QLong&) const;

		QLong& operator++();
		QLong operator++(int);
		QLong& operator--();
		QLong operator--(int);

		bool operator==(const QLong&) const;
		bool operator!=(const QLong&) const;
		bool operator>(const QLong&) const;
		bool operator>=(const QLong&) const;
		bool operator<(const QLong&) const;
		bool operator<=(const QLong&) const;

		operator std::string() const;
	private:
		void normalise();
		void toPower(int p);
	};
}