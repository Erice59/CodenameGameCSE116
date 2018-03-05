package code;
/**
 * This class works to define which team didn't lose when the assassin is rEvealed
 * @author Adam Jbarah
 *
 */
public class code {

/**
 * This is a string called codeName
 */
	public String codeName;
	
/**
 * It takes in a boolean value that assigns whether the clue taken in is legal and 
 * says if the statement that the card was revealed is false and the clue is equal to 
 * code name , return false, else return true.
 * @param clue
 * @return
 */
	public boolean legalClue(Clue clue) {
		if(clue.getClue()==codeName&&clue.cardRevealed==false) {
			return false;
		}	
		return true;	
	}
	
	/** 
	  This if statement says that if the assassin is revealed for team1 is a true 
	  statement then return team 2  
	  */
	
	public Team winningTeam(Team team1, Team team2) {
		if(team1.AssassinRevealed()==true) {
			return team2;
		}
		
		/** This else statement says that if the assassin is revealed for team2 
		 * is a true statement then return team 1. It works to see if team2 lost.   
		 */
		
		else if(team2.AssassinRevealed()==true){
			return team1;
		
			
		}
		
		/**
		 * This statement works to say if the above conditions are not met meaning  
		 *the assassin is not revealed for either team then print out the line
		 * "There is no team currently winning"*/
		
		else {
			System.out.println("There is no winning team currently.");
			return null;
		}
		
		
	}
	
}
