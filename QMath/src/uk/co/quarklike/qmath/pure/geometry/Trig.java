package uk.co.quarklike.qmath.pure.geometry;

import uk.co.quarklike.qmath.Const;
import uk.co.quarklike.qmath.pure.numbers.Factorial;
import uk.co.quarklike.qmath.pure.numbers.Series;
import uk.co.quarklike.qmath.pure.numbers.Sum;

public class Trig {
	public static double sin(double x) {
		return sin(x, 10);
	}

	public static double sin(double x, int res) {
		x = x % Const.PI * 2;

		double[] nums = new double[res + 1];

		for (int n = 0; n <= res; n++) {
			double top = Math.pow(-1, n);
			long bottom = Factorial.factorial((2 * n) + 1);
			long power = (2 * n) + 1;
			nums[n] = (top / bottom) * (Math.pow(x, power));
		}

		return Sum.sumNumbers(nums);
	}

	public static double cos(double x) {
		return cos(x, 10);
	}

	public static double cos(double x, int res) {
		x = x % Const.PI * 2;
		
		double[] nums = new double[res + 1];

		for (int n = 0; n <= res; n++) {
			double top = Math.pow(-1, n);
			long bottom = Factorial.factorial(2 * n);
			long power = (2 * n);
			nums[n] = (top / bottom) * (Math.pow(x, power));
		}

		return Sum.sumNumbers(nums);
	}

	public static double tan(double x) {
		return tan(x, 10);
	}

	public static double tan(double x, int res) {
		x = x % Const.PI * 2;
		
		double[] nums = new double[res + 1];

		for (int n = 1; n <= res; n++) {
			double top = Series.bernoulliNumber(2 * n) * Math.pow(-4, n) * (1 - Math.pow(4, n));
			long bottom = Factorial.factorial(2 * n);
			long power = (2 * n) - 1;
			nums[n] = (top / bottom) * (Math.pow(x, power));
		}

		return Sum.sumNumbers(nums);
	}

	public static double sec(double x) {
		return sec(x, 10);
	}

	public static double sec(double x, int res) {
		double[] nums = new double[res + 1];

		for (int n = 1; n <= res; n++) {
			double top = Series.bernoulliNumber(2 * n) * Math.pow(-4, n) * (1 - Math.pow(4, n));
			long bottom = Factorial.factorial(2 * n);
			long power = (2 * n) - 1;
			nums[n] = (top / bottom) * (Math.pow(x, power));
		}

		return Sum.sumNumbers(nums);
	}

	public static double arcsin(double x) {
		return arcsin(x, 10);
	}

	public static double arcsin(double x, int res) {
		double[] nums = new double[res + 1];

		for (int n = 0; n <= res; n++) {
			double top = Factorial.factorial(2 * n);
			double bottom = Math.pow(4, n) * Square.square(Factorial.factorial(n)) * ((2 * n) + 1);
			long power = (2 * n) + 1;
			nums[n] = (top / bottom) * (Math.pow(x, power));
		}

		return Sum.sumNumbers(nums);
	}

	public static double arccos(double x) {
		return arccos(x, 10);
	}

	public static double arccos(double x, int res) {
		return (Const.PI / 2) - arcsin(x, res);
	}

	public static double arctan(double x) {
		return arctan(x, 10);
	}

	public static double arctan(double x, int res) {
		double[] nums = new double[res + 1];

		for (int n = 0; n <= res; n++) {
			double top = Math.pow(-1, n);
			long bottom = (2 * n) + 1;
			long power = (2 * n) + 1;
			nums[n] = (top / bottom) * (Math.pow(x, power));
		}

		return Sum.sumNumbers(nums);
	}
}
