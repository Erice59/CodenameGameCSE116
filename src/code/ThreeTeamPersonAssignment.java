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
	private List<PeopleTypes> personList;

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
		List<PeopleTypes> retList = new ArrayList<PeopleTypes>();
		
		for (int i = 0; i < 6; i++) {
			retList.add(PeopleTypes.Red);
		}
		for (int i = 0; i < 5; i++) {
			retList.add(PeopleTypes.Blue);
		}
		retList.add(PeopleTypes.Assassin);
		for (int i = 0; i < 5; i++) {
			retList.add(PeopleTypes.Green);
		}
		for (int i = 0; i < 7; i++) {
			retList.add(PeopleTypes.Bystander);
		}
		retList.add(PeopleTypes.Assassin);
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
	public List<PeopleTypes> getPersonList() {
		return personList;
	}
	/**
	 * Sets personList to another list if needed.
	 * @param retList a List of person types.
	 */
	public void setPersonList(List<PeopleTypes> retList) {
		this.personList = retList;
	}
}