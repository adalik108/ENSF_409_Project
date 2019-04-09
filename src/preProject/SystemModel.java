package preProject;

/**
 * Provides methods to implement and maintain a binary search tree of students.
 * 
 * @author Aaron Dalik
 * @version 1.0
 * @since 03/29/19
 *
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SystemModel {

	/**
	 * A binary search tree of students
	 */
	private BinSearchTree theTree;
	
	public SystemModel() {
		theTree = new BinSearchTree();
	}

	/**
	 * Creates a binary search tree from a given file
	 * @param fileName: the name of the file containing the student data
	 */
	void createTreeFromFile(String fileName) {
		try {
			BufferedReader theReader = new BufferedReader(new FileReader(fileName));
			String read;
			String[] data;
			read = theReader.readLine();
			while(read != null) {
				data = parseLine(read);
				theTree.insert(data[0], data[1], data[2], data[3]);
				read = theReader.readLine();
			}
			theReader.close();
		}catch(IOException e) {
			e.getStackTrace();
		}
	}
	
	/**
	 * Separates and returns the individual words in a String of 4 words
	 * @param line A String of 4 words
	 * @return An array of 4 Strings
	 */
	private String[] parseLine(String line) {
		String[] parsed = new String[4];
		String tempWord = "";
		
		for(int i = 0, j = 0; j < parsed.length; j++) {
			while(line.charAt(i) == ' ') {
				i++;
			}
			while(i < line.length() && line.charAt(i) != ' ') {
				tempWord += line.charAt(i++);
			}
			parsed[j] = tempWord;
			tempWord = "";
		}
		return parsed;
		
	}
	
	/**
	 * Returns the BinSearchTree
	 * @return the BinSearchTree
	 */
	public BinSearchTree getTree() {
		return theTree;
	}
	
	/**
	 * Inserts a new node containing student info into theTree
	 * @param i Id of student
	 * @param f faculty of student
	 * @param m major of student
	 * @param y year of student
	 */
	public void insert(String i, String f, String m, String y) {
		theTree.insert(i, f, m, y);
	}
	
	/**
	 * Finds the info of the student with the given id number
	 * @param id the id number of the student to be searched for
	 * @return the Data associatied with the student with the given id number
	 */
	public Data search(String id) {
		Node n = theTree.find(theTree.root, id);
		if(n != null)
			return n.data;
		return null;
	}
	
	/**
	 * Creates a single String containing all the student info in theTree
	 * @return a single String containing all the student info in theTree
	 */
	public String printTree() {
		return theTree.toString(theTree.root);
	}
	
	/**
	 * Determines if there is any student info in theTree
	 * @return true if theTree is empty, false otherwise
	 */
	public boolean treeEmpty() {
		return theTree.empty();
	}
}

