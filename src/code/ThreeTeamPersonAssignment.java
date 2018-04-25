package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ThreeTeamPersonAssignment {
	/**
	 * This is a helper class that is used to create a shuffled list of the different people assigned to locations for a three team game.
	 * 
	 * @author Eric Weinman
	 *
	 */

	/**
	 * personList is the shuffled list of people that can be assigned to locations.
	 */
	private List<String> personList;

	/**
	 * PersonHelper constructor.
	 */
	public ThreeTeamPersonAssignment() {
		setup();
	}


	/**
	 * Creates a List of the 25 people and randomizes that list. Sets that list equal to personList.
	 */
	public void setup() {
		List<String> retList = new ArrayList<String>();
		for (int i = 0; i < 6; i++) {
			retList.add("Red");
		}
		for (int i = 0; i < 5; i++) {
			retList.add("Blue");
		}
		for (int i = 0; i < 5; i++) {
			retList.add("Green");
		}
		for (int i = 0; i < 7; i++) {
			retList.add("Bystander");
		}
		for (int i = 0; i < 2; i++) {
			retList.add("Assassin");
		}
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