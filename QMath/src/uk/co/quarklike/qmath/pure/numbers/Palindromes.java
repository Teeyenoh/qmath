package uk.co.quarklike.qmath.pure.numbers;

public class Palindromes {
	public static long getReverse(long n) {
		char[] chars = String.valueOf(n).toCharArray();
		char[] reverse = new char[chars.length];

		for (int i = 0; i < chars.length; i++) {
			reverse[chars.length - i - 1] = chars[i];
		}

		return Integer.valueOf(String.copyValueOf(reverse));
	}

	public static boolean isPalindrome(long n) {
		return getReverse(n) == n;
	}
}
