package uk.co.quarklike.qmath.pure.numbers.algebra;

import uk.co.quarklike.qmath.pure.numbers.Complex;

public abstract class Function {
	public abstract Complex get(Complex in);

	public abstract Function differential();

	public abstract Complex[] solve();
}
