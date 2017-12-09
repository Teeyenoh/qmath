package uk.co.quarklike.qmath.pure.numbers.algebra;

import uk.co.quarklike.qmath.discrete.ArrayTools;
import uk.co.quarklike.qmath.pure.geometry.Square;

public class FunctionPolynomial extends Function {
	double[] coeffs;

	public FunctionPolynomial(double... coeffs) {
		this.coeffs = coeffs;
	}

	private double getCoeff(int index) {
		return coeffs[index];
	}

	@Override
	public double get(double in) {
		double out = 0;

		for (int i = 0; i < coeffs.length; i++) {
			int coeff = coeffs.length - i - 1;
			out += (Math.pow(in, coeff) * coeffs[i]);
		}

		return out;
	}

	@Override
	public double[] solve() {
		switch (coeffs.length) {
		case 1:
			return null;
		case 2:
			return new double[] { -getCoeff(1) / getCoeff(0) };
		case 3:
			double a = getCoeff(0);
			double b = getCoeff(1);
			double c = getCoeff(2);
			return ArrayTools.removeDuplicates(new double[] { (-b + Math.sqrt(Square.square(b) - 4 * a * c)) / (2 * a), (-b - Math.sqrt(Square.square(b) - 4 * a * c)) / (2 * a) });
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
				out += coeffs[i] + "*x^" + i + " + ";
			}
		}

		out += coeffs[0];
		return out;
	}
}
