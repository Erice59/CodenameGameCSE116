package code;

public enum PeopleTypes {

	Red ("Red Agent"),
	Blue ("Blue Agent"),
	Green ("Green Agent"),
	Bystander ("Innocent Bystander"),
	Assassin ("Assassin");
	
	private final String people;
	
	PeopleTypes(String t) {
		this.people = t;
	}
	
	public String getPeople() {
		return this.people;
	}
	
}
