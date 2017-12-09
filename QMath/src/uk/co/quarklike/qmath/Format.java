package uk.co.quarklike.qmath;

import java.text.NumberFormat;

public class Format {
	public static String standardForm(double value, int sf) {
		if (value == 0)
			return "zero";
		
		int power = 0;
		boolean negative = value < 0;

		value = Math.abs(value);

		if (value < 1) {
			while (value < 1) {
				value *= 10;
				power--;
			}
		} else if (value > 10) {
			while (value > 10) {
				value /= 10;
				power++;
			}
		}

		NumberFormat nf = NumberFormat.getInstance();
		nf.setGroupingUsed(false);
		nf.setMinimumFractionDigits(sf - 1);
		nf.setMaximumFractionDigits(sf - 1);

		value = ((int) (value * Math.pow(10, sf - 1))) / Math.pow(10, sf - 1);

		return (negative ? "-" : "") + nf.format(value) + "*10^" + power;
	}
}
