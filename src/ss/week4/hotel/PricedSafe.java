package ss.week4.hotel;

import ss.week3.bill.Bill.Item;

public class PricedSafe extends Safe implements Item, ss.week4.hotel.Bill.Item {
	
	private double amount = 15;
	private Safe safe;
	public String description = "A safe that has to be paid for";
	
	public PricedSafe (double amount) {
		super("Password1234");
		this.amount = amount;
//		Bill.Item item = new PricedSafe(amount);
	}
	
	

	public double getAmount() {
		return this.amount;
	}
	
	public String toString() {
		String output = "";
		output += "Active: " + Boolean.toString(this.isActive());
		output += "Open: " + Boolean.toString(isOpen());
		output += "Price: " + Double.toString(amount);
		output += "Description: " + this.description;
		return output;
	}
	
	public String getDescription() {
		return this.description;
	}

}
