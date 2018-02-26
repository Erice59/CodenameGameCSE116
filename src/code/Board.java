package code;

public class Board {
 private String identity; //here for placeholder, probably not needed 
	public Board() {
		String[][] board = new String[5][5];
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board[row].length; col++) {
				Person p = new Person(identity); //I need a way to have a new person identity per space like the game has
				board[row][col] = p.getIdentity();
				
			}
		}
	}
	
	
	
}
