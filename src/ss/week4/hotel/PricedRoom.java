package ss.week4.hotel;

import ss.week3.bill.Bill.Item;

//import ss.week3.bill.Bill.Item;

public class PricedRoom extends Room implements Bill.Item, Item {
	
	private double amount;
	public String description = "Room";
	
	public PricedRoom(int roomnumber, double roomprice, double safeprice) {
		super(roomnumber, new PricedSafe(safeprice));
		this.amount = roomprice;
	}
	
	public double getAmount() {
		return this.amount;
	}
	
	public String toString() {
		String output = "";
		output += "Room";
		output += "Safe: " + super.getSafe().toString() + "";
		output += "Price: " + Double.toString(amount) + " ";
		return output;
	}
	
	@Override 
	public String getDescription() {
		return "The safe costs: " + amount + "for"+description;
	}
	
	

}
