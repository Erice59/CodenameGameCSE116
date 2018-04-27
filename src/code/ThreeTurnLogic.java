package code;

public class ThreeTurnLogic {

	public ThreeTurnLogic() {
		
	}
	
	public String nextTeam(GameStart g) {
		String nextTurn = "";
		if (GameStart.getEliminatedTeam().equals("Red")) {
			if (g.getCurrentTeamMove().equals("Blue")) {
				
			}
		}
		else if (GameStart.getEliminatedTeam().equals("Blue")) {
			
		}
		else if (GameStart.getEliminatedTeam().equals("Green")) {
			
		}
		return nextTurn;
	}
	
}
