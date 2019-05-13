package ss.week6;

import java.util.Scanner;

public class Words {

	private static Scanner input;

	public static void main(String[] args) {
		boolean breakNow = false;
		initNew();
		input = new Scanner(System.in);
		Scanner lineDo;
		while ((lineDo = new Scanner(input.nextLine())) != null) {
			String words;
			int count = 0;
			while (lineDo.hasNext()) {
				words = lineDo.next();
				if (words.equals("end") && count == 0) {
					breakNow = true;
					break;
				}
				System.out.println("Word " + (count++) + ": " + words);
			}
			lineDo.close();
			if (breakNow)
				break;
			initNew();
		}
		input.close();
	}

	public static void initNew() {
		System.out.print("Line (or \"end\"): ");
	}

}