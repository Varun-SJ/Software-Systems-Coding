package ss.week3.math;

public class Polynomial implements Integrable {
	private double[]polynomialA;
	
	public Polynomial(double[]values) {
		this.polynomialA = values;
	}
	
	
	public Integrable reduction() {
		Integrable f = new Constant(0);
		for (int i = polynomialA.length - 1; i>= 0; i--) {
			double a_n = polynomialA[i];
			Integrable fraction = new LinearProduct(new Exponent(i+1), new Constant(a_n));
			f = new Sum(fraction, f);
		}
		return f;
	}
	
	@Override
	public double apply(double arg) {
		return reduction().apply(arg);
	}
	
	@Override
	public Function derivative() {
		return reduction().derivative();
	}
	
	@Override
	public Function integral() {
		return reduction().integral();
	}
	
	@Override
	public String toString() {
		return "The function is: " + reduction();
	}
	
}
