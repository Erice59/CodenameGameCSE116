package code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.*;

public class FileWordReader {
	//String fileName = "Data/GameWords.txt";
	//private List<String> wordList = new ArrayList<String>();

	/*
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
		return wordList;
	}

	/*
	 * Takes in a list of words and returns a randomized list. 
	 * @param list a list of words.
	 * @return A shuffled list of words from the given input.
	 */
	public List<String> ListRandomizer(List<String> list) {
		List<String> out = list;
		Collections.shuffle(out);
		return out;
	}

	/*
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
}
