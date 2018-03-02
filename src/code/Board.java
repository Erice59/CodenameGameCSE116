package code;

import java.util.List;
/**
 * Class sets board up filling a Location array with the codenames, revealed status, and type of person in that location.
 * @author Alex Chmielewski
 *
 */
public class Board { 
	/**
	 * personList is a list containing names of each person in the game
	 */
	private List<String> personList;
	/**
	 * codename is a list containing the codenames at each location instance
	 */
	private List<String> codename;
	/**
	 * location array setting the size of the board so that it can be a two dimension board
	 */
	private Location[][] board;
	/**
	 * variable from PersonHolder class to access names of each person
	 */
	private List<String> _persons;
	/**
	 * Full constructor to make the board of the game and fill each spot of the board with a codename, person and sets the reveal
	 * value to false
	 * @param size sets the size for the array board
	 * @param filepath name of the file to read containing the codenames for the game
	 */
	public Board(int size, String filepath) {
			board = new Location[size][size];
			int codeNum = 0;
			int personNum = 0;
			FileWordReader file = new FileWordReader(filepath);
			codename = file.getCodeNamesList();
			initializePersonList();
			for(int row = 0; row < board.length; row++) {
				for(int col = 0; col < board[row].length; col++) {
					board[row][col] = new Location();
					board[row][col].set_codename(codename.get(codeNum)); 
					board[row][col].set_revealed(false);
					board[row][col].set_person(personList.get(personNum));
					
					codeNum++;
					personNum++;
				}
			}
		}
	/**
	 * Board constructor without any parameters
	 */
	public Board() {
		
	}
	/**
	 * Helper method to initialize and randomize the person types list and assign it to the _persons list instance variable.
	 */
	public void initializePersonList() {
		PersonHelper initPersonList = new PersonHelper();
		initPersonList.setup();
		_persons = initPersonList.getPersonList();
	}
	public void out() {
		int counter = 0;
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				System.out.print("Counter: " + counter + " Codename: " + board[row][col].get_codename() + " Person: " + board[row][col].get_person() + "|");
				System.out.println(board[row][col].get_id());
				counter++;
			}
		}
	}
	/**
	 * Returns board Location array
	 * @return board
	 */
	public Location[][] getBoard() {
		return board;
	}
	
	
	
	
}
