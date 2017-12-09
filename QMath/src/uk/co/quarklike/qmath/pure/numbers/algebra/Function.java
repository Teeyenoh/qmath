package uk.co.quarklike.qmath.pure.numbers.algebra;

public abstract class Function {
	public abstract double get(double in);

	public abstract Function differential();

	public abstract double[] solve();
}
