package ss.week6;

import java.util.Scanner;

public class Hello {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Your name is: ");
		boolean loop = true;
		while (loop) {
			if (in.hasNextLine()) {
				loop = parseIn(in.nextLine());
			}
		}
		in.close();
	}
	
	public static boolean parseIn (String input) {
		if (input.equals("")) {return false;}
		System.out.println("Hello " + input);
		return true;
	}
	

}
