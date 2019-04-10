package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import model.Tool;

/**
 * The main window for the GUI
 * @author Aaron Dalik
 *
 */
public class MainWindow extends JFrame{
	
	private AddWindow addWindow  = new AddWindow();

	private JLabel searchLabel = new JLabel("Search");
	private JLabel nameLabel = new JLabel("Name:");
	private JLabel idLabel = new JLabel("ID Number:");
	
	private JTextField nameInput = new JTextField(10);
	private JTextField idInput = new JTextField(10);
	private JTextField changeInput = new JTextField(10);
	
	private JButton addButton = new JButton("Add Tool");
	private JButton removeButton = new JButton("Remove Tool");
	private JButton changeButton = new JButton("Change Quantity");
	private JButton searchButton = new JButton("Search");
	private JButton allButton = new JButton("All Tools");
	private JButton quantButton = new JButton("Tool Quantities");
	
	//private JTextArea display = new JTextArea();
	
	private JList<String> display = new JList<String>();
	
	public MainWindow() {
		
		JPanel searchPanel = new JPanel();
		JPanel editButtonPanel = new JPanel();
		JPanel displayButtonPanel = new JPanel();
		JPanel displayPanel = new JPanel();
		JPanel searchInputPanel = new JPanel();
		JPanel nameSearchPanel = new JPanel();
		JPanel idSearchPanel = new JPanel();
		JPanel westPanel = new JPanel();
		JPanel changePanel = new JPanel();
		JScrollPane textPanel = new JScrollPane(display);
		
		setSize(550, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//display.font
		
		//display.setEditable(false);
		
//		nameSearchPanel.add("West", nameLabel);
//		nameSearchPanel.add("East", nameInput);
//		
//		idSearchPanel.add("West", idLabel);
//		idSearchPanel.add("East", idInput);
//		
//		searchInputPanel.add("North", searchLabel);
//		searchInputPanel.add("Center", nameSearchPanel);
//		searchInputPanel.add("South", idSearchPanel);
//		
//		
//		searchPanel.add("Center", searchInputPanel);
//		searchPanel.add("South", searchButton);
//		
//		searchPanel.setSize(200, 200);
//		
//		add("Center", searchPanel);
		
		nameSearchPanel.add(nameLabel, BorderLayout.LINE_START);
		nameSearchPanel.add(nameInput, BorderLayout.LINE_END);
		
		idSearchPanel.add(idLabel, BorderLayout.LINE_START);
		idSearchPanel.add(idInput, BorderLayout.LINE_END);
		
		searchInputPanel.setLayout(new BoxLayout(searchInputPanel, BoxLayout.PAGE_AXIS));
		searchInputPanel.setAlignmentX(LEFT_ALIGNMENT);
		searchInputPanel.add(nameSearchPanel);
		searchInputPanel.add(idSearchPanel);
		
		searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.PAGE_AXIS));
		searchPanel.add(searchLabel);
		searchPanel.add(searchInputPanel);
		searchPanel.add(searchButton);
		//searchPanel.setPreferredSize(new Dimension(200, 100));
		
//		changePanel.setLayout(new BoxLayout(changePanel, BoxLayout.LINE_AXIS));
		changePanel.setLayout(new BoxLayout(changePanel, BoxLayout.PAGE_AXIS));
		changePanel.add(changeInput);
		changePanel.add(changeButton);
		//changePanel.
		//changePanel.pack();
		
		editButtonPanel.setLayout(new BoxLayout(editButtonPanel, BoxLayout.PAGE_AXIS));
		editButtonPanel.add(addButton);
		editButtonPanel.add(removeButton);
		//editButtonPanel.add(changePanel);
		
		westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.PAGE_AXIS));
		westPanel.setAlignmentX(LEFT_ALIGNMENT);
		westPanel.add(searchPanel);
		westPanel.add(editButtonPanel);
		westPanel.add(changePanel);
		//westPanel.add(changeButton);
		
		displayButtonPanel.setLayout(new BoxLayout(displayButtonPanel, BoxLayout.LINE_AXIS));
		displayButtonPanel.add(allButton);
		displayButtonPanel.add(quantButton);
		//displayButtonPanel.add(changePanel);
		
		displayPanel.add(textPanel, BorderLayout.CENTER);
		//displayPanel.add(changePanel, BorderLayout.PAGE_END);

		//searchPanel.setSize(200, 200);
		
		add(westPanel, BorderLayout.LINE_START);
		//add(displayPanel, BorderLayout.CENTER);
		add(textPanel, BorderLayout.CENTER);
		add(displayButtonPanel, BorderLayout.PAGE_END);
		//pack();
		
		
		
	}
	
	/**
	 * Adds an ActionListener to the add button
	 * @param a the ActionListener for the add button
	 */
	public void addAddListener(ActionListener a) {
		addButton.addActionListener(a);
	}
	
	/**
	 * Adds an ActionListener to the remove button
	 * @param a the ActionListener for the remove button
	 */
	public void addRemoveListener(ActionListener a) {
		removeButton.addActionListener(a);
	}
	
	/**
	 * Adds an ActionListener to the change button
	 * @param a the ActionListener for the change button
	 */
	public void addChangeListener(ActionListener a) {
		changeButton.addActionListener(a);
	}
	
	/**
	 * Adds an ActionListener to the all button
	 * @param a the ActionListener for the all button
	 */
	public void addAllListener(ActionListener a) {
		allButton.addActionListener(a);
	}
	
	/**
	 * Adds an ActionListener to the quantity button
	 * @param a the ActionListener for the quantity button
	 */
	public void addQuantListener(ActionListener a) {
		quantButton.addActionListener(a);
	}
	
	/**
	 * Adds an ActionListener to the search button
	 * @param a the ActionListener for the search button
	 */
	public void addSearchListener(ActionListener a) {
		searchButton.addActionListener(a);
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
	
	public String getSearchInput() {
		return (nameInput.getText() + "\n" + idInput.getText());
	}
	
//	public void setDisplay(String s) {
//		display.setText(s);
//	}
	
	/**
	 * Causes the given Tools to be displayed on the GUI
	 * @param t the tools to be displayed
	 */
	public void setDisplay(String[] s) {
		display.setListData(s);
		
	}
	
	/**
	 * Returns the add window
	 * @return the add window
	 */
	public AddWindow getAddWindow() {
		return addWindow;
	}
	
	/**
	 * Set the add window to be visible or not
	 * @param b if ture the window is set to be visible, if false it is set to not visible
	 */
	public void setAddVisible(boolean b) {
		addWindow.setVisible(b);
	}
	
	public int getSelectedIndex() {
		//int a = display.getSelectedIndex();
		return display.getSelectedIndex();
		//return a;
	}
	
	public int getChangeInput() {
		return Integer.parseInt(changeInput.getText());
	}
	
	public static void main(String[] args) {
		MainWindow theWindow = new MainWindow();
		theWindow.setVisible(true);
	}
	
}
