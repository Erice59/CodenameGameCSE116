package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import org.junit.Before;
import org.junit.Test;

import code.FileWordReader;

public class FileWordReaderTest {

	String wordTestCase = "Data/WordTestCase.txt";
	String gameWords1 = "Data/GameWords1.txt";
	String gameWords2 = "Data/GameWords2.txt";
	String duplicates = "Data/DuplicateWords.txt";

	@Before
	public void init() {



	}

	@Test
	public void FileWordReaderTest1() {

		List<String> testList = new ArrayList<String>();
		testList.add("ARM");
		testList.add("BED");
		testList.add("EDGE");
		testList.add("TOFU");
		testList.add("ZEBRA");
		FileWordReader test = new FileWordReader();
		List<String> returnVal = test.ListCreator(wordTestCase);
		assertEquals(testList, returnVal);
	}

	@Test
	public void FileWordRandomizerTest1() {
		List<String> testList = new ArrayList<String>();
		testList.add("ARM");
		testList.add("BED");
		testList.add("EDGE");
		testList.add("TOFU");
		testList.add("ZEBRA");
		FileWordReader test = new FileWordReader();
		List<String> retVal = test.ListCreator("Data/WordTestCase.txt");
		List<String> randList = test.ListRandomizer(retVal);
		assertEquals(testList.size(), randList.size());
		assertNotEquals(testList, randList);
		Collections.sort(randList);
		assertEquals(testList, randList);
	}

	@Test
	public void CodeNameSelectorTest1() {
		List<String> testList = new ArrayList<String>();
		testList.add("ARM");
		testList.add("BED");
		testList.add("EDGE");
		testList.add("TOFU");
		testList.add("ZEBRA");
		FileWordReader test = new FileWordReader();
		List<String> retVal = test.ListCreator("Data/WordTestCase.txt");
		List<String> randList = test.ListRandomizer(retVal);
		List<String> selectedList = test.CodeNameSelector(randList);
		assertEquals(testList.size(), selectedList.size());
		assertEquals(5.0, selectedList.size(), 0.001);
	}

	@Test
	public void FileWordRandomizerTest2() throws IOException {
		List<String> testList = Files.readAllLines(Paths.get(gameWords1));
		FileWordReader test = new FileWordReader();
		List<String> retVal = test.ListCreator(gameWords1);
		List<String> randList = test.ListRandomizer(retVal);
		Collections.sort(testList);
		Collections.sort(randList);
		assertEquals(testList, randList);
	}

	@Test
	public void CodeNameSelectorTest2() throws IOException {
		List<String> testList = Files.readAllLines(Paths.get(gameWords1));
		FileWordReader test = new FileWordReader();
		List<String> retVal = test.ListCreator(gameWords1);
		List<String> randList = test.ListRandomizer(retVal);
		List<String> selectedList = test.CodeNameSelector(randList);
		assertEquals(25.0, selectedList.size(), 0.001);
		assertNotEquals(testList.size(), selectedList.size());

	}
	
	@Test
	public void NonValidFile() {
		FileWordReader test = new FileWordReader("Data/null.txt");
		assertEquals(test.getCodeNamesList(), new ArrayList<String>());
	}
	
	@Test
	public void CodeNameSelectorMultiple() {
		FileWordReader test = new FileWordReader(duplicates);
		List<String> selectedList = test.getCodeNamesList();
		//selectedList.add("Fun");
		//selectedList.add("Fun");
		Set<String> occur = new HashSet<String>(selectedList);
		boolean multiple = false;
		for (String s : occur) {
			if (Collections.frequency(selectedList, s) > 1) {
				multiple = true;
			}
		}
		assertEquals(false, multiple);
	}
	
	@Test
	public void codenameList() {
		FileWordReader test = new FileWordReader();
		List<String> masterList = new ArrayList<String>(Arrays.asList("area", "book", "business", "case", "child", "company", "country", "day", "eye", "fact", "family", "government", "group", "hand", "home", "job", "life", "lot", "man", "money", "month", "mother", "Mr", "night", "number", "part", "people", "place", "point", "problem", "program", "question", "right", "room", "school", "state", "story", "student", "study", "system", "thing", "time", "water", "way", "week", "woman", "word", "work", "world", "year"));
		List<String> testList = test.ListCreator(gameWords2);
		assertEquals(50, masterList.size());
		assertEquals(masterList.size(), testList.size());
		assertEquals(masterList, testList);
	}
	
	@Test
	public void testRandom() {
		FileWordReader reader1 = new FileWordReader();
		FileWordReader reader2 = new FileWordReader();
		List<String> creator1 = reader1.ListCreator(gameWords1);
		List<String> creator2 = reader2.ListCreator(gameWords1);
		List<String> selector1 = reader1.CodeNameSelector(creator1);
		List<String> selector2 = reader2.CodeNameSelector(creator2);
		assertEquals(25, selector1.size());
		assertEquals(25, selector2.size());
		assertEquals(selector1.size(), selector2.size());
		assertNotEquals(selector1, selector2);
		Collections.sort(selector1);
		Collections.sort(selector2);
		assertNotEquals(selector1, selector2);
	}

}
