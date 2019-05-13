package ss.week3.bill;

public interface Printer {
	
	
	public void printLine(String text, double price);
	
	default String format(String text, double price) {
		return (String.format("%-10s %.2f\n",text, price ));
		
	}


}
