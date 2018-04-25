package tests;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import code.PersonHelper;

public class PersonHelperTest {

	@Test
	public void test1() {
		List<String> persons = new ArrayList<String>(Arrays.asList("Assassin", "Blue", "Blue", "Blue", "Blue", "Blue", "Blue", "Blue", "Blue", "Bystander", "Bystander", "Bystander", "Bystander", "Bystander", "Bystander", "Bystander", "Red", "Red", "Red", "Red", "Red", "Red", "Red", "Red", "Red"));
		PersonHelper test = new PersonHelper();
		test.setup();
		List<String> tested = test.getPersonList();
		Collections.sort(tested);
		assertEquals(25, tested.size());
		assertEquals(persons, tested);

	}
	
	@Test
	public void testRandom() {
		List<String> persons = new ArrayList<String>(Arrays.asList("Assassin", "Blue", "Blue", "Blue", "Blue", "Blue", "Blue", "Blue", "Blue", "Bystander", "Bystander", "Bystander", "Bystander", "Bystander", "Bystander", "Bystander", "Red", "Red", "Red", "Red", "Red", "Red", "Red", "Red", "Red"));
		PersonHelper personHelper1 = new PersonHelper();
		PersonHelper personHelper2 = new PersonHelper();
		personHelper1.setup();
		personHelper2.setup();
		List<String> pH1 = personHelper1.getPersonList();
		List<String> pH2 = personHelper2.getPersonList();
		assertNotEquals(pH1, pH2);
		assertNotEquals(persons, pH1);
		assertNotEquals(persons, pH2);
		Collections.sort(persons);
		Collections.sort(pH1);
		Collections.sort(pH2);
		assertEquals(pH1, pH2);
		assertEquals(persons, pH1);
		assertEquals(persons, pH2);
	}
}
