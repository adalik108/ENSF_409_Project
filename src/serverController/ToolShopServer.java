package serverController;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import clientController.MainWindowController;
import model.ToolModel;
import view.MainWindow;

/**
 * The Server for the Tool Shop Inventory Program
 * @author Aaron Dalik
 *
 */

public class ToolShopServer {

	private ServerSocket serverSocket;
	
	public ToolShopServer(int portNum) {
		try {
			serverSocket = new ServerSocket(portNum);
			System.out.println("Server is active.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		try {
			ToolShopServer theServer = new ToolShopServer(8099);
			ToolModel theModel = new ToolModel();
			ServerCommControl theCom = new ServerCommControl(theServer.serverSocket.accept());
			ServerController theController = new ServerController(theModel, theCom);
//			System.out.println("Waiting for client message");
//			System.out.println(theCom.receiveFromClient());
			theController.controlServer();
//			theController.allTools();
//			while(true) {
//				
//			}
			theCom.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			//theCom.close();
		}
		
		
		//MainWindowController control = new MainWindowController(theWindow);
		//theWindow.setVisible(true);
	}
}
