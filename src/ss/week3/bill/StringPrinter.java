package ss.week3.bill;

public class StringPrinter implements Printer {
	
	public String initialStr = "";

	
	public StringPrinter() {
		super();
		
	}
	
	public void printLine(String text, double price) {
		String formatted = format(text, price);
		initialStr += formatted;  
		
		
	}
	
	public String getResult() {
		return initialStr;
		
	}
	
	public static void main(String[]args) {
		StringPrinter strp = new StringPrinter();
		strp.printLine("Jesus", 12);
		strp.printLine("Ok", 15);
		strp.printLine("abcde", 14);
		System.out.println(strp.getResult());
	}
	
	

}
