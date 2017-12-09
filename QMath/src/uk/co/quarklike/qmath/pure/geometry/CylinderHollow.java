package uk.co.quarklike.qmath.pure.geometry;

public class CylinderHollow {
	// Height, Radius_Inner, Radius_Outer, Volume

	// v = l * ((Pi * outer^2) - (Pi * inner^2))

	public static double getVolume(double height, double radius_inner, double radius_outer) {
		return Cylinder.getVolume(height, radius_outer) - Cylinder.getVolume(height, radius_inner);
	}
}
