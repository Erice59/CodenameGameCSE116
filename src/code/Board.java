package code;

import java.util.List;
/**
 * Class sets board up filling a Location array with the codenames, revealed status, and type of person in that location.
 * @author Alex Chmielewski
 *
 */
public class Board { 
	private List<String> personList;
	private List<String> codename;
	private Location[][] board;
	private PersonHelper person;
	public Board(int size, String filepath) {
			board = new Location[size][size];
			int codeNum = 0;
			FileWordReader file = new FileWordReader(filepath);
			codename = file.getCodeNamesList();
			person = new PersonHelper();
			person.setup();
			personList = person.getPersonList();
			for(int row = 0; row < board.length; row++) {
				for(int col = 0; col < board[row].length; col++) {
					board[row][col] = new Location();
					board[row][col].set_codename(codename.get(codeNum)); 
					board[row][col].set_revealed(false);
					for(int i = 0; i < personList.size(); i++) {
						board[row][col].set_person(personList.get(i));
					}
					
					codeNum++;
				}
			}
		}
	public Location[][] getBoard() {
		return board;
	}
	
	
	
	
}
