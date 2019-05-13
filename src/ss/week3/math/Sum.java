package ss.week3.math;

public class Sum implements Function,Integrable {
	
	Function function1;
	Function function2;
	
	public Sum(Function function1, Function function2) {
		this.function1 = function1;
		this.function2 = function2;
	}
	
	public double apply(double arg) {
		double arg1 = function1.apply(arg);
		double arg2 = function2.apply(arg);
		double arg3 = arg1+arg2;
		return arg3;
	}
	
	public Function derivative() {
		
		return new Sum(function1.derivative(),function2.derivative());
	}
	@Override
	public String toString() {
		String string1 = function1.toString();
		String string2 = function2.toString();
		return string1 + string2;
	}
	
	public Function integral() {
		if (function1 instanceof Integrable && function2 instanceof Integrable ) {
			return new Sum(((Integrable) function1).integral(), ((Integrable) function2).integral()); 
			
		}
		return null;
	}

}
