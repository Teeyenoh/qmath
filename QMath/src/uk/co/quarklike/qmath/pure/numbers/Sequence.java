package uk.co.quarklike.qmath.pure.numbers;

public class Sequence {
	public static long getNextCollatz(long n) {
		if (n % 2 == 0) {
			return n / 2;
		} else {
			return (3 * n) + 1;
		}
	}
}
