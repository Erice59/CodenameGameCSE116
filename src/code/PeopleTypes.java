package code;

public enum PeopleTypes {

	Assassin ("Assassin"),
	Blue ("Blue Agent"),
	Bystander ("Innocent Bystander"),
	Green ("Green Agent"),
	Red ("Red Agent");
	
	private final String people;
	
	PeopleTypes(String t) {
		this.people = t;
	}
	
	public String getPeople() {
		return this.people;
	}
	
}
