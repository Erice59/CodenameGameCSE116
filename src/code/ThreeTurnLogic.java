package code;

public class ThreeTurnLogic {

	public ThreeTurnLogic() {
		
	}
	
	public String nextTeam(GameStart g) {
		String nextTurn = "";
		if (GameStart.getEliminatedTeam() == Teams.Red) {
			if (g.getCurrentTeamMove().equals("Blue")) {
				nextTurn = "Green";
				g.setCurrentTeamMove("Green");
			}
			else if (g.getCurrentTeamMove().equals("Green")) {
				g.setCurrentTeamMove("Blue");
				nextTurn = "Blue";
			}
		}
		else if (GameStart.getEliminatedTeam() == Teams.Blue) {
			if (g.getCurrentTeamMove() == Teams.Red.getTeam()) {
				g.setCurrentTeamMove("Green");
				nextTurn = "Green";
			}
			else if (g.getCurrentTeamMove() == Teams.Green.getTeam()) {
				g.setCurrentTeamMove("Red");
				nextTurn = "Red";
			}
		}
		else if (GameStart.getEliminatedTeam() == Teams.Green) {
			if (g.getCurrentTeamMove() == Teams.Blue.getTeam()) {
				
			}
			else if (g.getCurrentTeamMove() == Teams.Red.getTeam()) {
				
			}
		}
		return nextTurn;
	}
	
}
