package uk.co.quarklike.qmath.applied.motion;

import uk.co.quarklike.qmath.Const;
import uk.co.quarklike.qmath.pure.geometry.Trig;
import uk.co.quarklike.qmath.pure.numbers.Powers;

public class Orbit {
	/**
	 * 
	 * @param a
	 *            semi-major axis in meters
	 * @param M
	 *            mass of central body in kg
	 * @return
	 */
	public static double getTimePeriod(double a, double M) {
		// from "T = 2π root(a^3 / μ)"
		double mu = Const.CONSTANT_GRAVITY * M;
		return 2 * Const.PI * Powers.sqrt(Math.pow(a, 3) / mu);
	}

	/**
	 * 
	 * @param P
	 *            time of orbit (T) in seconds
	 * @param t
	 *            current time (t) in seconds
	 * @return returns mean anomaly (M) in radians
	 */
	private static double getMeanAnomaly(double a, double m, double t) {
		// from "nP = 2π"
		return (Const.PI * 2 * t) / getTimePeriod(a, m);
	}

	/**
	 * 
	 * @param ε
	 *            eccentricity (ε) of the orbit
	 * @param P
	 *            time of orbit (T) in seconds
	 * @param t
	 *            current time (t) in seconds
	 * @return returns eccentric anomaly (E) in radians
	 */
	private static double getEccentricAnomaly(double ε, double a, double m, double t) {
		double res = 10; // resolution (number of iterations) for solving
							// Kepler's equation

		double M = getMeanAnomaly(a, m, t);
		double E = M; // starting value
		for (int i = 0; i < res; i++) {
			// from "M = E - (ε * sin(E))"
			E = M + ((ε) * (Trig.sin(E)));
		}

		return E;
	}

	private static double getTrueAnomaly(double ε, double a, double m, double t) {
		return 2 * Trig.arctan(Powers.sqrt(((1 + ε) / (1 - ε)) * Powers.square(Trig.tan(getEccentricAnomaly(ε, a, m, t) / 2))));
	}

	public static double getRadius(double ε, double a, double m, double t) {
		return a * (1 - (ε * Trig.cos(getEccentricAnomaly(ε, a, m, t))));
	}
}
