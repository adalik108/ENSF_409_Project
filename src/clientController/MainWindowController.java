package clientController;

import java.util.ArrayList;

import javax.swing.*;

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
	
	@Override
	//Remove
	public void button3() {
		remove();
	}
	
	@Override
	//Change
	public void button4() {
		change();
	}
	
	/**
	 * Initiates the All Tool function
	 */
	//All
	@Override
	public void button5() {
		allTools();
	}
	
	@Override
	public void button6() {
		quant();
	}
	
	private void allTools() {
		theCom.sendToServer(ALL);
		
		setTools();
		
		displayFullInfo();
	}
	
	private void search() {
		theCom.sendToServer(SEARCH);
		String toServer = "";
		toServer += ((MainWindow) theView).getSearchInput();
		theCom.sendToServer(toServer);
		setTools();
		displayFullInfo();
	}
	
	private void remove() {
		theCom.sendToServer(REMOVE);
		theCom.sendObject(theData.getTool(((MainWindow) theView).getSelectedIndex()));
	}
	
	private void change() {
		theCom.sendToServer(CHANGE);
		theData.getTool(((MainWindow) theView).getSelectedIndex()).reduceQuant(((MainWindow) theView).getChangeInput());
		theCom.sendObject(theData.getTool(((MainWindow) theView).getSelectedIndex()));
		String s = theCom.receiveFromServer();
		if(!s.equals("ok")) {
			JOptionPane.showMessageDialog(theView, "Invalid Quantity!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void quant() {
		
		theCom.sendToServer(QUANT);
		
		setTools();
		
		((MainWindow) theView).setDisplay(theData.quantInfoString());
	}
	
	private void displayFullInfo() {
		((MainWindow) theView).setDisplay(theData.fullInfoString());
	}
	
	private void setTools() {
		theData.setTools(theCom.recieveObject());
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
