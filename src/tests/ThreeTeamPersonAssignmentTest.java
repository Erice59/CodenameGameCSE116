package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import code.PeopleTypes;
import code.PersonHelper;
import code.ThreeTeamPersonAssignment;

public class ThreeTeamPersonAssignmentTest {

	@Test
	public void testCorrectList() {
		//List<String> persons = new ArrayList<String>(Arrays.asList("Assassin", "Assassin", "Blue", "Blue", "Blue", "Blue", "Blue", "Bystander", "Bystander", "Bystander", "Bystander", "Bystander", "Bystander", "Bystander",  "Green", "Green", "Green", "Green", "Green", "Red", "Red", "Red", "Red", "Red", "Red"));
		List<PeopleTypes> persons = new ArrayList<PeopleTypes>(Arrays.asList(PeopleTypes.Assassin, PeopleTypes.Assassin, PeopleTypes.Blue, PeopleTypes.Blue, PeopleTypes.Blue, PeopleTypes.Blue, PeopleTypes.Blue, PeopleTypes.Bystander, PeopleTypes.Bystander, PeopleTypes.Bystander, PeopleTypes.Bystander, PeopleTypes.Bystander, PeopleTypes.Bystander, PeopleTypes.Bystander,  PeopleTypes.Green, PeopleTypes.Green, PeopleTypes.Green, PeopleTypes.Green, PeopleTypes.Green, PeopleTypes.Red, PeopleTypes.Red, PeopleTypes.Red, PeopleTypes.Red, PeopleTypes.Red, PeopleTypes.Red));
		ThreeTeamPersonAssignment test = new ThreeTeamPersonAssignment();
		test.setup();
		List<PeopleTypes> tested = test.getPersonList();
		Collections.sort(persons);
		Collections.sort(tested);
		assertEquals(25, tested.size());
		assertEquals(persons, tested);

	}
	
	@Test
	public void testRandom() {
		//List<String> persons = new ArrayList<String>(Arrays.asList("Assassin", "Assassin", "Blue", "Blue", "Blue", "Blue", "Blue", "Bystander", "Bystander", "Bystander", "Bystander", "Bystander", "Bystander", "Bystander",  "Green", "Green", "Green", "Green", "Green", "Red", "Red", "Red", "Red", "Red", "Red"));
		List<PeopleTypes> persons = new ArrayList<PeopleTypes>(Arrays.asList(PeopleTypes.Assassin, PeopleTypes.Assassin, PeopleTypes.Blue, PeopleTypes.Blue, PeopleTypes.Blue, PeopleTypes.Blue, PeopleTypes.Blue, PeopleTypes.Bystander, PeopleTypes.Bystander, PeopleTypes.Bystander, PeopleTypes.Bystander, PeopleTypes.Bystander, PeopleTypes.Bystander, PeopleTypes.Bystander,  PeopleTypes.Green, PeopleTypes.Green, PeopleTypes.Green, PeopleTypes.Green, PeopleTypes.Green, PeopleTypes.Red, PeopleTypes.Red, PeopleTypes.Red, PeopleTypes.Red, PeopleTypes.Red, PeopleTypes.Red));
		ThreeTeamPersonAssignment personA1 = new ThreeTeamPersonAssignment();
		ThreeTeamPersonAssignment personA2 = new ThreeTeamPersonAssignment();
		personA1.setup();
		personA2.setup();
		List<PeopleTypes> pH1 = personA1.getPersonList();
		List<PeopleTypes> pH2 = personA2.getPersonList();
		assertNotEquals(pH1, pH2);
		assertNotEquals(persons, pH1);
		assertNotEquals(persons, pH2);
		Collections.sort(persons);
		Collections.sort(pH1);
		Collections.sort(pH2);
		System.out.println(persons);
		System.out.println(pH1);
		assertEquals(pH1, pH2);
		assertEquals(persons, pH1);
		assertEquals(persons, pH2);
	}	
}
