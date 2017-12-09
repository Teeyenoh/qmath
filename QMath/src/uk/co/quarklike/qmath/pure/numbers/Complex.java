package uk.co.quarklike.qmath.pure.numbers;

public class Complex {
	private double _real, _imaginary;

	public Complex(double r, double i) {
		this._real = r;
		this._imaginary = i;
	}

	public double getRealComp() {
		return _real;
	}

	public double getImagComp() {
		return _imaginary;
	}

	public boolean isReal() {
		return _imaginary == 0;
	}

	public double toDouble() {
		return getRealComp();
	}

	public double getMagnitude() {
		return Powers.sqrt(Powers.square(_real) + Powers.square(_imaginary));
	}

	public Complex getConjugate() {
		return new Complex(_real, -_imaginary);
	}

	public Complex getReciprocal() {
		double den = Powers.square(_real) + Powers.square(_imaginary);
		return new Complex(_real / den, -_imaginary / den);
	}

	public Complex add(Complex toAdd) {
		return new Complex(_real + toAdd.getRealComp(), _imaginary + toAdd.getImagComp());
	}

	public Complex sub(Complex toSub) {
		return new Complex(_real - toSub.getRealComp(), _imaginary - toSub.getImagComp());
	}

	public Complex multiply(Complex toMultiply) {
		double a = _real;
		double b = _imaginary;
		double c = toMultiply.getRealComp();
		double d = toMultiply.getImagComp();
		double real = (a * c) - (b * d);
		double imag = (b * c) + (a * d);
		return new Complex(real, imag);
	}

	public Complex divide(Complex toDivide) {
		double a = _real;
		double b = _imaginary;
		double c = toDivide.getRealComp();
		double d = toDivide.getImagComp();
		double real = ((a * c) + (b * d)) / (Powers.square(c) + Powers.square(d));
		double imag = ((b * c) - (a * d)) / (Powers.square(c) + Powers.square(d));
		return new Complex(real, imag);
	}

	@Override
	public String toString() {
		return _real + (_imaginary < 0 ? " - " : " + ") + Math.abs(_imaginary) + "i";
	}
}
