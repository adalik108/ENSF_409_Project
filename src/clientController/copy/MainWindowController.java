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
	private ArrayList<Tool> tools;
	
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
	
	private String[] fullInfoString(ArrayList<Tool> t) {
		String[] s = new String[t.size()];
		for(int i = 0; i < t.size(); i++) {
			try {
				s[i] = tools.get(i).toString();
			}catch(NullPointerException e) {
				s[i] = searchError(i);
			}
		}
		System.out.println(tools.size());
		return s;
	}
	
	private String searchError(int i) {
		String s = "";
		if(i == 0) {
			s += ("Tool: " + ((MainWindow) theView).getNameInput() + "could not be found");
		}
		else {
			s += ("Tool: " + ((MainWindow) theView).getIdInput() + "could not be found");
		}
		return s;
	}
	
	private void setTools() {
		tools = theCom.recieveObject();
	}
	
	private void displayFullInfo() {
		((MainWindow) theView).setDisplay(fullInfoString(tools));
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
