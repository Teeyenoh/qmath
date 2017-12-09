package uk.co.quarklike.qmath.pure.vectors;

import uk.co.quarklike.qmath.pure.matrices.Matrix;

public class Vector {
	private int size;
	private double[] values;

	public Vector(double... values) {
		this.values = values;
		this.size = values.length;
	}

	public double getValue(int index) {
		if (index < 0 || index >= size) {
			System.out.println("Error: can't get value " + index + " in vector of size " + getSize());
			return 0;
		}

		return this.values[index];
	}

	public void setValue(int index, double value) {
		if (index < 0 || index >= size)
			return;

		this.values[index] = value;
	}

	public double[] getValues() {
		return values;
	}

	public void set(Vector v) {
		for (int i = 0; i < v.getSize(); i++) {
			values[i] = v.getValue(i);
		}
	}

	public void setValues(double... values) {
		this.values = values;
		this.size = values.length;
	}

	public double getTheta() {
		return getTheta(new Vector(1, 0));
	}

	public double getTheta(Vector b) {
		double costheta = dot(b) / (this.getLength() * b.getLength());
		return Math.acos(costheta);
	}

	public Vector getUnitVector() {
		return this.scale(1d / getLength());
	}

	public Vector add(Vector b) {
		Vector out = copyVector();

		if (getSize() != b.getSize())
			return null;

		for (int i = 0; i < getSize(); i++) {
			out.setValue(i, out.getValue(i) + b.getValue(i));
		}

		return out;
	}

	public Vector sub(Vector b) {
		Vector out = copyVector();

		if (getSize() != b.getSize())
			return null;

		for (int i = 0; i < getSize(); i++) {
			out.setValue(i, out.getValue(i) - b.getValue(i));
		}

		return out;
	}

	public Vector scale(double scalar) {
		Vector out = copyVector();

		for (int i = 0; i < getSize(); i++) {
			out.setValue(i, getValue(i) * scalar);
		}

		return out;
	}

	public double dot(Vector b) {
		return (new Matrix(this)).transpose().multiply((new Matrix(b))).toScalar();
	}

	public Vector negate() {
		Vector out = copyVector();

		for (int i = 0; i < getSize(); i++) {
			out.setValue(i, out.getValue(i) * -1);
		}

		return out;
	}

	// public Vector getNormal() {
	//
	// }

	public double getLength() {
		return Math.sqrt(getLengthSquared());
	}

	public double getLengthSquared() {
		double out = 0;
		for (int i = 0; i < getSize(); i++) {
			out += Math.pow(getValue(i), 2);
		}
		return out;
	}

	public double getDistance(Vector b) {
		return b.sub(this).getLength();
	}

	public int getSize() {
		return size;
	}

	public Vector copyVector() {
		Vector out = new Vector();
		double[] values = new double[getSize()];

		for (int i = 0; i < getSize(); i++) {
			values[i] = getValue(i);
		}

		out.setValues(values);
		return out;
	}

	public void setX(double x) {
		setValue(0, x);
	}

	public double getX() {
		return getValue(0);
	}

	public void setY(double y) {
		setValue(1, y);
	}

	public double getY() {
		return getValue(1);
	}

	public void setZ(double z) {
		setValue(2, z);
	}

	public double getZ() {
		return getValue(2);
	}

	public void setW(double w) {
		setValue(3, w);
	}

	public double getW() {
		return getValue(3);
	}

	@Override
	public String toString() {
		String out = "Vector [Size: " + getSize() + "\tValues: " + getX();
		for (int i = 1; i < getSize(); i++) {
			out += ", " + getValue(i);
		}
		out += "]";
		return out;
	}
}
