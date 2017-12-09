package uk.co.quarklike.qmath;

import uk.co.quarklike.qmath.pure.geometry.Trig;
import uk.co.quarklike.qmath.pure.numbers.Series;

public class Const {
	public static final double FEMTO = Math.pow(10, -15);
	public static final double PICO = Math.pow(10, -12);
	public static final double NANO = Math.pow(10, -9);
	public static final double MICRO = Math.pow(10, -6);
	public static final double MILI = Math.pow(10, -3);
	public static final double CENTI = Math.pow(10, -2);
	public static final double DECI = Math.pow(10, -1);
	public static final double KILO = Math.pow(10, 3);
	public static final double MEGA = Math.pow(10, 6);
	public static final double GIGA = Math.pow(10, 9);
	public static final double TERA = Math.pow(10, 12);
	public static final double PETA = Math.pow(10, 15);

	// Mathematical
	public static final double PI = getPi();
	public static final double E = Math.E;

	// Physical
	public static final double CONSTANT_NEWTON = 6.674 * Math.pow(10, -11);
	public static final double CONSTANT_COULOMB = 8.99 * Math.pow(10, 9);

	public static final double CONSTANT_ELEMENTARY_CHARGE = 1.602 * Math.pow(10, -19);

	public static final double CONSTANT_MASS_ELECTRON = 9.109 * Math.pow(10, -31);
	public static final double CONSTANT_MASS_PROTON = 1.673 * Math.pow(10, -27);
	public static final double CONSTANT_MASS_PION = 2.489 * Math.pow(10, -28);

	public static final double CONSTANT_LIGHT_SPEED = 3.0 * Math.pow(10, 8);

	private static final double getPi() {
		int res = 1000;
		return Series.shanksTransform_3(Trig.arctan(1, res - 3) * 4, Trig.arctan(1, res - 2) * 4, Trig.arctan(1, res - 1) * 4, Trig.arctan(1, res) * 4, Trig.arctan(1, res + 1) * 4, Trig.arctan(1, res + 2) * 4, Trig.arctan(1, res + 3) * 4);
	}
}
