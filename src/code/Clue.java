package code;

public class Clue {
	
	public String thisClue;
	boolean cardRevealed;
	
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

}
