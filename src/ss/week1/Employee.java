package ss.week1;

public class Employee {
	private int hours;   // hours worked in the week
	private double rate; // hourly pay rate in dollars
	public Employee(int hours, double rate) {
		super();
		this.hours = hours;
		this.rate = rate;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	public double pay() {
		
		boolean first40 = this.getHours() >= 40;
				if  (first40 == false) {
					return 0.0;}
				else {
		double pay = this.getRate() * 40 + ((this.getRate()*1.5)*(this.getHours() - 40));
		return pay;}
	}
}
