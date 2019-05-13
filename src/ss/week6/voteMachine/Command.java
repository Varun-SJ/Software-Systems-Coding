package ss.week6.voteMachine;

import java.util.Scanner;

public class Command {

	private String command;
	private String params;

	public Command(String command) {
		this.command = command;
	}

	public Command(String command, String params) {
		this(command);
		this.params = params;
	}

	public String getCommand() {
		return command;
	}

	@SuppressWarnings("resource")
	public String getParam() {
		Scanner scan = new Scanner(params);
		if (scan.hasNext()) {
			return scan.next();
		} else {
			return "";
		}
	}

	@SuppressWarnings("resource")
	public String getParam(int n) {
		Scanner scan = new Scanner(params);
		for (int i = 0; i <= n; i++) {
			if (scan.hasNext()) {
				scan.next();
			}
		}
		if (scan.hasNext()) {
			return scan.next();
		} else {
			return "";
		}
	}

}