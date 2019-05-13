package ss.week1;

public class Lamp {
	int setting = 3;
	int low = 0;
	int medium = 1;
	int high = 2;
	
	public int nameOfFunction() {
		this.high = 100;
		return this.high;
	}
	 
	
	public static void main(String[] args) {
		Lamp lamp = new Lamp();
		TWL twl = new TWL();
		System.out.println(twl.getSettings());
		lamp.nameOfFunction();
		System.out.println(lamp.nameOfFunction());
	}
}

