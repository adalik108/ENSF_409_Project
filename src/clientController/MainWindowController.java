package clientController;

import java.util.ArrayList;

import javax.swing.JFrame;

import clientModel.ClientData;
import model.Tool;
import view.MainWindow;

/**
 * The controller for the Main Window of the GUI
 * @author Aaron Dalik
 *
 */

public class MainWindowController extends GUIController implements ToolShopTasks {

	//@Override
	//MainWindow theView;
	private  ClientData theData;
	
	public MainWindowController(MainWindow view, CommControl com, ClientData data) {
		super(view, com);
		theData = data;
		
		view.addSearchListener(new Button1Listener());
		view.addAddListener(new Button2Listener());
		view.addRemoveListener(new Button3Listener());
		view.addChangeListener(new Button4Listener());
		view.addAllListener(new Button5Listener());
		view.addQuantListener(new Button6Listener());
		// TODO Auto-generated constructor stub
	}

	/**
	 * Initiates the search function
	 */
	@Override
	//Search
	public void button1() {
		search();
	}
	
	/**
	 * Initiates the add Tool function
	 */
	@Override
	//Add
	public void button2() {
		((MainWindow) theView).setAddVisible(true);
		//theView.setAddVisible(true);
	}
	
	
	/**
	 * Initiates the All Tool function
	 */
	//All
	@Override
	public void button5() {
		allTools();
	}
	
	private void allTools() {
		theCom.sendToServer(ALL);
		
		theData.setTools(theCom.recieveObject());
		
		displayFullInfo();
	}
	
	private void search() {
		theCom.sendToServer(SEARCH);
		String toServer = "";
		toServer += ((MainWindow) theView).getSearchInput();
		theCom.sendToServer(toServer);
		theData.setTools(theCom.recieveObject());
		displayFullInfo();
	}
	
	private void displayFullInfo() {
		((MainWindow) theView).setDisplay(theData.fullInfoString());
	}
	
	public static void main(String[] args) {
		MainWindow theWindow = new MainWindow();
		CommControl theCom = new CommControl("localhost", 8099);
		ClientData theData = new ClientData();
		MainWindowController control = new MainWindowController(theWindow, theCom, theData);
		AddWindowController addControl = new AddWindowController(theWindow.getAddWindow(), theCom);
//		theCom.sendToServer("sent this to the server");
//		theCom.sendToServer("sent this to the server");
//		System.out.println("sent");
		//control.button5();
		theWindow.setVisible(true);
	}
}
