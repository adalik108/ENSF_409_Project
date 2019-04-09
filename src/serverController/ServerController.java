package serverController;

//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.time.LocalDate;
//import java.util.ArrayList;

import clientController.copy.*;
import model.*;
import view.MainWindow;

/**
 * The controller for the Server
 * @author Aaron Dalik
 *
 */

public class ServerController implements ToolShopTasks{

	private ToolModel theModel;
	private ServerCommControl theCom;
	
	public ServerController(ToolModel model, ServerCommControl com) {
		theModel = model;
		theCom = com;
	}
	
	/**
	 * Sends the entire inventory to the client
	 */
	public void allTools() {
		//for(Tool t : theModel.getInventory())
		theCom.sendObject(theModel.getInventory());
	}
	
	/**
	 * Sends the searched for tool(s) to client
	 */
	private void search() {
		String input = theCom.receiveFromClient();
		
	}
	
	/**
	 * Controls which operation is performed by the server
	 */
	public void controlServer() {
		System.out.println("In controlServer");
		try {
			while(true) {
				switch(theCom.receiveTask()) {
				
					case SEARCH:
						search();
						
					case ALL:
						allTools();
				}
			}
		}catch(Exception e) {
			theCom.close();
		}
	}
	
	public static void main(String[] args) {
		
	}
}