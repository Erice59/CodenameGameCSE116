package code;
/**
 * Class to determine win states of the game for a two team game, will determine the winner if there is one of the current board, and if the board is in a current win state.
 * @author Eric Weinman
 *
 */

public class BoardState {
	
	/**
	 * This instance variable holds who is currently the winner, either "None", "Red", or "Blue".
	 */
	private String winner;
	/**
	 * This instance variable holds if the board is currently in a win state, false if it is not, true if it is.
	 */
	private boolean winState;
	/**
	 * Instance variable that holds if the win condition is from Assassin reveal, or Blue or Red agent reveal.
	 */
	public String winType;
	/**
	 * Default constructor sets winner to none and win state to false.
	 */
	public BoardState() {
		winner = "None";
		winState = false;
		winType = "None";
	}
	/**
	 * Method to update the game win state and check if any changes have occurred or if anyone has one.
	 * @param g A GameStart object of the current game.
	 * @return A boolean value returning true if a win condition has been met, false otherwise.
	 */
	public boolean update(GameStart g) {
		if (assassinRevealed(g)) {
			setWinType("Assassin Revealed");
			return true;
		}
		else if (redRevealed(g)) {
			setWinType("Red Revealed");
			return true;
		}
		else if (blueRevealed(g)) {
			setWinType("Blue Revealed");
			return true;
		}
		setWinner("None");
		setWinState(false);
		return false;
		
	}
	
	/**
	 * Method to determine if the assassin was revealed and setting the winner to the team who did not reveal the assassin.
	 * @param g A GameStart object of the current game.
	 * @return A boolean value returning true if the assassin was revealed and the game was won.
	 */
	public boolean assassinRevealed(GameStart g) {
		Board b = g.getGameBoard();
		Location[][] l = b.getBoard();
		for (int row = 0; row < l.length; row++) {
			for (int col = 0; col < l[row].length; col++) {
				if (l[row][col].get_person().equals("Assassin") && l[row][col].is_revealed() == true) {
					//System.out.println("Board currently in winning state, " + g.getCurrentTeamMove() + " team has lost.");
					if (g.getCurrentTeamMove().equals("Red")) {
						System.out.println("Board currently in winning state, Blue team has won.");
						setWinner("Blue");
					}
					else if (g.getCurrentTeamMove().equals("Blue")) {
						System.out.println("Board currently in winning state, Red team has won.");
						setWinner("Red");
					}
					setWinState(true);
					return true;
				}
			}
		}
		System.out.println("Board not currently in winning state.");
		setWinner("None");
		return false;
	}
	/**
	 * Method to determine if all nine red agents were revealed and setting the winner to be the red team if they were.
	 * @param g A GameStart object of the current game.
	 * @return A boolean value returning true if all nine red agents were revealed and thus the red team has won.
	 */
	public boolean redRevealed(GameStart g) {
		Board b = g.getGameBoard();
		Location[][] l = b.getBoard();
		int redCount = 0;
		for (int row = 0; row < l.length; row++) {
			for (int col = 0; col < l[row].length; col++) {
				if (l[row][col].get_person().equals("Red") && l[row][col].is_revealed() == true) {
					redCount++;
				}
			}
		}
		if (redCount == 9) {
			setWinner("Red");
			setWinState(true);
			return true;
		}
		setWinner("None");
		setWinState(false);
		return false;
	}
	/**
	 * Method to determine if all eight blue agents were revealed and setting the winner to be the blue team if they were.
	 * @param g A GameStart object of the current game.
	 * @return A boolean value returning true if all eight blue agents were revealed and thus the blue team has won.
	 */
	public boolean blueRevealed(GameStart g) {
		Board b = g.getGameBoard();
		Location[][] l = b.getBoard();
		int blueCount = 0;
		for (int row = 0; row < l.length; row++) {
			for (int col = 0; col < l[row].length; col++) {
				if (l[row][col].get_person().equals("Blue") && l[row][col].is_revealed() == true) {
					blueCount++;
				}
			}
		}
		if (blueCount == 8) {
			setWinner("Blue");
			setWinState(true);
			return true;
		}
		setWinner("None");
		setWinState(false);
		return false;
	}
	/**
	 * Method to return who the current winner is if there is one.
	 * @return A string of who the current winner is, either "None", "Red", or "Blue".
	 */
	public String getWinner() {
		return winner;
	}
	/**
	 * Method to set who the current winner is.
	 * @param winner A String of who the current winner should be, either "None", "Red", or "Blue".
	 */
	public void setWinner(String winner) {
		this.winner = winner;
	}
	/**
	 * Method to return which win type the current win is if there is one.
	 * @return A String of how the game was won either "Assassin Revealed", "Blue Revealed", or "Red Revealed".
	 */
	public String getWinType() {
		return winType;
	}
	/**
	 * Method to set which win type the current win is if there is one.
	 * @param winType A String of how the game was won either "Assassin Revealed", "Blue Revealed", or "Red Revealed".
	 */
	public void setWinType(String winType) {
		this.winType = winType;
	}
	/**
	 * Method to return the current win state of the game.
	 * @return A boolean that will be true if the game is in a win state (won) or false if it is not (not yet won).
	 */
	public boolean isWinState() {
		return winState;
	}
	/**
	 * Method to set if the game is in a win state.
	 * @param winState A boolean that will be true if the game is in a win state (won) or false if it is not (not yet won).
	 */
	public void setWinState(boolean winState) {
		this.winState = winState;
	}

}
