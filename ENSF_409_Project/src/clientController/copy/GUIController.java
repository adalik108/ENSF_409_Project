package clientController.copy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUIController {

	protected JFrame theView;
	protected CommControl theCom;
	
	public GUIController(JFrame view, CommControl com) {
		theView = view;
		theCom = com;
	}
	
	/**
	 * Listener for a button
	 * Contains a blank function that is to be overwritten
	 * @author Aaron Dalik
	 *
	 */
	protected class Button1Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			button1();
		}
		
	}
	
	/**
	 * Listener for a button
	 * Contains a blank function that is to be overwritten
	 * @author Aaron Dalik
	 *
	 */
	protected class Button2Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			button2();
		}
		
	}
	
	/**
	 * Listener for a button
	 * Contains a blank function that is to be overwritten
	 * @author Aaron Dalik
	 *
	 */
	protected class Button3Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			button3();
		}
		
	}
	
	/**
	 * Listener for a button
	 * Contains a blank function that is to be overwritten
	 * @author Aaron Dalik
	 *
	 */
	protected class Button4Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			button4();
		}
		
	}
	
	/**
	 * Listener for a button
	 * Contains a blank function that is to be overwritten
	 * @author Aaron Dalik
	 *
	 */
	protected class Button5Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			button5();
		}
		
	}
	
	/**
	 * Listener for a button
	 * Contains a blank function that is to be overwritten
	 * @author Aaron Dalik
	 *
	 */
	protected class Button6Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			button6();
		}
		
	}
	
	/**
	 * Listener for a cancel button
	 * Contains a function that closes the window that contains the button
	 * @author Aaron Dalik
	 *
	 */
	protected class CancelButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			cancelButton();
		}
		
	}

	/**
	 * Function for button 1 that shall be overwritten
	 */
	public void button1() {
		return;
	}

	/**
	 * Function for button 2 that shall be overwritten
	 */
	public void button2() {
		return;
	}
	
	/**
	 * Function for button 3 that shall be overwritten
	 */
	public void button3() {
		return;
	}
	
	/**
	 * Function for button 4 that shall be overwritten
	 */
	public void button4() {
		return;
	}
	
	/**
	 * Function for button 5 that shall be overwritten
	 */
	public void button5() {
		return;
	}
	
	/**
	 * Function for button 6 that shall be overwritten
	 */
	public void button6() {
		return;
	}
	
	/**
	 * Closes the window that contains the button
	 */
	public void cancelButton() {
		theView.setVisible(false);
	}
}
