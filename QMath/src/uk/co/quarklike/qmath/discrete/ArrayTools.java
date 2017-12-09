package uk.co.quarklike.qmath.discrete;

public class ArrayTools {
	public static long[] numberList(int start, int end) {
		long[] out = new long[end - start + 1];

		for (int i = start; i <= end; i++) {
			out[i - start] = i;
		}

		return out;
	}

	public static long[] removeDuplicates(long[] a, long[] b) {
		long[] out = new long[a.length + b.length];

		for (int i = 0; i < a.length; i++) {
			out[i] = a[i];
		}

		for (int i = a.length; i < out.length; i++) {
			if (!containsLong(a, b[i - a.length])) {
				out[i] = b[i - a.length];
			}
		}

		return out;
	}

	public static double[] removeDuplicates(double[] a) {
		double[] out = new double[a.length];
		int successes = 0;

		for (int i = 0; i < a.length; i++) {
			if (!containsDouble(out, a[i])) {
				out[i] = a[i];
				successes++;
			}
		}

		Sort.shuttleSort(out);
		out = trim(out, successes);

		return out;
	}

	private static boolean containsLong(long[] array, long n) {
		for (long i : array) {
			if (i == n) {
				return true;
			}
		}

		return false;
	}

	private static boolean containsDouble(double[] array, double n) {
		for (double i : array) {
			if (i == n) {
				return true;
			}
		}

		return false;
	}

	public static void printArray(long[] list) {
		for (long i : list) {
			System.out.print(i + " ");
		}

		System.out.println();
	}

	public static long[] trim(long[] array, int length) {
		long[] out = new long[length];

		for (int i = 0; i < length; i++) {
			out[i] = array[i];
		}

		return out;
	}

	public static double[] trim(double[] array, int length) {
		double[] out = new double[length];

		for (int i = 0; i < length; i++) {
			out[i] = array[i];
		}

		return out;
	}

	public static long[] remove(long[] array, long n) {
		int endLength = array.length;
		for (long l : array) {
			if (l == n)
				endLength--;
		}

		long[] out = new long[endLength];
		int i = 0;
		for (long l : array) {
			if (l != n) {
				out[i] = l;
				i++;
			}
		}
		
		return out;
	}
}
