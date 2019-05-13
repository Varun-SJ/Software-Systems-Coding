package ss.week4.hotel;

public class Bill {
	private Printer printer;
	private double totalSum;
	public interface Item{
		public double getAmount();
		
	}
	
	
	public Bill(Printer printer) {
		this.printer = printer;
		this.totalSum = 0;

		
	}
	
	
	public void addItem(Item item) {
		if(item != null){
			totalSum += item.getAmount();
			printer.printLine(item.toString(), item.getAmount());
			
			
		}
		
	}
	
	public void close() {
		printer.printLine("Total is: ", totalSum);
		
		
		
	}
	
	public double getSum() {
		return totalSum;
	}
	
	

}


