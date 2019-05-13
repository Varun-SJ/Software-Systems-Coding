package ss.week6.voteMachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class VoteList extends Observable {

	private Map<String, Integer> votes = new HashMap<String, Integer>();

	public void addVote(String party) {
		if (votes.get(party) == null) {
			votes.put(party, 1);
		} else {
			votes.put(party, votes.get(party) + 1);
		}
		setChanged();
		notifyObservers("vote");
	}

	public Map<String, Integer> getVotes() {
		return votes;
	}

}
