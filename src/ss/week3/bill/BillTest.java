package ss.week3.bill;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BillTest {
	public class Item implements Bill.Item{
		private String text;
		private double amount;
		
		public Item(String text,double amount) {
			
			this.text = text;
			this.amount = amount;
		}
		
		public String toString() {
			return this.text;
		}
		
		public double getAmount() {
			return amount;
		}
	}
		
		
	private Bill bill;
	private Printer printer;
	private Bill.Item item;
	private Bill.Item item2;
	
	
	
	@BeforeEach
	public void setUp() {
		printer = new StringPrinter();
		bill = new Bill(printer);
		item = new Item("ABCDE", 12.50);
		item2 = new Item ("QWERTYUI", 15.90);
		
		
	}

	@Test
	public void testAddItem() {
		bill.addItem(item);
		bill.addItem(item2);
		bill.close();
//		if (printer instanceof StringPrinter) System.out.println(((StringPrinter) printer).getResult());
		assertEquals("ABCDE      12.50\nQWERTYUI   15.90\nTotal is:  28.40\n", ((StringPrinter)printer).getResult());
		
	
	}
	
	@Test
	public void testCloseItem() {
		bill.addItem(item);
		bill.close();
	}
		
	@Test
	public void testGetSum() {
		bill.addItem(item);
		bill.addItem(item2);
		assertEquals( bill.getSum(), 28.40, 0.0000000000000000000000005);
	}

}
