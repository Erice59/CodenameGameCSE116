package code;

public class Team {
	boolean AssassinCardRevealed = false;
	
	
	public boolean AssassinRevealed() {
		return AssassinCardRevealed;
	}
	
	
	public void touchCard(Card card) {
		if(card.getType()=="Assassin") {
			AssassinCardRevealed = true;
		}
	}

}
