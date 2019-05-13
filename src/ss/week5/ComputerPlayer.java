package ss.week5;

public class ComputerPlayer extends Player {
	
	private Strategy strategy;
	
	/*
	 * Constructors of ComputerPlayer
	 *@
	 * 
	 */
	
	public ComputerPlayer(Mark mark, Strategy strategy) {
		super(strategy.getName() + ":" + mark.toString(), mark);
		this.strategy = strategy;
	}
	public ComputerPlayer(Mark mark) {
		this(mark, new NaiveStrategy());
	}
	
	/*@
	 * @ensures \result == strategy.determineMove(board, this.getMark());
	 * 
	 */
	
	@Override
	public int determineMove(Board board) {
		return strategy.determineMove(board, this.getMark());
	}

}
