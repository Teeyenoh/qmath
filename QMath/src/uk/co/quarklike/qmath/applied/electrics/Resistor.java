package uk.co.quarklike.qmath.applied.electrics;

public class Resistor {
	// Resistance, Current, PD, Resistivity, Length, Area

	// R = I / V
	public static double getResistance(double current, double pd) {
		return current / pd;
	}

	// I = VR
	public static double getCurrent(double pd, double resistance) {
		return pd * resistance;
	}

	// R = pL / A
	public static double getResistance(double resistivity, double length, double area) {
		return (resistivity * length) / area;
	}
}
