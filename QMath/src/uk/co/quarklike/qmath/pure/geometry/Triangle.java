package uk.co.quarklike.qmath.pure.geometry;

import uk.co.quarklike.qmath.discrete.Sort;

public class Triangle {
	public static long[] findPythagoeranTriplet(int a) {
		long as = Square.square(a);

		for (int i = 1; i < 100000; i++) {
			float c = (float) Math.sqrt(as + Square.square(i));
			if (c % 1 == 0) {
				return Sort.shuttleSort(new long[] { a, i, (int) c });
			}
		}

		return null;
	}

	public static long getTriangleNumber(int n) {
		return (long) ((double) (n * (n + 1)) / 2);
	}
}
