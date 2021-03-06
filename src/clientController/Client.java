package clientController;

import clientModel.ClientData;
import view.MainWindow;

/**
 * Class that runs the client
 * @author Aaron Dalik
 *
 */
public class Client {

	public void runClient() {
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
	
	public static void main(String[] args) {
		Client theClient = new Client();
		theClient.runClient();
	}
}
