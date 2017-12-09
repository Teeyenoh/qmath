package uk.co.quarklike.qmath.applied.motion;

import uk.co.quarklike.qmath.pure.numbers.Sum;
import uk.co.quarklike.qmath.pure.vectors.Vector;

public class Gravity {
	public static double getPotentialEnergyAtPoint(Vector point, double[] masses, Vector[] points) {
		double[] toSum = new double[masses.length];
		for (int i = 0; i < toSum.length; i++) {
			double dem = points[i].sub(point).getLength();
			toSum[i] = masses[i] / dem;
		}
		return Sum.sumNumbers(toSum);
	}
}
