package uk.co.quarklike.qmath.discrete;

public class Sort {
	public static long[] shuttleSort(long[] list) {
		for (int i = 1; i < list.length; i++) {
			for (int j = i; j > 0; j--) {
				if (list[j] < list[j - 1]) {
					list[j - 1] += list[j];
					list[j] = list[j - 1] - list[j];
					list[j - 1] -= list[j];
				}
			}
		}

		return list;
	}
	public static double[] shuttleSort(double[] list) {
		for (int i = 1; i < list.length; i++) {
			for (int j = i; j > 0; j--) {
				if (list[j] < list[j - 1]) {
					list[j - 1] += list[j];
					list[j] = list[j - 1] - list[j];
					list[j - 1] -= list[j];
				}
			}
		}

		return list;
	}
}
