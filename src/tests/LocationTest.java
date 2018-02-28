package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Location;

public class LocationTest {

	@Test
	public void testDefaultConstructor() {
		Location test = new Location();
		assertEquals(false, test.is_revealed());
	}

	@Test
	public void testDefaultConstructorTwo() {
		Location test1 = new Location();
		test1.set_codename("Apple");
		test1.set_person("Blue");
		test1.set_id("01");

		Location test2 = new Location();
		test2.set_codename("Orange");
		test2.set_person("Red");
		test2.set_id("20");

		assertNotEquals(test1, test2);
		assertEquals(false, test1.is_revealed());
		test1.set_revealed(true);
		assertEquals(true, test1.is_revealed());
		assertEquals("Apple", test1.get_codename());
	}
	
	@Test
	public void testFullConstructor() {
		Location test = new Location("Red", "APPLE", "02");
		assertEquals("APPLE", test.get_codename());
		assertEquals("Red", test.get_person());
		assertEquals("02", test.get_id());
	}

}
