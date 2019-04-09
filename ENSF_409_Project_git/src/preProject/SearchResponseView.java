package preProject;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Window which displays the result of the student record search
 * 
 * @author Aaron Dalik
 * @version 1.0
 * @since 03/29/19
 *
 */
public class SearchResponseView extends JFrame {

	/**
	 * The result of the search
	 */
	private JLabel theResponse = new JLabel();
	
	/**
	 * The button that closes the window
	 */
	private JButton okButton = new JButton("OK");
	
	/**
	 * Creates a SearchResponseView and its constituent panels
	 */
	public SearchResponseView() {
		JPanel buttonPanel = new JPanel();
		JPanel textPanel = new JPanel();
		//JPanel p = new JPanel();
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		//buttonPanel.add("West", cancelButton);
		buttonPanel.add("East", okButton);
		
		//textPanel.add("North", theResponse);
		textPanel.add("Center", theResponse);
		textPanel.add("South", buttonPanel);
		
		add("Center", textPanel);
	}
	
	/**
	 * Sets the label that displays the result of the search
	 * @param s the result of the search
	 */
	public void setResponse(String s) {
		theResponse.setText(s);
	}
	
	/**
	 * Adds an ActionListener to the "OK" button
	 * @param a ActionListener to be added to the "OK" button
	 */
	public void addOKListener(ActionListener a) {
		okButton.addActionListener(a);
	}
}
