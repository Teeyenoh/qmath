package uk.co.quarklike.qmath;

import uk.co.quarklike.qmath.pure.geometry.Trig;
import uk.co.quarklike.qmath.pure.numbers.Series;

public class Const {
	public static final double FEMTO = 1E-15;
	public static final double PICO = 1E-12;
	public static final double NANO = 1E-9;
	public static final double MICRO = 1E-6;
	public static final double MILI = 1E-3;
	public static final double CENTI = 1E-2;
	public static final double DECI = 1E-1;
	public static final double KILO = 1E3;
	public static final double MEGA = 1E6;
	public static final double GIGA = 1E9;
	public static final double TERA = 1E12;
	public static final double PETA = 1E15;

	// Mathematical
	public static final double PI = getPi();
	public static final double E = Math.E;

	// Physical constants sourced from "arXiv:1507.07956v1 [physics.atom-ph]"

	// Physical

	/// Universal 

	/**
	 * speed of light in vacuum (c) (m s^-1)
	 */
	public static final double CONSTANT_LIGHT_SPEED = 299792458;

	/**
	 * Newtonian constant of gravitation (G) (m^3 kg^−1 s^−2)
	 */
	public static final double CONSTANT_GRAVITY = 6.67408E-11;

	/**
	 * Planck constant (h) (J s)
	 */
	public static final double CONSTANT_PLANCK_J_S = 6.626070040E-34;

	/**
	 * Planck constant (h) (eV s)
	 */
	public static final double CONSTANT_PLANCK_eV_S = 4.135667662E-15;

	/**
	 * Planck constant (¯h) (J s)
	 */
	public static final double CONSTANT_PLANCK_MODIFIED_J_S = CONSTANT_PLANCK_J_S / (2 * PI);

	/**
	 * Planck constant (¯h) (eV s)
	 */
	public static final double CONSTANT_PLANCK_MODIFIED_eV_S = CONSTANT_PLANCK_eV_S / (2 * PI);

	/// Electromagnetic

	/**
	 * elementary charge (e) (C)
	 */
	public static final double CONSTANT_ELEMENTARY_CHARGE = 1.6021766208E-19;

	/// Electron

	/**
	 * electron mass (m_e) (kg)
	 */
	public static final double CONSTANT_ELECTRON_MASS = 9.10938356E-31;

	/// Proton

	/**
	 * proton mass (m_p) (kg)
	 */
	public static final double CONSTANT_PROTON_MASS = 1.672621898E-27;

	/**
	 * proton radius (r_p) (m)
	 */
	public static final double CONSTANT_PROTON_RADIUS = 8.751E-16;

	// Unsourced
	public static final double CONSTANT_COULOMB = 8.99E9;

	private static final double getPi() {
		int res = 1000;
		return Series.shanksTransform_3(Trig.arctan(1, res - 3) * 4, Trig.arctan(1, res - 2) * 4, Trig.arctan(1, res - 1) * 4, Trig.arctan(1, res) * 4, Trig.arctan(1, res + 1) * 4, Trig.arctan(1, res + 2) * 4, Trig.arctan(1, res + 3) * 4);
	}
}
