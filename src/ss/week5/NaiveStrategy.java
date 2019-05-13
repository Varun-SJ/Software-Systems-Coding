package ss.week5;

import ss.week5.Board;
import java.util.Random;

public class NaiveStrategy implements Strategy {
	
	
	private final static String NAME = "Naive"; //@invariant
	private static Random random = new Random();
	
	/*
	 * (non-Javadoc)
	 * @see ss.week5.Strategy#getName()
	 * @pure
	 * @ensures \result == this.NAME;
	 */

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.NAME;
	}
	
	/*@
	 * @pure
	 * @requires (!b.isEmptyField(retur = random.nextInt(DIM*DIM)));
	 * @ensures \result == retur;
	 */

	@Override
	public int determineMove(Board b, Mark m) {
		int retur;
		while(!b.isEmptyField(retur = random.nextInt(Board.DIM*Board.DIM) ));
		// TODO Auto-generated method stub
		return retur;
	}

}
