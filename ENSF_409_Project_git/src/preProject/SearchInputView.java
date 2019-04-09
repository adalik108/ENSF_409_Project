package preProject;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Window in which the user enters the id number of a student they wish to search for
 * 
 * @author Aaron Dalik
 * @version 1.0
 * @since 03/29/19
 *
 */

public class SearchInputView extends JFrame {

	/**
	 * The title of the window
	 */
	private JLabel title = new JLabel("Please enter the student's id");
	
	/**
	 * The user input field for student id
	 */
	private JTextField idInput = new JTextField(10);
	
	/**
	 * The button which causes the input to be read by the system
	 */
	private JButton okButton = new JButton("OK");
	
	/**
	 * The button which closes the window
	 */
	private JButton cancelButton = new JButton("Cancel");
	
	
	/**
	 * Creates a SearchInputView
	 */
	public SearchInputView() {
		JPanel buttonPanel = new JPanel();
		JPanel textPanel = new JPanel();
		//JPanel p = new JPanel();
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		buttonPanel.add("West", cancelButton);
		buttonPanel.add("East", okButton);
		
		textPanel.add("North", title);
		textPanel.add("Center", idInput);
		textPanel.add("South", buttonPanel);
		
		add("Center", textPanel);
		
		
	}
	
	/**
	 * Adds an ActionListener to the "OK" button
	 * @param a ActionListener to be added to the "OK" button
	 */
	public void addOKListener(ActionListener a) {
		okButton.addActionListener(a);
	}
	
	/**
	 * Adds an ActionListener to the "Cancel" button
	 * @param a ActionListener to be added to the "Cancel" button
	 */
	public void addCancelListener(ActionListener a) {
		cancelButton.addActionListener(a);
	}
	
	/**
	 * Returns the user's input for student id
	 * @return the user's input for student id
	 */
	public String getIdInput() {
		return idInput.getText();
	}
	
	/**
	 * Erases the text in the user input area
	 */
	public void resetText() {
		idInput.setText("");
	}
	
}
