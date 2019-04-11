package serverController;

import clientController.*;
import model.*;
import view.MainWindow;

/**
 * The controller for the Server
 * @author Aaron Dalik
 *
 */

public class ServerController implements Runnable, ToolShopTasks{

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
		theCom.sendObject(theModel.search(theCom.receiveFromClient()));
	}
	
	private void remove() {
		theModel.removeTool(theCom.recieveObject());
	}
	
	private void change() {
		if(theModel.change(theCom.recieveObject())) {
			theCom.sendToClient("ok");
		}
		else
			theCom.sendToClient("no");
	}
	
	private void add() {
		theModel.addToolFromString(theCom.receiveFromClient());
	}
	
	/**
	 * Controls which operation is performed by the server
	 */
	synchronized public void controlServer() {
		System.out.println("In controlServer");
		try {
			while(true) {
				switch(theCom.receiveTask()) {
				
					case SEARCH:
						search();
						break;
						
					case ALL:
						allTools();
						break;
						
					case REMOVE:
						remove();
						break;
						
					case CHANGE:
						change();
						break;
						
					case ADD:
						add();
						break;
						
					case QUANT:
						allTools();
						break;
				}
			}
		}catch(Exception e) {
			theCom.close();
		}
	}
	
//	String[] parseSearch(String s) {
//		String [] s1 = {"", ""};
//		
//		for(int i = 0, j = 0; i < s.length(); i++) {
//			if(s.charAt(i) != '\n')
//				s1[j] += s.charAt(i);
//			else
//				j++;
//		}
//		return s1;
//	}
	
	@Override
	public void run() {
		controlServer();
		
	}
	
	public static void main(String[] args) {
		
	}

	
}