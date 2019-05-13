package ss.week6.voteMachine;

import java.util.List;
import java.util.Map;
import ss.week6.voteMachine.gui.*;

public class VoteMachine {

	public static VoteMachine voteMachine;
	public VoteList voteList;
	public PartyList partyList;
	public VoteView view;

	public static void main(String[] args) {

		VoteMachine voteMachine = new VoteMachine();
		voteMachine.start();

		// TODO Auto-generated method stub

	}

	public VoteMachine() {
		voteList = new VoteList();
		partyList = new PartyList();
		view = new VoteTUIView(this);

	}

	public void start() {
		partyList.addObserver(view);
		voteList.addObserver(view);
		view.start();

	}

	public void addParty(String party) {
		partyList.addParty(party);
	}

	public void vote(String party) {
		voteList.addVote(party);
	}

	public List<String> getParties() {
		return partyList.getParties();
	}

	public Map<String, Integer> getVotes() {
		return voteList.getVotes();
	}

}
