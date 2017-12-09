package uk.co.quarklike.qmath.applied.electrics;

import java.util.HashMap;

public class Resistivity {
	public static final int COPPER = 0;
	public static final int SILVER = 1;
	public static final int GOLD = 2;
	public static final int ALUMINIUM = 3;
	public static final int TUNGSTEN = 4;

	private static HashMap<Integer, Double> rho;
	private static HashMap<Integer, Double> coeff;

	public static void init() {
		rho = new HashMap<Integer, Double>();
		coeff = new HashMap<Integer, Double>();

		addMaterial(COPPER, 1.68 * Math.pow(10, -8), 0.00404);
		addMaterial(SILVER, 1.59 * Math.pow(10, -8), 0.0038);
		addMaterial(GOLD, 2.44 * Math.pow(10, -8), 0.0034);
		addMaterial(ALUMINIUM, 2.65 * Math.pow(10, -8), 0.0039);
		addMaterial(TUNGSTEN, 5.60 * Math.pow(10, -8), 0.0045);
	}

	private static void addMaterial(int material, double resistivity, double coefficient) {
		rho.put(material, resistivity);
		coeff.put(material, coefficient);
	}

	public static double getResistivity(int material, double temp) {
		double d = temp - 293;
		return rho.get(material) * (1 + (d * coeff.get(material)));
	}
}
