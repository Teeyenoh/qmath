package uk.co.quarklike.qmath.pure.numbers.algebra;

import uk.co.quarklike.qmath.discrete.ArrayTools;
import uk.co.quarklike.qmath.pure.numbers.Complex;
import uk.co.quarklike.qmath.pure.numbers.Powers;

public class FunctionPolynomial extends Function {
	double[] coeffs;

	public FunctionPolynomial(double... coeffs) {
		this.coeffs = coeffs;
	}

	private double getCoeff(int index) {
		return coeffs[index];
	}

	@Override
	public Complex get(Complex in) {
		Complex out = new Complex(0, 0);

		for (int i = 0; i < coeffs.length; i++) {
			int coeff = coeffs.length - i - 1;
			out = out.add(Powers.raiseToPower(in, coeff).multiply(new Complex(coeffs[i], 0)));
		}

		return out;
	}

	@Override
	public Complex[] solve() {
		switch (coeffs.length) {
		case 1:
			return null;
		case 2:
			return new Complex[] { new Complex(-getCoeff(1) / getCoeff(0), 0) };
		case 3:
			double a = getCoeff(0);
			double b = getCoeff(1);
			double c = getCoeff(2);
			double det = Powers.square(b) - (4 * a * c);
			if (det > 0) {
				return new Complex[] { new Complex((-b + Math.sqrt(det)) / (2 * a), 0), new Complex((-b - Math.sqrt(det)) / (2 * a), 0) };
			} else if (det == 0) {
				return new Complex[] { new Complex((-b + Math.sqrt(det)) / (2 * a), 0) };
			} else {
				return new Complex[] { new Complex(-b / (2 * a), Powers.sqrt(-det) / (2 * a)), new Complex(-b / (2 * a), -Powers.sqrt(-det) / (2 * a)) };
			}
		default:
			return null;
		}
	}

	@Override
	public FunctionPolynomial differential() {
		double[] coeffs = new double[this.coeffs.length - 1];
		for (int i = 0; i < coeffs.length; i++) {
			coeffs[i] = this.coeffs[i + 1] * (i + 1);
		}
		return new FunctionPolynomial(coeffs);
	}

	@Override
	public String toString() {
		String out = "";
		for (int i = coeffs.length - 1; i > 0; i--) {
			if (coeffs[i] != 0) {
				out += "(" + coeffs[i] + ")*x^" + i + " + ";
			}
		}

		out += coeffs[0];
		return out;
	}
}
