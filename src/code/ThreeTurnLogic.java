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
			if (ThreeTBoardState.justChange) {
				if (g.getCurrentTeamMoveT() == RED) {
					nextTurn = BLUE;
					ThreeTBoardState.setJustChange(false);
				}
			}
			else if (g.getCurrentTeamMoveT() == BLUE) {
				nextTurn = GREEN;
			}
			else if (g.getCurrentTeamMoveT() == GREEN) {
				nextTurn = BLUE;
			}
		}
		else if (GameStart.getEliminatedTeam() == BLUE) {
			if (ThreeTBoardState.justChange) {
				if (g.getCurrentTeamMoveT() == BLUE) {
					nextTurn = GREEN;
					ThreeTBoardState.setJustChange(false);
				}
			}
			else if (g.getCurrentTeamMoveT() == RED) {
				nextTurn = GREEN;
			}
			else if (g.getCurrentTeamMoveT() == GREEN) {
				nextTurn = RED;
			}
		}
		else if (GameStart.getEliminatedTeam() == GREEN) {
			if (ThreeTBoardState.justChange) {
				if (g.getCurrentTeamMoveT() == GREEN) {
					nextTurn = RED;
					ThreeTBoardState.setJustChange(false);
				}
			}
			else if (g.getCurrentTeamMoveT() == BLUE) {
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
		System.out.println("NEXT TEAM TURN: " + nextTurn);
		g.setCurrentTeamMove(nextTurn);
		return nextTurn;
	}
}
