package preProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controls the GUI for the student record system
 * 
 * @author Aaron Dalik
 * @version 1.0
 * @since 03/29/19
 *
 */

public class SystemController {

	/**
	 * The main screen of the GUI
	 */
	private MainWindowView mainWindow;
	
	/**
	 * The screen in which the user enters the name of the file which contains the student records
	 */
	private FileInputView fileWindow;
	
	/**
	 * The screen in which the user enters the info of a new student that is to be added to theTree
	 */
	private InsertView insertWindow;
	
	/**
	 * The screen in which the user enters the id number of a student they wish to search for
	 */
	private SearchInputView searchInputWindow;
	
	/**
	 * The screen in which the user receives the result of their search
	 */
	private SearchResponseView searchResponseWindow;
	
	/**
	 * The system that manipulates and maintains the student info
	 */
	private SystemModel theModel;
	
	/**
	 * Creates a SystemController and initializes all the windows
	 * @param mainWindow
	 * @param fileWindow
	 * @param insertWindow
	 * @param searchInputWindow
	 * @param searchResponseWindow
	 * @param theModel
	 */
	public SystemController(MainWindowView mainWindow, FileInputView fileWindow,
			InsertView insertWindow, SearchInputView searchInputWindow, SearchResponseView searchResponseWindow, SystemModel theModel) {
		this.mainWindow = mainWindow;
		this.fileWindow = fileWindow;
		this.insertWindow = insertWindow;
		this.searchInputWindow = searchInputWindow;
		this.searchResponseWindow = searchResponseWindow;
		this.theModel = theModel;
		
		mainWindow.addCreateTreeListener(new MainCreateTreeListener());
		mainWindow.addInsertListener(new MainInsertListener());
		mainWindow.addFindListener(new MainFindListener());
		mainWindow.addBrowseListener(new MainBrowseListener());
		
		fileWindow.addCancelListener(new FileCancelListener());
		fileWindow.addOKListener(new FileOKListener());
		
		insertWindow.addReturnListener(new InsertReturnListener());
		insertWindow.addInsertListener(new InsertListener());
		
		searchInputWindow.addCancelListener(new SearchInputCancelListener());
		searchInputWindow.addOKListener(new SearchInputOKListener());
		
		searchResponseWindow.addOKListener(new SearchResponseOKListener());
		
		
	}
	
//	public SystemController() {
//		
//	}
	/**
	 * Listener for the "Create Tree From File" button on the mainWindow
	 * @author Aaron Dalik
	 *
	 */
	class MainCreateTreeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			fileWindow.resetText();
			fileWindow.setVisible(true);
		}
		
	}
	
	/**
	 * Listener for the "Insert" button on the mainWindow
	 * @author Aaron Dalik
	 *
	 */
	class MainInsertListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			insertWindow.resetText();
			insertWindow.setVisible(true);
		}
		
	}
	
	/**
	 * Listener for the "Find" button on the mainWindow
	 * @author Aaron Dalik
	 *
	 */
	class MainFindListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			searchInputWindow.resetText();
			searchInputWindow.setVisible(true);
		}
		
	}
	
	/**
	 * Listener for the "Browse" button on the mainWindow
	 * @author Aaron Dalik
	 *
	 */
	class MainBrowseListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			mainWindow.setText("");
			if(!theModel.treeEmpty())
				mainWindow.setText(theModel.printTree());
		}
		
	}
	
	/**
	 * Listener for the "OK" button on the FileInputWindow
	 * @author Aaron Dalik
	 *
	 */
	class FileOKListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			theModel.createTreeFromFile(fileWindow.getInput());	
			fileWindow.setVisible(false);
		}
		
	}
	
	/**
	 * Listener for the "Cancel" button on the FileInputWindow
	 * @author Aaron Dalik
	 *
	 */
	class FileCancelListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			fileWindow.setVisible(false);
			
		}
		
	}
	
	/**
	 * Listener for the "Return" button on the InsertWindow
	 * @author Aaron Dalik
	 *
	 */
	class InsertReturnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			insertWindow.setVisible(false);
			
		}
		
	}
	
	/**
	 * Listener for the "Insert" button on the InsertWindow
	 * @author Aaron Dalik
	 *
	 */
	class InsertListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String i = insertWindow.getId();
			String f = insertWindow.getFaculty();
			String m = insertWindow.getMajor();
			String y = insertWindow.getYear();
			theModel.insert(i, f, m, y);
			
			insertWindow.setVisible(false);
		}
		
	}
	
	/**
	 * Listener for the "Cancel" button on the SearchInputWindow
	 * @author Aaron Dalik
	 *
	 */
	class SearchInputCancelListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			searchInputWindow.setVisible(false);
			
		}
		
	}
	
	/**
	 * Listener for the "OK" button on the SearchInputWindow
	 * @author Aaron Dalik
	 *
	 */
	class SearchInputOKListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Data theData = theModel.search(searchInputWindow.getIdInput());
			if(theData == null)
				searchResponseWindow.setResponse("Sorry, this student does not exist.");
			
			else
				searchResponseWindow.setResponse(theData.toString());
			
			searchInputWindow.setVisible(false);
			searchResponseWindow.setVisible(true);
		}
		
	}
	
	/**
	 * Listener for the "OK" button on the SearchResponseWindow
	 * @author Aaron Dalik
	 *
	 */
	class SearchResponseOKListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			searchResponseWindow.setVisible(false);
			
		}
		
	}
	
//	public void setMainWindow(MainWindowView mainWindow) {
//		this.mainWindow = mainWindow;
//	}
//	
//	public void setFileWindow(FileInputView fileWindow) {
//		this.fileWindow = fileWindow;
//	}
//	
//	public void setInsertWindow(InsertView insertWindow) {
//		this.insertWindow = insertWindow;
//	}
//	
//	public void setSearchInputWindow(SearchInputView searchInputWindow) {
//		this.searchInputWindow = searchInputWindow;
//	}
	
	public static void main(String[] args) {
		MainWindowView mainView = new MainWindowView();
		FileInputView fileView = new FileInputView();
		InsertView insertView = new InsertView();
		SearchInputView searchInputView = new SearchInputView();
		SearchResponseView searchResponseWindow = new SearchResponseView();
		SystemModel theModel = new SystemModel();
		SystemController control = new SystemController(mainView, fileView, insertView, searchInputView, searchResponseWindow, theModel);
		mainView.setVisible(true);
	}
}
