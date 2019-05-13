package ss.week1.test;

public class DollarsAndCentsCounter {
	
	private int dollars;
	private int cents;
	private double money;
	
	
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public int dollars() {
		int dollars = (int)(this.getMoney()/100);
		return dollars;
	}
	public void setDollars(int dollars) {
		this.dollars = dollars;
	}
	public int getCents() {
		return cents;
	}
	public void setCents(int cents) {
		this.cents = cents;
	}
	
	public int dollars() {
		if (this.getDollars() >= 0) {
			return dollars;}
		else {return (Integer) null;}
		}
	public int cents() {
		if (this.getCents() >= 0 && this.getCents() <= 99) {
			return cents;}
		else {return (Integer) null;}
		}
	public void add(int dollars, int cents) {
		double currentDollar = this.getDollars();
		currentDollar = currentDollar + dollars;
		currentDollar = currentDollar*100;
		
		double currentCents = this.getCents();
		currentCents = currentCents + cents;
		currentCents = currentDollar + currentCents;
		this.setMoney(currentCents);
		
	}
	public void reset () {
		this.dollars = 0;
		this.cents = 0;
	}
	
	public void subtract (int dollars, int cents) {
		
	
	}
}


