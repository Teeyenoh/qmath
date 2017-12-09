package uk.co.quarklike.qmath.pure.geometry;

import uk.co.quarklike.qmath.Const;

public class Cylinder {
	// Height, Radius, Volume

	public static double getHeight(double radius, double volume) {
		return Prism.getHeight(Const.PI * Square.square(radius), volume);
	}

	public static double getRadius(double height, double volume) {
		return Math.sqrt(Prism.getArea(height, volume) / Const.PI);
	}

	public static double getVolume(double height, double radius) {
		return Prism.getVolume(height, Const.PI * Square.square(radius));
	}
}
