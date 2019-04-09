package clientController.copy;

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

import model.Tool;

/**
 * Controller for the communication module of the client
 * Contains a blank function that is to be overwritten
 * @author Aaron Dalik
 *
 */

public class CommControl implements ToolShopCommunication{

	private Socket theSocket;
	private BufferedReader socketIn;
	private PrintWriter socketOut;
//	private ObjectInputStream objectIn;
//	private ObjectOutputStream objectOut;
	
	public CommControl(String serverName, int portNum) {
		try {
			theSocket = new Socket(serverName, portNum);
			socketIn = new BufferedReader(new InputStreamReader(theSocket.getInputStream()));
			socketOut = new PrintWriter(theSocket.getOutputStream());
//			objectIn = new ObjectInputStream(theSocket.getInputStream());
//			objectOut = new ObjectOutputStream(theSocket.getOutputStream());
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sends the given String to the server as a serialized object
	 * @param s the String to be sent to the server as a serialized object
	 */
	public void sendToServer(String s) {
//		socketOut.println(s);
//		return;
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
	 * Sends the given int to the server as a serialized object
	 * @param s the int to be sent to the server as a serialized object
	 */
	public void sendToServer(int s) {
//		socketOut.println(s);
		try {
			OutputStream outputStream = theSocket.getOutputStream();
			ObjectOutputStream objectOut = new ObjectOutputStream(outputStream);
			objectOut.writeObject(s);
			s = 0;
			//outputStream.close();
			//objectOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Receives a serialized object from the server and converts it to a String
	 * @return String that represents the object received from the server
	 */
	public String receiveFromServer() {
		try {
			String read = "";
			String temp = "";
			
			while(true) {
				temp = socketIn.readLine();
				if(temp.contains(END)) {
					temp.replace(END, "");
					read += temp;
					return read;
				}
				read += temp;
			}
		}catch(IOException e) {
			e.printStackTrace();
			//add error message
			return null;
		}
	}
	
	/**
	 * Receives a serialized object from the server and converts it to an ArrayList of Tools
	 * @return ArrayList of Tools that represents the object received from the server
	 */
	public ArrayList<Tool> recieveObject() {
		try {
			InputStream inputStream = theSocket.getInputStream();
			ObjectInputStream objectIn = new ObjectInputStream(inputStream);
//			ArrayList<Tool> tools = new ArrayList<Tool>();
//			Tool temp = (Tool) objectIn.readObject();
//			while(temp != null) {
//				tools.add(temp);
//				temp = (Tool) objectIn.readObject();
//			}
			
			ArrayList<Tool> tools = (ArrayList<Tool>) objectIn.readObject();
			//objectIn.close();
			
			return tools;
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
//			//objectOut.writeObject(t);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
	void flush() {
		
	}
}
