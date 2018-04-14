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
	private List<String> _personList;
	/**
	 * codename is a list containing the codenames at each location instance
	 */
	private List<String> _codenames;
	/**
	 * location array setting the size of the board so that it can be a two dimension board
	 */
	private Location[][] _board;
	/**
	 * Full constructor to make the board of the game and fill each spot of the board with a codename, person and sets the reveal
	 * value to false
	 * @param size sets the size for the array board
	 * @param filepath name of the file to read containing the codenames for the game
	 */
	public Board(int size, String filepath) {
		Location[][] board = new Location[size][size];
		_board = internalConfigure(board, filepath);
		
	}
	
	public Board(String filepath) {
		Location[][] board = new Location[5][5];
		_board = internalConfigure(board, filepath);
	}
	
	/**
	 * Board constructor without any parameters
	 */
	public Board() {
		_board = new Location[5][5];
	}
	/**
	 * Method that performs the necessary tasks to configure the board. Populates each location on the board with the needed person type and codename.
	 * @param l l the board array (composed of location objects) to be configured.
	 * @param s S the path to the codenames file.
	 * @return Board composed of location objects that is properly initialized and populated with correct person types and codenames.
	 */
	public Location[][] internalConfigure(Location[][] l, String s) {
		Location[][] board = l;
		initializePersonList();
		FileWordReader codenames = new FileWordReader(s);
		this._codenames = codenames.getCodeNamesList();
		int personNum = 0;
		int codenameNum = 0;
		//System.out.println(_persons); For debugging initialization methods
		//System.out.println(_codenames); For debugging initialization methods
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				board[row][col] = new Location();
				board[row][col].set_codename(_codenames.get(codenameNum));
				board[row][col].set_person(_personList.get(personNum));
				board[row][col].set_id(Integer.toString(row) + Integer.toString(col));
				personNum++;
				codenameNum++;
			}
		}
		this._board = board;
		return board;
	}

	/**
	 * Helper method to initialize and randomize the person types list and assign it to the _persons list instance variable.
	 */
	public void initializePersonList() {
		PersonHelper initPersonList = new PersonHelper();
		initPersonList.setup();
		_personList = initPersonList.getPersonList();
	}
	public void out() {
		int counter = 0;
		for (int row = 0; row < _board.length; row++) {
			for (int col = 0; col < _board[row].length; col++) {
				System.out.print("Counter: " + counter + " Codename: " + _board[row][col].get_codename() + " Person: " + _board[row][col].get_person() + "|");
				System.out.println(_board[row][col].get_id());
				counter++;
			}
		}
	}
	/**
	 * Returns board Location array
	 * @return board
	 */
	public Location[][] getBoard() {
		return this._board;
	}
	/**
	 * Setter method to manually replace the board if needed.
	 * @param b A board composed of an array of location objects.
	 */
	public void setBoard(Location[][] b) {
		this._board = b;
	}
	public List<String> get_personList() {
		return _personList;
	}
	public List<String> get_codenames() {
		return _codenames;
	}
	public void set_personList(List<String> _personList) {
		this._personList = _personList;
	}
	public void set_codenames(List<String> _codenames) {
		this._codenames = _codenames;
	}
	

}




