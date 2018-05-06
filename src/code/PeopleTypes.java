package code;

public enum PeopleTypes {

	Assassin ("Assassin"),
	Blue ("Blue Agent"),
	Bystander ("Innocent Bystander"),
	Green ("Green Agent"),
	Red ("Red Agent"),
	None ("None");
	
	private final String people;
	
	PeopleTypes(String t) {
		this.people = t;
	}
	
	public String getPeople() {
		return this.people;
	}
	
	public static PeopleTypes toPerson(String person) {
		PeopleTypes retVal = None;
		if (person.equals("Red")) {
			retVal = PeopleTypes.Red;
		}
		else if (person.equals("Blue")) {
			retVal = PeopleTypes.Blue;
		}
		else if (person.equals("Green")) {
			retVal = PeopleTypes.Green;
		}
		else if (person.equals("Assassin")) {
			retVal = PeopleTypes.Assassin;
		}
		else if (person.equals("Bystander")) {
			retVal = PeopleTypes.Bystander;
		}
		return retVal;
	}
}
