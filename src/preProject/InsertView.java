package preProject;

import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Window in which the user enters the info of a new student that is to be added to theTree
 * 
 * @author Aaron Dalik
 * @version 1.0
 * @since 03/29/19
 *
 */

public class InsertView extends JFrame{
	
	/**
	 * The title of the window
	 */
	private JLabel titleLabel = new JLabel("Insert a New Node");
	
	/**
	 * Label which indicates where the student's id is to be entered
	 */
	private JLabel idLabel = new JLabel("Enter the Student ID");
	
	/**
	 * Label which indicates where the student's faculty is to be entered
	 */
	private JLabel facultyLabel = new JLabel("Enter Faculty");
	
	/**
	 * Label which indicates where the student's major is to be entered
	 */
	private JLabel majorLabel = new JLabel("Enter Student's Major");
	
	/**
	 * Label which indicates where the student's year is to be entered
	 */

	private JLabel yearLabel = new JLabel("Enter year");
	
	
	/**
	 * User input field for students's id
	 */
	private JTextField idField = new JTextField(10);
	
	/**
	 * User input field for students's faculty
	 */
	private JTextField facultyField = new JTextField(10);
	
	/**
	 * User input field for students's major
	 */
	private JTextField majorField = new JTextField(10);
	
	/**
	 * User input field for students's year
	 */
	private JTextField yearField = new JTextField(10);
	
	/**
	 * The button which causes the inputs to be read by the system
	 */
	private JButton insertButton = new JButton("Insert");
	
	/**
	 * The button which closes the window
	 */
	private JButton returnButton = new JButton("Return to Main Window");
			
	/**
	 * Creates an InsertView
	 */
	public InsertView() {
		JPanel textFrame = new JPanel();
		JPanel buttonFrame = new JPanel();
		JPanel textMiddleFrame = new JPanel();
		JPanel textBottomFrame = new JPanel();
		JPanel idFrame = new JPanel();
		JPanel facultyFrame = new JPanel();
		JPanel majorFrame = new JPanel();
		JPanel yearFrame = new JPanel();
		
		setSize(500, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		idFrame.add("West", idLabel);
		idFrame.add("East", idField);
		
		facultyFrame.add("West", facultyLabel);
		facultyFrame.add("East", facultyField);
		
		majorFrame.add("West", majorLabel);
		majorFrame.add("East", majorField);
		
		yearFrame.add("West", yearLabel);
		yearFrame.add("East", yearField);
		
		textMiddleFrame.add("West", idFrame);
		textMiddleFrame.add("East", facultyFrame);
		
		textBottomFrame.add("West", majorFrame);
		textBottomFrame.add("East", yearFrame);
		
		textFrame.add("North", titleLabel);
		textFrame.add("Center", textMiddleFrame);
		textFrame.add("South", textBottomFrame);
		
		buttonFrame.add("West", insertButton);
		buttonFrame.add("East", returnButton);
		
		add("Center", textFrame);
		add("South", buttonFrame);
		
	}
	
	/**
	 * Adds an ActionListener to the "Insert" button
	 * @param a ActionListener to be added to the "Insert" button
	 */
	public void addInsertListener(ActionListener a) {
		insertButton.addActionListener(a);
	}
	
	/**
	 * Adds an ActionListener to the "Return to Main Window" button
	 * @param a ActionListener to be added to the "Return to Main Window" button
	 */
	public void addReturnListener(ActionListener a) {
		returnButton.addActionListener(a);
	}
	
	public String getId() {
		return idField.getText();
	}
	
	public String getFaculty() {
		return facultyField.getText();
	}
	
	public String getMajor() {
		return majorField.getText();
	}
	
	public String getYear() {
		return yearField.getText();
	}
	
	/**
	 * Clears the text in the user input field
	 */
	public void resetText() {
		facultyField.setText("");
		idField.setText("");
		majorField.setText("");
		yearField.setText("");
	}
}
