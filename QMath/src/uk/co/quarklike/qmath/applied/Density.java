package uk.co.quarklike.qmath.applied;

public class Density {
	// ρ = m / v

	public static final double getDensity(double mass, double volume) {
		return mass / volume;
	}

	public static final double getVolume(double density, double mass) {
		return mass / density;
	}

	public static final double getMass(double density, double volume) {
		return density * volume;
	}
}
