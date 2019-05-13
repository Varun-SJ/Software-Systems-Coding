package ss.week3.math;


public class Constant implements Function,Integrable {
	private double constantValue;
	
	public Constant(double constant) {
		this.constantValue = constant;

	}
	
	public double apply(double argument) {
		return constantValue;
	}
	
	public Function derivative() {
		return new Constant(0.0);
		
	}
	@Override
	public String toString() {
		return ""+ constantValue;
	}
	
	public Function integral() {
		return new LinearProduct(new Identity(),new Constant (constantValue));
		
	}

	public static void main(String[] args) {
		
		Print.print(new Constant(2.0));
		// TODO Auto-generated method stub

	}

}
