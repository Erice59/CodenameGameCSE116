package code;

public class Clue {
	
	public String thisClue;
	boolean cardRevealed;
	private int count;
	
	public Clue(){
		
	}
	
	public Clue(String setClue) {
		thisClue = setClue;
	}
	
	

	public String getClue() {
		return thisClue;
	}
	
	public void setCardRevealed(boolean b) {
		cardRevealed = b;
	}
	
	public boolean getCardRevealed() {
		return cardRevealed;
	}
	
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
	
	
	public void decrementCount(){
		count--;
	}
	
	public void addCount(){
		count++;
	}
	
	public int getCount(){
		return count;
	}

}
