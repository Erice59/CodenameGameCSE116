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
	for (int x = 0; x< b.getPerson().size(); x++){
		if(b.getPerson().get(x).equals(thisClue)){
			count++;
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
