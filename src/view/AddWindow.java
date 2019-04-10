package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * The add window for the GUI
 * @author Aaron Dalik
 *
 */

public class AddWindow extends JFrame{

	private JLabel titleLabel = new JLabel("Add a New Tool");
	private JLabel idLabel = new JLabel("Tool ID Number:");
	private JLabel nameLabel = new JLabel("Tool Name:");
	private JLabel quantLabel = new JLabel("Tool Quantity:");
	private JLabel priceLabel = new JLabel("Tool Price:");
	private JLabel supLabel = new JLabel("Supplier ID:");
	
	private JTextField nameInput = new JTextField(10);
	private JTextField idInput = new JTextField(10);
	private JTextField quantInput = new JTextField(10);
	private JTextField priceInput = new JTextField(10);
	private JTextField supInput = new JTextField(10);
	
	private JButton addButton = new JButton("Add Tool");
	private JButton cancelButton = new JButton("Cancel");
	
	public AddWindow() {
		
		JPanel idPanel = new JPanel();
		idPanel.setLayout(new BoxLayout(idPanel, BoxLayout.LINE_AXIS));
		idPanel.add(idLabel);
		idPanel.add(idInput);
		
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.LINE_AXIS));
		namePanel.add(nameLabel);
		namePanel.add(nameInput);
		
		JPanel quantPanel = new JPanel();
		quantPanel.setLayout(new BoxLayout(quantPanel, BoxLayout.LINE_AXIS));
		quantPanel.add(quantLabel);
		quantPanel.add(quantInput);
		
		JPanel pricePanel = new JPanel();
		pricePanel.setLayout(new BoxLayout(pricePanel, BoxLayout.LINE_AXIS));
		pricePanel.add(priceLabel);
		pricePanel.add(priceInput);
		
		JPanel supPanel = new JPanel();
		supPanel.setLayout(new BoxLayout(supPanel, BoxLayout.LINE_AXIS));
		supPanel.add(supLabel);
		supPanel.add(supInput);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
		buttonPanel.add(addButton);
		buttonPanel.add(cancelButton);
		
//		JPanel searchInputPanel = new JPanel();
//		JPanel idSearchPanel = new JPanel();
//		JPanel westPanel = new JPanel();
//		JScrollPane textPanel = new JScrollPane(display);
		
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel addPanel = new JPanel();
		addPanel.setLayout(new BoxLayout(addPanel, BoxLayout.PAGE_AXIS));
		
		
		addPanel.add(titleLabel);	
		addPanel.add(idPanel);
		addPanel.add(namePanel);
		addPanel.add(quantPanel);
		addPanel.add(pricePanel);
		addPanel.add(supPanel);
		addPanel.add(buttonPanel);
		//pack();
		add(addPanel, BorderLayout.CENTER);
		
		
		
	}
		
	/**
	 * Adds an ActionListener to the add button
	 * @param a the ActionListener for the add button
	 */
	public void addAddListener(ActionListener a) {
		addButton.addActionListener(a);
	}
	
	/**
	 * Adds an ActionListener to the cancel button
	 * @param a the ActionListener for the cancel button
	 */
	public void addCancelListener(ActionListener a) {
		cancelButton.addActionListener(a);
	}
	
	/**
	 * Returns the user input to the Name field
	 * @param a the user input to the Name field
	 */
	public String getNameInput() {
		return nameInput.getText();
	}
	
	/**
	 * Returns the user input to the id field
	 * @param a the user input to the id field
	 */
	public String getIdInput() {
		return idInput.getText();
	}
	
	public String getInput() {
		return (idInput.getText() + ";" + nameInput.getText() + ";" + quantInput.getText() + ";" + priceInput.getText() + ";" + supInput.getText());
	}
	
	
	public static void main(String[] args) {
		AddWindow theWindow = new AddWindow();
		theWindow.setVisible(true);
	}
	
}
