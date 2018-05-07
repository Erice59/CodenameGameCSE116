package code;

public enum Teams {
	Blue ("Blue"),
	Green ("Green"),
	None ("None"),
	Red ("Red");
	
	private final String teamNames;
	
	Teams(String t) {
		this.teamNames = t;
	}
	
	public String getTeam() {
		return this.teamNames;
	}
	
	public static Teams toTeam(String team) {
		Teams retVal = None;
		if (team.equals("Red")) {
			retVal = Teams.Red;
		}
		else if (team.equals("Blue")) {
			retVal =  Teams.Blue;
		}
		else if (team.equals("Green")) {
			retVal = Teams.Green;
		}
		else if (team.equals("None")) {
			retVal = Teams.None;
		}
		return retVal;
	}
}
