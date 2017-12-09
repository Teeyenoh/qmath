package uk.co.quarklike.qmath.chemistry;

import java.util.HashMap;

public class Enthalpy {
	public static HashMap<Molecule, Double> eForms = new HashMap<Molecule, Double>();
	
	public static void init() {
		eForms.put(new Molecule("KMnO4"), -813D);
	}

	public static final double formation(Molecule m) {
		if (m.isSimple())
			return 0;

		for (Molecule mol : eForms.keySet()) {
			if (mol.isEqualTo(m))
				return eForms.get(mol);
		}

		return 0;
	}
}
