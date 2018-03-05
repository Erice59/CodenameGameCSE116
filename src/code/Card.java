package code;

/**
 *  This Class works to reveal the card type
 * @author Adam Jbarah
 *
 */

public class Card {
	
	/**
	 * We are taking in a String called Type
	 */
	
	private String type;
	
	
	/**
	 * This line assigns the card type
	 * @param cardType
	 */
	public Card(String cardType) {
		type = cardType;
	}
	/**
	 * This line returns the card type
	 */
	public String getType() {
		return type;
	}
	

}
