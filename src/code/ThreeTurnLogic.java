package code;

public class ThreeTurnLogic {

	public ThreeTurnLogic() {
		
	}
	
	public String nextTeam(GameStart g) {
		String nextTurn = "";
		if (GameStart.getEliminatedTeam() == Teams.RED) {
			if (g.getCurrentTeamMove().equals("Blue")) {
				nextTurn = "Green";
				g.setCurrentTeamMove("Green");
			}
			else if (g.getCurrentTeamMove().equals("Green")) {
				g.setCurrentTeamMove("Blue");
				nextTurn = "Blue";
			}
		}
		else if (GameStart.getEliminatedTeam() == Teams.BLUE) {
			if (g.getCurrentTeamMove() == Teams.RED.getTeam()) {
				g.setCurrentTeamMove("Green");
				nextTurn = "Green";
			}
			else if (g.getCurrentTeamMove() == Teams.GREEN.getTeam()) {
				g.setCurrentTeamMove("Red");
				nextTurn = "Red";
			}
		}
		else if (GameStart.getEliminatedTeam() == Teams.GREEN) {
			if (g.getCurrentTeamMove() == Teams.BLUE.getTeam()) {
				
			}
			else if (g.getCurrentTeamMove() == Teams.RED.getTeam()) {
				
			}
		}
		return nextTurn;
	}
	
}
