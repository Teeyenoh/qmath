package uk.co.quarklike.qmath.pure.matrices;

import uk.co.quarklike.qmath.Debug;
import uk.co.quarklike.qmath.pure.vectors.Vector;

public class Matrix {
	private int width, height;
	private double[][] values;

	public Matrix(Vector... values) {
		this.width = values.length;
		this.height = values[0].getSize();

		for (int i = 0; i < values.length; i++) {
			setColumn(i, values[i].getValues());
		}
	}

	public Matrix(int height, int width) {
		this.width = width;
		this.height = height;
		this.values = new double[height][width];
	}

	public double getValue(int y, int x) {
		if (x < 0 || x >= width || y < 0 || y >= height) {
			System.out.println("Error: can't get value " + y + "," + x + " in matrix of size " + getSize());
			return 0;
		}
		return values[y][x];
	}

	public void setValue(int y, int x, double value) {
		if (x < 0 || x >= width || y < 0 || y >= height)
			return;
		values[y][x] = value;
	}

	public double[][] getValues() {
		return values;
	}

	public void setValues(double[][] values) {
		this.values = values;
	}

	public double[] getRow(int row) {
		double[] out = new double[width];

		for (int i = 0; i < width; i++) {
			out[i] = getValue(row, i);
		}

		return out;
	}

	public void setRow(int row, double[] values) {
		for (int i = 0; i < width; i++) {
			setValue(row, i, values[i]);
		}
	}

	public double[] getColumn(int column) {
		double[] out = new double[height];

		for (int i = 0; i < height; i++) {
			out[i] = getValue(i, column);
		}

		return out;
	}

	public void setColumn(int column, double[] values) {
		for (int i = 0; i < height; i++) {
			setValue(i, column, values[i]);
		}
	}

	public Matrix transpose() {
		Matrix out = new Matrix(getWidth(), getHeight());

		for (int i = 0; i < out.getHeight(); i++) {
			for (int j = 0; j < out.getWidth(); j++) {
				out.setValue(i, j, getValue(j, i));
			}
		}

		return out;
	}

	public Matrix add(Matrix b) {
		Matrix a = this;

		if (a.getWidth() != b.getWidth() || a.getHeight() != b.getHeight()) {
			return null;
		}

		int width = a.getWidth();
		int height = a.getHeight();

		Matrix out = new Matrix(height, width);

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				out.setValue(i, j, a.getValue(i, j) + b.getValue(i, j));
			}
		}

		return out;
	}

	public Matrix sub(Matrix b) {
		Matrix a = this;

		if (a.getWidth() != b.getWidth() || a.getHeight() != b.getHeight()) {
			return null;
		}

		int width = a.getWidth();
		int height = a.getHeight();

		Matrix out = new Matrix(height, width);

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				out.setValue(i, j, a.getValue(i, j) - b.getValue(i, j));
			}
		}

		return out;
	}

	public Matrix scale(double scalar) {
		Matrix out = new Matrix(getWidth(), getHeight());

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				out.setValue(i, j, getValue(i, j) * scalar);
			}
		}

		return out;
	}

	public Matrix multiply(Matrix b) {
		Matrix a = this;

		if (a.getWidth() != b.getHeight()) {
			return null;
		}

		int width = a.getHeight();
		int height = b.getWidth();
		int length = a.getWidth();

		Matrix out = new Matrix(height, width);

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				double value = 0;

				for (int k = 0; k < length; k++) {
					value += a.getRow(i)[k] * b.getColumn(j)[k];
				}

				out.setValue(i, j, value);
			}
		}

		return out;
	}

	public double getDiscriminant() {
		if (getWidth() != getHeight()) {
			System.out.println("Can't find discriminant of non-zero matrix");
		}

		if (getWidth() != 2 && getHeight() != 2) {
			System.out.println("Unable to find discriminant of " + getSize() + " matrix");
			return 0;
		}

		return (getValue(0, 0) * getValue(1, 1)) - (getValue(0, 1) * getValue(1, 0));
	}

	public Matrix getInverse() {
		if (getDiscriminant() == 0) {
			System.out.println("Unable to find inverse");
		}

		Matrix out = new Matrix(getWidth(), getHeight());

		out.setValue(0, 0, getValue(1, 1));
		out.setValue(0, 1, -getValue(0, 1));
		out.setValue(1, 0, -getValue(1, 0));
		out.setValue(1, 1, getValue(0, 0));

		return out.scale(1 / getDiscriminant());
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public String toString() {
		String out = "";
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				out += Debug.nf.format(getValue(i, j)) + "\t";
			}
			out += "\n";
		}
		return out;
	}

	public static Matrix getIdentityMatrix(int size) {
		Matrix m = new Matrix(size, size);

		for (int i = 0; i < size; i++) {
			m.setValue(i, i, 1);
		}

		return m;
	}

	public static Matrix getNullMatrix(int size) {
		return new Matrix(size, size);
	}

	public double toScalar() {
		if (getWidth() != getHeight() || getWidth() != 1)
			return 0;
		return getValue(0, 0);
	}

	public String getSize() {
		return getHeight() + "x" + getWidth();
	}
}
