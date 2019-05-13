package ss.week4.hotel;

public class testimports {
	Printer printer;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public Bill getBill () {
		return new Bill(new StringPrinter());
	}

}
