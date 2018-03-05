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
	 * Default constructor
	 */
	public Clue() {
		
	}
	
	/**
	 * Constructor with parameter that sets the parameter equal to thisClue
	 * @param setClue
	 */
	public Clue(String setClue) {
		thisClue = setClue;
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
	public void setCount(Board b){
		Location[][] l = b.getBoard();
		for (int row = 0; row < l.length; row++) {
			for (int col = 0; col < l[row].length; col++) {
				if(l[row][col].get_person().equals(thisClue)){
					count++;
				}
			}
		}
	}
	
	public boolean legalityCheck(Board b, String c) {
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
