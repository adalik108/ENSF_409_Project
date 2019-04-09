package preProject;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Window in which the user enters the name of the file which contains the student records
 * 
 * @author Aaron Dalik
 * @version 1.0
 * @since 03/29/19
 *
 */

public class FileInputView extends JFrame{

	/**
	 * A prompt to enter the name of the file
	 */
	private JLabel instruction = new JLabel("Enter the file name:");
	
	/**
	 * User input field for the name of the file
	 */
	private JTextField input = new JTextField(15);
	
	/**
	 * The button which causes the input to be read by the system
	 */
	private JButton okButton = new JButton("OK");
	
	/**
	 * The button which closes the window
	 */
	private JButton cancelButton = new JButton("Cancel");
	
	
	/**
	 * Creates a FileInputView
	 */
	public FileInputView() {
		
		JPanel textPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JPanel p = new JPanel();
		
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		buttonPanel.add("West", cancelButton);
		buttonPanel.add("East", okButton);
		textPanel.add("North", instruction);
		textPanel.add("Center", input);
		
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
	
	public String getInput() {
		return input.getText();
	}
	
	/**
	 * Clears the text in the user input area
	 */
	public void resetText() {
		input.setText("");
	}

}
