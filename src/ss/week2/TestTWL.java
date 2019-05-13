package ss.week2;

import java.util.Scanner;

public class TestTWL {
	
	private static Scanner sc;

	public static void main(String[] args) {
		new TestTWL();
		TestTWL.run();
	}
	
	public static void run() {
		
		sc = new Scanner(System.in);
		
		TWL twl = new TWL();
		
		boolean play = true;
		
		System.out.println("For now the light is off, which state would you like it to be in? (low, med, high or off)");
		
		while (play == true) {
		
			String input = sc.next();;
			twl.switchState(input);
		
		}
	}

}
