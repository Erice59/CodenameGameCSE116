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

}
