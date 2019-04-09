package preProject;

import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * The main window of the GUI
 * 
 * @author Aaron Dalik
 * @version 1.0
 * @since 03/29/19
 *
 */



public class MainWindowView extends JFrame{

	/**
	 * The title of the window
	 */
	private JLabel title = new JLabel("An Application to Maintain Student Records");
	
	/**
	 * Area which displays student info in theTree
	 */
	private JTextArea text = new JTextArea();
	
	/**
	 * The button which activates the Insert window
	 */
	private JButton insertButton = new JButton("Insert");
	
	/**
	 * The button which activates the Find window
	 */
	private JButton findButton = new JButton("Find");
	
	/**
	 * The button which activates the Browse window
	 */
	private JButton browseButton = new JButton("Browse");
	
	/**
	 * The button which activates the File window
	 */
	private JButton createTreeButton = new JButton("Create Tree From File");
	
	
	/**
	 * Creates a MainWindowView
	 */
	public MainWindowView() {
		JPanel buttonPanel = new JPanel ();
		JPanel leftButtonPanel = new JPanel();
		JPanel rightButtonPanel = new JPanel();
		JPanel titlePanel = new JPanel();
		//JPanel textPanel = new JPanel();
		JScrollPane textPanel = new JScrollPane(text);
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		titlePanel.add("Center", title);		
		leftButtonPanel.add("West", insertButton);
		leftButtonPanel.add("East", findButton);
		rightButtonPanel.add("West", browseButton);
		rightButtonPanel.add("East", createTreeButton);
		buttonPanel.add("West", leftButtonPanel);
		buttonPanel.add("East", rightButtonPanel);
		
		text.setEditable(false);
		
		//add("South", createTreeButton);
		this.add("South", buttonPanel);
		this.add("North", titlePanel);
		this.add("Center", textPanel);
		
		
	}
	
	/**
	 * Adds an ActionListener to the "Insert" button
	 * @param a ActionListener to be added to the "Insert" button
	 */
	public void addInsertListener(ActionListener a) {
		insertButton.addActionListener(a);
	}
	
	/**
	 * Adds an ActionListener to the "Find" button
	 * @param a ActionListener to be added to the "Find" button
	 */
	public void addFindListener(ActionListener a) {
		findButton.addActionListener(a);
	}
	
	/**
	 * Adds an ActionListener to the "Browse" button
	 * @param a ActionListener to be added to the "Browse" button
	 */
	public void addBrowseListener(ActionListener a) {
		browseButton.addActionListener(a);
	}
	
	/**
	 * Adds an ActionListener to the "CreateTree" button
	 * @param a ActionListener to be added to the "CreateTree" button
	 */
	public void addCreateTreeListener(ActionListener a) {
		createTreeButton.addActionListener(a);
	}
	
	/**
	 * Sets the text to the given String
	 * @param s the String to which text will be set
	 */
	public void setText(String s) {
		text.setText(s);
	}
	
}
