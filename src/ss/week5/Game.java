package ss.week5;

import java.util.Scanner;

/**
 * Class for maintaining the Tic Tac Toe game.
 * Lab assignment Module 2
 * @author Theo Ruys en Arend Rensink
 */
public class Game {
    public static final int NUMBER_PLAYERS = 2;

    /*@ private invariant board != null; */
    /**
     * The board.
     */
    private Board board;

    /*@  private invariant players.length == NUMBER_PLAYERS;
        private invariant (\forall int i; 0 <= i && i < NUMBER_PLAYERS; 
       	                           players[i] != null); 
     */
    /**
     * The 2 players of the game.
     */
    private Player[] players;

    /*@ private invariant 0 <= current  && current < NUMBER_PLAYERS; */
    /**
     * Index of the current player.
     */
    private int current;

    // -- Constructors -----------------------------------------------

    /*@ requires s0 != null;
        requires s1 != null;
     */
    /**
     * Creates a new Game object.
     * @param s0 the first player
     * @param s1 the second player
     */
    public Game(Player s0, Player s1) {
        board = new Board();
        players = new Player[NUMBER_PLAYERS];
        players[0] = s0;
        players[1] = s1;
        current = 0;
    }

    // -- Commands ---------------------------------------------------

    /**
     * Starts the Tic Tac Toe game. <br>
     * Asks after each ended game if the user want to continue. Continues until
     * the user does not want to play anymore.
     */
    public void start() {
        boolean doorgaan = true;
        while (doorgaan) {
            reset();
            play();
            doorgaan = readBoolean("\n> Play another time? (y/n)?", "y", "n");
        }
    }

    /**
     * Prints a question which can be answered by yes (true) or no (false).
     * After prompting the question on standard out, this method reads a String
     * from standard in and compares it to the parameters for yes and no. If the
     * user inputs a different value, the prompt is repeated and the method reads
     * input again.
     * 
     * @parom prompt the question to print
     * @param yes
     *            the String corresponding to a yes answer
     * @param no
     *            the String corresponding to a no answer
     * @return true is the yes answer is typed, false if the no answer is typed
     */
    @SuppressWarnings("resource")
	private boolean readBoolean(String prompt, String yes, String no) {
        String answer;
        Scanner in;
        do {
            System.out.print(prompt);
            in = new Scanner(System.in);
            answer = in.hasNextLine() ? in.nextLine() : null;
        } while (answer == null || (!answer.equals(yes) && !answer.equals(no)));
        return answer.equals(yes);
    }

    /**
     * Resets the game. <br>
     * The board is emptied and player[0] becomes the current player.
     */
    private void reset() {
        current = 0;
        board.reset();
    }

    /**
     * Plays the Tic Tac Toe game. <br>
     * First the (still empty) board is shown. Then the game is played
     * until it is over. Players can make a move one after the other. 
     * After each move, the changed game situation is printed.
     */
    private void play() {
        // TODO: implement, see P-4.20
    	current = (int) Math.round(Math.random()* (Game.NUMBER_PLAYERS - 1));
    	while (!board.gameOver()) {
    		update();
    		players[current].makeMove(board);
    		current++;
    		current = current % Game.NUMBER_PLAYERS;
    	}
    	printResult();
    	
    }

    /**
     * Prints the game situation.
     */
    private void update() {
        System.out.println("\ncurrent game situation: \n\n" + board.toString()
                + "\n");
    }

    /*@
       requires this.board.gameOver();
     */

    /**
     * Prints the result of the last game. <br>
     */
    private void printResult() {
        if (board.hasWinner()) {
            Player winner = board.isWinner(players[0].getMark()) ? players[0]
                    : players[1];
            System.out.println("Speler " + winner.getName() + " ("
                    + winner.getMark().toString() + ") has won!");
        } else {
            System.out.println("Draw. There is no winner!");
        }
    }
}
