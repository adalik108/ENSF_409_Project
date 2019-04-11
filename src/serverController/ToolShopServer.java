package serverController;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
	
	/**
	 * Executor of the thread-pool
	 */
	private ExecutorService pool;
	
	public ToolShopServer(int portNum) {
		try {
			serverSocket = new ServerSocket(portNum);
			pool = Executors.newCachedThreadPool();
			System.out.println("Server is active.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void runServer() {
		try {
			ToolModel theModel = new ToolModel();
			while(true) {
				ServerController theController = new ServerController(theModel, new ServerCommControl(serverSocket.accept()));
				pool.execute(theController);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		ToolShopServer theServer = new ToolShopServer(8099);
		theServer.runServer();
		theServer.pool.shutdown();
		//ServerCommControl theCom = 
		
//			System.out.println("Waiting for client message");
//			System.out.println(theCom.receiveFromClient());
		//theController.controlServer();
//			theController.allTools();
//			while(true) {
//				
//			}
		//theCom.close();
		
		
		
		//MainWindowController control = new MainWindowController(theWindow);
		//theWindow.setVisible(true);
	}
}
