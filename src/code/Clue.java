package code;
/**
 * Class that creates a clue and also sets the revealing status of a card along with changing the count.
 * @author Adam Jbarah
 *
 */
public class Clue {
	/**
	 * String that is the clue
	 */
	private String thisClue;
	/**
	 * True or false variable if the card is revealed it is true
	 */
	private boolean cardRevealed;
	/**
	 * Count integer variable
	 */
	private int count;
	
	/**
	 * Gamestart variable so it uses the same board, etc.
	 */
	//private GameStart gs;
	
	/**
	 * board variable equal to gamestart's variable to ensure all use same board instance
	 */
	private Board b;
	/**
	 * constructor with gamestart as paramter
	 */
	public Clue(GameStart gs) {
		b = gs.getGameBoard();
		count = 0;
		thisClue = "";
	}
	
	/**
	 * setter method to set thisClue
	 * @param clue
	 */
	public void setClue(String clue){
		thisClue = clue;
	}
	
	
	/**
	 * 
	 * @return thisClue
	 */
	public String getClue() {
		return thisClue;
	}
	/**
	 * sets card revealed status 
	 * @param b
	 */
	public void setCardRevealed(boolean b) {
		cardRevealed = b;
	}
	/**
	 * 
	 * @return cardRevealed
	 */
	public boolean getCardRevealed() {
		return cardRevealed;
	}
	/**
	 * increments through board, if the person at a spot is thisClue the count is increased
	 * @param b
	 */
	public void setCount(){
		Location[][] l = b.getBoard();
		for (int row = 0; row < l.length; row++) {
			for (int col = 0; col < l[row].length; col++) {
				if(l[row][col].get_person().equals(thisClue)){
					count++;
				}
			}
		}
	}
	
	/**
	 * sets the count based on what the spymaster feeds it
	 * @param c
	 */
	public void setCount(int c){
		count = c;
	}
	
	public boolean legalityCheck(String c) {
		Location[][] l = b.getBoard();
		for (int row = 0; row < l.length; row++) {
			for (int col = 0; col < l[row].length; col++) {
				if(l[row][col].get_codename().equals(c) && !(l[row][col].is_revealed())){
					return false;
				}
			}
		}
		return true;
	}
	
	
	
	/**
	 * decreases the count 
	 */
	public void decrementCount(){
		if(count >= 1){
		count--;
		}
	}
	/**
	 * increases the count
	 */
	public void addCount(){
		count++;
	}
	/**
	 * 
	 * @return count
	 */
	public int getCount(){
		return count;
	}

}
