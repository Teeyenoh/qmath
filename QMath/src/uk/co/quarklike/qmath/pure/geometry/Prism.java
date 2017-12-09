package uk.co.quarklike.qmath.pure.geometry;

public class Prism {
	// Height, Area, Volume

	public static double getHeight(double area, double volume) {
		return volume / area;
	}

	public static double getArea(double height, double volume) {
		return volume / height;
	}

	public static double getVolume(double height, double area) {
		return height * area;
	}
}
