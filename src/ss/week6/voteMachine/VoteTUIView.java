package ss.week6.voteMachine;

import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Scanner;
import java.util.Set;
import java.util.Observer;

public class VoteTUIView implements VoteView {

	private VoteMachine controller;

	public VoteTUIView(VoteMachine controller) {
		this.controller = controller;
	}

	/**
	 * Keeps reading commands from STDIN
	 * 
	 */
	public void start() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Gimme some input!");
		String line = null;
		while ((line = scan.nextLine()) != null) {
			Command cmd = recognizeCommand(line);
			if (cmd.getCommand().equals("VOTE")) {
				controller.vote(cmd.getParam());
			} else if (cmd.getCommand().equals("ADD PARTY")) {
				controller.addParty(cmd.getParam());
			} else if (cmd.getCommand().equals("VOTES")) {
				showVotes(controller.getVotes());
			} else if (cmd.getCommand().equals("PARTIES")) {
				showParties(controller.getParties());
			} else if (cmd.getCommand().equals("EXIT")) {
				break;
			} else if (cmd.getCommand().equals("HELP")) {
				// TODO: implement
			} else {
				showError("Unknown command entered");
			}
		}
		scan.close();
	}

	/**
	 * Recognizes command from a line read from STDIN
	 * 
	 * @param line
	 * @return Command object
	 */
	public Command recognizeCommand(String line) {
		Scanner scan = new Scanner(line);
		String fw = scan.next();
		if (fw.equals("VOTE") || fw.equals("VOTES") || fw.equals("PARTIES") || fw.equals("EXIT") || fw.equals("HELP")) {
			return new Command(fw, readNextIntoString(scan));
		} else if (fw.equals("ADD") && scan.next().equals("PARTY")) {
			return new Command("ADD PARTY", readNextIntoString(scan));
		} else {
			scan.close();
			return new Command("UNKNOWN");
		}
	}

	/**
	 * Command that shows the votes right now
	 * 
	 * @param votes
	 */
	public void showVotes(Map<String, Integer> votes) {
		System.out.println("Current votes:");
		Set<String> keyset = votes.keySet();
		for (String key : keyset) {
			System.out.println("Party: " + key + " has " + votes.get(key) + " votes");
		}
	}

	/**
	 * Command that prints the current parties in the system
	 * 
	 * @param parties
	 */
	public void showParties(List<String> parties) {
		System.out.println("Current parties in the system:");
		for (String party : parties) {
			System.out.println(party);
		}
	}

	/**
	 * Command which prints errors on the STDOUT
	 * 
	 * @param error
	 */
	public void showError(String error) {
		System.out.println(error);
	}

	/**
	 * Reads a scanner into string
	 * 
	 * @param scan
	 * @return
	 */
	public static String readNextIntoString(Scanner scan) {
		String output = "";
		boolean first = false;
		while (scan.hasNext()) {
			if (first)
				output += " ";
			output += scan.next();
		}
		scan.close();
		return output;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg.equals("vote")) {
			System.out.println("A vote has been casted!");
		} else if (arg.equals("party")) {
			System.out.println("A party has been added!");
		} else {
			System.out.println("Something weird happened...");
		}
	}
}