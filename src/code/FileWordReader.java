package code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.*;

/**
 * Class that given a text document of words will convert the document into a list of words, and then shorten the list down to 25 words
 * and randomize those words.
 * 
 * @author Eric Weinman
 *
 */

public class FileWordReader {
	/**
	 * Instance variable containing a list of all the codenames or words read in from the file.
	 */
	private List<String> initialList;
	/**
	 * Instance variable containing a list of the final and randomized 25 codenames from the given file.
	 */
	private List<String> finalList;
	/**
	 * Instance variable containing the intermediate list in the state a method last performed on it.
	 */
	private List<String> workingList;
	/**
	 * Default constructor
	 */
	public FileWordReader() {
		
	}
	/**
	 * Constructor with parameter of file that contains words for codename use. Constructor will read in the
	 * file and shuffle and shorten it to 25 codenames and store it in the finalList variable.
	 * @param fileName The file to be used to create the list of codenames
	 */
	public FileWordReader(String fileName) {
		
		this.finalList = CodeNameSelector(ListCreator(fileName));
	}

	/**
	 * Takes in a text file consisting of one word per line and stores them in a list. 
	 * @param fileName Path location of text file
	 * @return A list consisting of each word from the document being an item
	 */
	public List<String> ListCreator(String fileName) {
		List<String> wordList = new ArrayList<String>();
		try {
			for (String line : Files.readAllLines(Paths.get(fileName))) {
				if (!wordList.contains(line)) {
					wordList.add(line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		initialList = wordList;
		workingList = wordList;
		return wordList;
	}

	/**
	 * Takes in a list of words and returns a randomized list. 
	 * @param list a list of words.
	 * @return A shuffled list of words from the given input.
	 */
	public List<String> ListRandomizer(List<String> list) {
		List<String> out = list;
		Collections.shuffle(out);
		return out;
	}

	/**
	 * Takes in a list containing one word per item, shuffles it, and returns a list.
	 * The list will be 25 elements if the given list is larger than 25, otherwise will return shuffled list that is the same size as input. 
	 * @param list a list of words.
	 * @return A shuffled list of 25 (or less) words.
	 */
	public List<String> CodeNameSelector(List<String> list) {
		List<String> in = ListRandomizer(list);
		List<String> out = new ArrayList<String>();
		if (in.size() > 25) {
			for (int i = 1; i < 26; i++) {
				out.add(in.get(i));
			}
		}
		else {
			for (String s : in) {
				out.add(s);
			}
		}
		return out;
	}
	
	/**
	 * @return List of codenames.
	 */
	public List<String> getCodeNamesList() {
		return finalList;
	}
	/**
	 * @return The working list in the last modified state.
	 */
	public List<String> getWorkingList() {
		return workingList;
	}
	/**
	 * @return The initial list of all the words from the given file.
	 */
	public List<String> getInitialList() {
		return initialList;
	}
	
}
