package code;

public class ThreeTurnLogic {

	public final Teams GREEN = Teams.Green;
	public final Teams BLUE = Teams.Blue;
	public final Teams RED = Teams.Red;
	public final Teams NONE = Teams.None;
	
	public ThreeTurnLogic() {
		
	}
	
	public Teams nextTeam(GameStart g) {
		Teams nextTurn = NONE;
		if (GameStart.getEliminatedTeam() == RED) {
			if (g.getCurrentTeamMoveT() == BLUE) {
				nextTurn = GREEN;
				//g.setCurrentTeamMove("Green");
			}
			else if (g.getCurrentTeamMoveT() == GREEN) {
				//g.setCurrentTeamMove("Blue");
				nextTurn = BLUE;
			}
		}
		else if (GameStart.getEliminatedTeam() == BLUE) {
			if (g.getCurrentTeamMoveT() == RED) {
				//g.setCurrentTeamMove("Green");
				nextTurn = GREEN;
			}
			else if (g.getCurrentTeamMoveT() == GREEN) {
				//g.setCurrentTeamMove("Red");
				nextTurn = RED;
			}
		}
		else if (GameStart.getEliminatedTeam() == GREEN) {
			if (g.getCurrentTeamMoveT() == BLUE) {
				nextTurn = RED;
			}
			else if (g.getCurrentTeamMoveT() == RED) {
				nextTurn = BLUE;
			}
		}
		else if (GameStart.getEliminatedTeam() == NONE) {
			if (g.getCurrentTeamMoveT() == RED) {
				nextTurn = BLUE;
			}
			else if (g.getCurrentTeamMoveT() == BLUE) {
				nextTurn = GREEN;
			}
			else if (g.getCurrentTeamMoveT() == GREEN) {
				nextTurn = RED;
			}
		}
		g.setCurrentTeamMove(nextTurn);
		return nextTurn;
	}
	
}
