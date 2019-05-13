package ss.week3.math;

public class LinearProduct extends Product implements Integrable {
	

	
	public LinearProduct(Function f1, Constant f2) {
		super(f1,f2);
		
	}
	
	public Function derivative() {
		return new LinearProduct(function1.derivative(),(Constant) function2 );
	}
	
	public Function integral() {
		if(function1 instanceof Integrable && function2 instanceof Constant) {
			return new LinearProduct(((Integrable) function1).integral(), (Constant) function2);
			
		}
		return null;
	}

}
