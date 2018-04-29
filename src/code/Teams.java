package code;

public enum Teams {
	BLUE ("Blue"),
	GREEN ("Blue"),
	NONE ("None"),
	RED ("Red");
	
	private final String teamNames;
	
	Teams(String t) {
		this.teamNames = t;
	}
	
	public String getTeam() {
		return this.teamNames;
	}
	
	public static Teams toTeam(String team) {
		Teams retVal = NONE;
		if (team.equals("Red")) {
			retVal = Teams.RED;
		}
		else if (team.equals("Blue")) {
			retVal =  Teams.BLUE;
		}
		else if (team.equals("Green")) {
			retVal = Teams.GREEN;
		}
		else if (team.equals("None")) {
			retVal = Teams.NONE;
		}
		return retVal;
	}
}
