package clientController.copy;

import java.util.ArrayList;

import javax.swing.JFrame;

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
	
	public MainWindowController(MainWindow view, CommControl com) {
		super(view, com);
		
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
	//@Override
	//Search
//	public void button1() {
//		//theCom.sendToServer(SEARCH);
//		String toServer = "";
//		toServer += ((MainWindow) theView).getNameInput();
//		toServer += "\n";
//		toServer += ((MainWindow) theView).getIdInput();
//		//comm.sendToServer(toServer);
//		System.out.println(toServer);
//	}
	
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
//		String tools = "";
//		for(Tool t : theCom.recieveObject()) {
//			tools += t.toString();
//			tools += "\n";
//		}
//		((MainWindow) theView).setDisplay(tools);
		
		theCom.sendToServer(ALL);
		
		
//		String tools = "";
//		for(Tool t : theCom.recieveObject()) {
//			tools += t.toString();
//			tools += "\n";
//		}
//		((MainWindow) theView).setDisplay(tools);
		ArrayList<Tool> t = theCom.recieveObject();
		Tool[] tools = new Tool[t.size()];
		for(int i = 0; i < t.size(); i++) {
			tools[i] = t.get(i);
		}
		((MainWindow) theView).setDisplay(tools);
	}
	
	public static void main(String[] args) {
		MainWindow theWindow = new MainWindow();
		CommControl theCom = new CommControl("localhost", 8099);
		MainWindowController control = new MainWindowController(theWindow, theCom);
		AddWindowController addControl = new AddWindowController(theWindow.getAddWindow(), theCom);
//		theCom.sendToServer("sent this to the server");
//		theCom.sendToServer("sent this to the server");
//		System.out.println("sent");
		//control.button5();
		theWindow.setVisible(true);
	}
}
