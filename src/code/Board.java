package code;

public class Board {
	private String identity; 
	public Board() {
		String[][] board = new String[5][5];
		
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board[row].length; col++) {
				Person p = new Person(identity); 
				board[row][col] = p.getIdentity();
				
			}
		}
	}
	
	
	
}
