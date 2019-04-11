package serverController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import clientController.ToolShopCommunication;
import model.Tool;

/**
 * Controller for the communication module of the server
 * Contains a blank function that is to be overwritten
 * @author Aaron Dalik
 *
 */

public class ServerCommControl implements ToolShopCommunication {

	private Socket theSocket;
	private BufferedReader socketIn;
	private PrintWriter socketOut;
//	private ObjectInputStream objectIn;
//	private ObjectOutputStream objectOut;
	
	
	public ServerCommControl(Socket server) {		
		try {
			theSocket = server;
			socketIn = new BufferedReader(new InputStreamReader(theSocket.getInputStream()));
			socketOut = new PrintWriter(theSocket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//			objectIn = new ObjectInputStream(theSocket.getInputStream());
//			objectOut = new ObjectOutputStream(theSocket.getOutputStream());
		
	}
	
	public ServerCommControl() {
		theSocket = null;
		socketIn = null;
		socketOut = null;
//		objectIn = null;
//		objectOut = null;
		
	}
	
	/**
	 * Receives the input from the client which determines which task the server is to perform
	 * @return the integer input from the client which determines which task the server is to perform
	 */
	public int receiveTask() {
		try {
			int a;
			InputStream inputStream = theSocket.getInputStream();
			ObjectInputStream objectIn = new ObjectInputStream(inputStream);
			
//			s = (String) objectIn.readObject();
			//objectIn.close();
			
			a = (int) objectIn.readObject();
			System.out.println("Task received: " + a);
			return a;
			//s = (String) obje
//			int a = Integer.parseInt(socketIn.readLine());
//			return a;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Receives a serialized object from the server and converts it to a Tool
	 * @return Tool that represents the object received from the server
	 */
	public Tool recieveObject() {
		try {
			InputStream inputStream = theSocket.getInputStream();
			ObjectInputStream objectIn = new ObjectInputStream(inputStream);
			
			Tool tool = (Tool) objectIn.readObject();
			//objectIn.close();
			
			return tool;
			//return (ArrayList<Tool>) objectIn.readObject();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
//	public void sendObject(Tool t) {
//		try {
//			objectOut.writeObject(t);
//			
//			t = new Tool(0, null, 0, 0, 0);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//System.out.println(t);
//		
//	}
	/**
	 * Sends the given ArrayList of Tool to the client as a serialized object
	 * @param t the ArrayList of Tool to be sent to the client as a serialized object
	 */
	public void sendObject(ArrayList<Tool> t) {
		try {
			OutputStream outputStream = theSocket.getOutputStream();
			ObjectOutputStream objectOut = new ObjectOutputStream(outputStream);
			objectOut.writeObject(t);
//			System.out.println("Tools sent to client: ");
//			printTools(t);
			t = new ArrayList<Tool>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(t);
		
	}
	
	/**
	 * Sends the given String to the client as a serialized object
	 * @param s the String to be sent to the client as a serialized object
	 */
	public void sendToClient(String s) {
		try {
			OutputStream outputStream = theSocket.getOutputStream();
			ObjectOutputStream objectOut = new ObjectOutputStream(outputStream);
			objectOut.writeObject(s);
			s = new String();
			
			//outputStream.close();
			//objectOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Closes all the input and output streams
	 */
	public void close() {
		try {
//			objectIn.close();
//			objectOut.close();
			socketIn.close();
			socketOut.close();
			theSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Receives a serialized object from the client and converts it to a String
	 * @return String that represents the object received from the client
	 */
	public String receiveFromClient() {
//		String s;
//		try {
//			InputStream in = theSocket.getInputStream();
//			BufferedReader sIn = new BufferedReader(new InputStreamReader(in));
////			while(theSocket.getInputStream().available() < 1) {
////				
////			}
//			s = sIn.readLine();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//		return s;
//	}
		
		try {
			String s = "";
			InputStream inputStream = theSocket.getInputStream();
			ObjectInputStream objectIn = new ObjectInputStream(inputStream);
			
			s = (String) objectIn.readObject();
			//objectIn.close();
			System.out.println("received: " + s);
			return s;
			//s = (String) obje
//			int a = Integer.parseInt(socketIn.readLine());
//			return a;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	void printTools(ArrayList<Tool> t) {
		for(Tool to: t) 
			System.out.println(to.toString());
	}
}
