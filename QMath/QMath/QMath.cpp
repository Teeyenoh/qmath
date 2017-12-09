#include "QMath.h"

#include "Powers.h"

namespace QMath {
	QLong QLong::operator=(const double& q) const {
		QLong result;
		result.num = q;
		result.exp = 0;
		result.normalise();
		return result;
	}

	QLong QLong::operator+(const QLong& q) const {
		QLong tempA, tempB, result;
		tempA.num = this->num;
		tempA.exp = this->exp;
		tempB.num = q.num;
		tempB.exp = q.exp;
		int avExp = (int) ((this->exp + q.exp) / 2);
		tempA.toPower(avExp);
		tempB.toPower(avExp);

		result.num = tempA.num + tempB.num;
		result.exp = avExp;

		result.normalise();
		return result;
	}

	QLong QLong::operator+=(const QLong& q) const {
		return *this + q;
	}

	QLong QLong::operator-(const QLong& q) const {
		QLong tempA, tempB, result;
		tempA.num = this->num;
		tempA.exp = this->exp;
		tempB.num = q.num;
		tempB.exp = q.exp;
		int avExp = (int) ((this->exp + q.exp) / 2);
		tempA.toPower(avExp);
		tempB.toPower(avExp);

		result.num = tempA.num - tempB.num;
		result.exp = avExp;

		result.normalise();
		return result;
	}

	QLong QLong::operator-=(const QLong& q) const {
		return *this - q;
	}

	QLong QLong::operator*(const QLong& q) const {
		QLong result;
		result.num = this->num * +q.num;
		result.exp = this->exp + q.exp;
		result.normalise();
		return result;
	}

	QLong QLong::operator*=(const QLong& q) const {
		return *this * q;
	}

	QLong QLong::operator/(const QLong& q) const {
		QLong result;
		result.num = this->num / +q.num;
		result.exp = this->exp - q.exp;
		result.normalise();
		return result;
	}

	QLong QLong::operator/=(const QLong& q) const {
		return *this / q;
	}

	QLong QLong::operator%(const QLong& q) const {
		QLong top;
		top.num = this->num;
		top.exp = this->exp;
		QLong div;
		while (top >= q) {
			div++;
			top -= q;
		}

		return QLong(top);
	}

	QLong& QLong::operator++() {
		num++;
		normalise();
		return *this;
	}

	QLong QLong::operator++(int) {
		QLong temp = *this;
		++*this;
		return temp;
	}

	QLong& QLong::operator--() {
		num--;
		normalise();
		return *this;
	}

	QLong QLong::operator--(int) {
		QLong temp = *this;
		--*this;
		return temp;
	}

	bool QLong::operator==(const QLong& q) const {
		return this->num == q.num && this->exp == q.exp;
	}

	bool QLong::operator!=(const QLong& q) const {
		return this->num != q.num || this->exp != q.exp;
	}

	bool QLong::operator>(const QLong& q) const {
		return this->exp > q.exp || (this->num > q.num && this->exp >= q.exp);
	}

	bool QLong::operator>=(const QLong& q) const {
		return this->exp > q.exp || (this->num >= q.num && this->exp >= q.exp);
	}

	bool QLong::operator<(const QLong& q) const {
		return this->exp > q.exp || (this->num < q.num && this->exp <= q.exp);
	}

	bool QLong::operator<=(const QLong& q) const {
		return this->exp < q.exp || (this->num <= q.num && this->exp <= q.exp);
	}

	void QLong::normalise() {
		bool neg = num < 0;
		if (neg)
			num *= -1;

		while (num >= 10) {
			num /= 10;
			exp += 1;
		}

		while (num < 1) {
			num *= 10;
			exp -= 1;
		}

		if (neg)
			num += -1;
	}

	void QLong::toPower(int p) {
		bool neg = num < 0;
		if (neg)
			num *= -1;

		while (num >= 10 && exp < p) {
			num /= 10;
			exp += 1;
		}

		while (num < 1 && exp > p) {
			num *= 10;
			exp -= 1;
		}

		if (neg)
			num += -1;
	}

	QLong::operator std::string() const {
		std::string out;
		out.append(std::to_string(num));
		out.append("x10^");
		out.append(std::to_string(exp));
		return out;
	}
}