package code;

public class code {

	String codeName;
	
	
	public boolean legalClue(Clue clue) {
		if(clue.getClue()==codeName&&clue.cardRevealed==false) {
			return false;
		}	
		return true;	
	}
	
	
	public Team winningTeam(Team team1, Team team2) {
		if(team1.AssassinRevealed()==true) {
			return team2;
		}
		else if(team2.AssassinRevealed()==true){
			return team1;
		}
		else {
			System.out.println("There is no winning team currently.");
			return null;
		}
		
		
	}
	
}
