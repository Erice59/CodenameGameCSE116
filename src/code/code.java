package code;

public class code {

	//This class tests if a clue is legal or not
	
	public String codeName;
	
	
	public boolean legalClue(Clue clue) {
		if(clue.getClue()==codeName&&clue.cardRevealed==false) {
			return false;
		}	
		return true;	
	}
	
	/* This is an if else statement to show which team did not lose  meaning which 
	   team didn't reveal the assassin.
	  
	
	  This statement says that if the assassin is revealed for team1 is a true statement 
	   then return team 2     */
	
	public Team winningTeam(Team team1, Team team2) {
		if(team1.AssassinRevealed()==true) {
			return team2;
		}
		
		/* This statement says that if the assassin is revealed for team2 is a true statement 
		 then return team 1     */
		
		else if(team2.AssassinRevealed()==true){
			return team1;
		
			
		}
		
		/*This statement works to say if the above conditions are not met meaning 
		 the assassin is not revealed for either team then print out
		that there is no team currently winning*/
		
		else {
			System.out.println("There is no winning team currently.");
			return null;
		}
		
		
	}
	
}
