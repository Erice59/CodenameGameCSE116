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

}
