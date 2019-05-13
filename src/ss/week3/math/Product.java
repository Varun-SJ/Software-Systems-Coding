package ss.week3.math;

public class Product implements Function {
	
	protected Function function1;
	protected Function function2;
	
	public Product(Function function1, Function function2) {
		this.function1 = function1;
		this.function2 = function2;
	}
	public double apply(double arg) {
		double arg1 = function1.apply(arg);
		double arg2 = function2.apply(arg);
		double arg3 = arg1 * arg2;
		return arg3;
	}
	
	public Function derivative() {
		Function deriv1 = function1.derivative();
		Function deriv2 = function2.derivative();
		Function deriv3 = new Product(function1, deriv2);
		Function deriv4 = new Product(function2, deriv1);
		Function deriv5 = new Sum(deriv3, deriv4);
				
		return deriv5;
		
	}
	
	public String toString() {
		return "(" + function1 + ")" + "*" + "(" + function2 + ")";
	}
// f1 * f2
	// (2+3) * (2+4)
}
