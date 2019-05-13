package ss.week3.math;

public class Identity implements Function, Integrable {
	
	public double constantValue;
	public Function integral;
	
	public Identity() {
		
	}
	
	public double apply(double arg) {
		return arg;
	}
	
	public Function derivative() {
		return new Constant(1.0);
	}
	@Override
	public String toString() {
		return "" + derivative().apply(1.0);
	}
	
	public Function integral() {
		if (this.integral == null) {
			this.integral = new LinearProduct(new Exponent(2), new Constant(0.5));
		}
		return integral;
		
		
		
	}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

	}

}
