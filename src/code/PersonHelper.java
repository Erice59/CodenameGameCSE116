package code;

import java.util.*;

/**
 * This is a helper class that is used to create a shuffled list of the different people assigned to locations for a two team game.
 * 
 * @author Eric Weinman
 *
 */

public class PersonHelper {

	/**
	 * personList is the shuffled list of people that can be assigned to locations.
	 */
	private List<String> personList;

	/**
	 * PersonHelper constructor.
	 */
	public PersonHelper() {
		setup();
	}


	/**
	 * Creates a List of the 25 people and randomizes that list. Sets that list equal to personList.
	 */
	public void setup() {
		List<String> retList = new ArrayList<String>();
		for (int i = 0; i < 9; i++) {
			retList.add("Red");
		}
		for (int i = 0; i < 8; i++) {
			retList.add("Blue");
		}
		for (int i = 0; i < 7; i++) {
			retList.add("Bystander");
		}
		retList.add("Assassin");
		Collections.shuffle(retList);
		Collections.shuffle(retList, new Random());
		setPersonList(retList);
	}
	public void setupThree() {
		List<String> retList = new ArrayList<String>();
		for (int i = 0; i < 6; i++) {
			retList.add("Red");
		}
		for (int i = 0; i < 5; i++) {
			retList.add("Blue");
		}
		retList.add("Assassin");
		for (int i = 0; i < 5; i++) {
			retList.add("Green");
		}
		for (int i = 0; i < 7; i++) {
			retList.add("Bystander");
		}
		retList.add("Assassin");
		/*for (int i = 0; i < 2; i++) {
			retList.add(PeopleTypes.Assassin);
		}*/
		Collections.shuffle(retList);
		Collections.shuffle(retList, new Random());
		setPersonList(retList);
	}
	/**
	 * Returns personList.
	 * @return personList list.
	 */
	public List<String> getPersonList() {
		return personList;
	}
	/**
	 * Sets personList to another list if needed.
	 * @param personList a List of person types.
	 */
	public void setPersonList(List<String> personList) {
		this.personList = personList;
	}

}
