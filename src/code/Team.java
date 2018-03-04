package code;


/*this class works to test whether the assassin was revealed or 
not and returns a boolean value that is true or false*/




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
