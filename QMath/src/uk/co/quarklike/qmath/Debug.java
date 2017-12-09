package uk.co.quarklike.qmath;

import java.text.NumberFormat;

import uk.co.quarklike.qmath.applied.electrics.Resistivity;
import uk.co.quarklike.qmath.chemistry.Enthalpy;
import uk.co.quarklike.qmath.pure.numbers.algebra.Function;
import uk.co.quarklike.qmath.pure.numbers.algebra.FunctionPolynomial;

public class Debug {
	private static boolean TIME = false;

	public static NumberFormat nf;

	private static void init() {
		nf = NumberFormat.getInstance();
		nf.setGroupingUsed(false);
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);

		if (TIME) {
			Timer timer = new Timer();
			timer.start();
		}

		Enthalpy.init();
		Resistivity.init();
	}

	public static final void main(String[] args) {
		init();

		Function f = new FunctionPolynomial(1, 3, -5);
		System.out.println(f.solve()[1]);

		// System.exit(0);
	}
}
