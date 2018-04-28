package code;

public enum Teams {
	RED ("Red"),
	BLUE ("Blue"),
	GREEN ("Blue");
	
	private final String teamNames;
	
	Teams(String t) {
		this.teamNames = t;
	}
	
	public String getTeam() {
		return this.teamNames;
	}
}
