package ss.week3.bill;

public class SysoutPrinter implements Printer {
	public SysoutPrinter() {
		
	}
	
	public SysoutPrinter(String text, double price) {
		
	}
	@Override
	public void printLine(String text, double price) {
		System.out.println(format(text, price));
		
		
	}
	
	public static void main(String[]args) {
		SysoutPrinter syp = new SysoutPrinter();
		syp.printLine("Text", 12.965);
		
	}
	

}
