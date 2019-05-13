package ss.week3.math;

public class Exponent implements Function,Integrable {
	private double exponent;
	private Function function;
	
	
	public Exponent(double exponent) {

		this.exponent = exponent;
	}
	
	public double apply(double arg) {
		return Math.pow(arg, exponent);
	}
	
	public Function derivative () {
			return new LinearProduct(new Exponent(exponent-1),new Constant(exponent));
			
		}
		

	
	public String toString() {
		return "x^ " + exponent;
	}
	
	public Function integral() {
		Constant constant1 = new Constant (1/(exponent+1));
		Exponent exponent1 = new Exponent(exponent+1);
		return new LinearProduct(exponent1, constant1);
		
		
	}

}
