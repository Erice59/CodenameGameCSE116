package code;


/**
 * This class works to test whether the assassin was revealed or 
 *  not and returns a boolean value that is true or false
 * @author Adam Jbarah
 *
 */



/**
 *A boolean statement checking if the statement that the assassin was revealed is false
 */
public class Team {
	boolean AssassinCardRevealed = false;

/**
*A boolean statement determining whether or not the Assassin was revealed
*/	
	public boolean AssassinRevealed() {
		return AssassinCardRevealed;
	}

/**
 * If statement saying that if the card type that was reveled is 
 * the assassin card then return true. 
 */
	public void touchCard(Card card) {
		if(card.getType()=="Assassin") {
			AssassinCardRevealed = true;
		}
	}

}
