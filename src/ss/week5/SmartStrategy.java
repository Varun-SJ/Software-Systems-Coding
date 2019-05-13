package ss.week5;

import java.util.Random;

public class SmartStrategy implements Strategy {
	
	
	private static final String NAME = "Smart";

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.NAME;
	}

	@Override
	public int determineMove(Board b, Mark m) {
		int row;
		int col;
		
		//middle row possible
		
		if(b.isEmptyField(row = Board.DIM / 2,col = Board.DIM/2) ){
			return b.index(row, col);
		}
		
		
		//check if field ensures guarantee win for comp
		
		for (int i = 0; i < Board.DIM*Board.DIM; i++) {
			Board newBoard = b.deepCopy();
			newBoard.setField(i, m);
			if (newBoard.isWinner(m)) {return i;}
		}
		
		// check if field ensures win for player
		
		for (int i = 0; i < Board.DIM*Board.DIM; i++ ) {
			Board newBoard = b.deepCopy();
			newBoard.setField(i, m.other());
			if(newBoard.isWinner(m.other())) {return i;}
		}
		
		// random move for comp
		return doRandomMove(b);
		
		// TODO Auto-generated method stub
	}
		
		public int doRandomMove(Board b) {
			int retur;
			while (!b.isEmptyField(retur = new Random().nextInt(Board.DIM*Board.DIM)));
			return retur;
			
		}
	}

