package code;
/**
 * Class creates the board object that contains the 25 location instances and ensures each is assigned a codename, person, and is not revealed.
 * Also sets the red team to have the first turn.
 * @author Eric Weinman
 *
 */
public class GameStart {

	//private boolean teamTurn = true;
	/**
	 * This instance variable contains the information for which team's turn it currently is.
	 */
	private String currentTeamMove = "";
	/**
	 * Instance variable containing the board to be used during the game. The board is composed of an array of 25 location objects.
	 */
	private Board gameBoard;
	
	private Clue c;
	/**
	 * Default constructor that creates an empty board composed of 25 location objects without proper information and sets the first team move to red.
	 */
	public GameStart() {
		setGameBoard(new Board());
		setCurrentTeamMove("Red");
	}
	/**
	 * Full constructor that creates a board of the given size and populates each location with a codename, person, and is not revealed.
	 * Also sets red to be the first team to go.
	 * @param size The size of the board to create (example given 5 it will create a 5 by 5 location array holding 25 locations).
	 * @param filePath Path to the file containing the codenames to use.
	 */
	public GameStart(int size, String filePath) {
		Board board = new Board(size, filePath);
		setGameBoard(board);
		setCurrentTeamMove("Red");
	}
	/**
	 * Method to return which team currently is taking their turn.
	 * @return A string designating which team is currently taking their turn, either Blue or Red.
	 */
	public String getCurrentTeamMove() {
		return currentTeamMove;
	}
	/**
	 * Method to set which team is currently taking their turn.
	 * @param currentTeamMove A string to designate which team is currently taking their turn, either Blue or Red.
	 */
	public void setCurrentTeamMove(String currentTeamMove) {
		this.currentTeamMove = currentTeamMove;
	}
	/**
	 * Method to return the current board being used for the game.
	 * @return Board which is an array of locations holding codenames, persons, and revealed status.
	 */
	public Board getGameBoard() {
		return gameBoard;
	}
	/**
	 * Method to set the current board to a different one.
	 * @param gameBoard A board which is an array of location objects.
	 */
	public void setGameBoard(Board gameBoard) {
		this.gameBoard = gameBoard;
	}
	
	//NEEDS TEST STILL
	public String isSelected(Location l){
		l.set_revealed(true);
		if(l.get_person().equals("Red") && currentTeamMove.equals("Red")){
			c.decrementCount();
			return ("You revealed a red agent");
			
		}
		if(l.get_person().equals("Blue") && currentTeamMove.equalsIgnoreCase("Blue")){
			c.decrementCount();
			return ("You revealed a blue agent");
		}
		else{
			return null;
		}
	}
	
	
	
}
