package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ToolModel {
	/**
	 * A list of all the Tools sold in the shop.
	 */
	private ArrayList<Tool> inventory;
	
	/**
	 * A list of all Suppliers for the shop.
	 */
	//private ArrayList<Supplier> suppliers;
	
	/**
	 * The order for a given day.
	 * Only 1 because this is the Order for a single day.
	 * At the end of the day, the Order is sent out.
	 */
	//private Order order;
	
	/**
	 * The date.
	 */
	//private String date;
	
	/**
	 * Constructs an InventoryApp, constructs inventory and suppliers ArrayLists.
	 */
	public ToolModel() {
		inventory = new ArrayList<Tool>();
		addToolsFromFile("src/items.txt");
	}

	/**
	 * Adds a Tool to the inventory.
	 * @param t Tool that is to be added to the inventory
	 * @return true if the Tool was added to the inventory, otherwise false
	 */
	public boolean addTool(Tool t) {
		if(!inventory.isEmpty()) {
			for(Tool tool : inventory) {
				if((tool.getName() == t.getName()) || (tool.getIdNum() == t.getIdNum())) {
					System.out.println("Sorry, Tool: " + t.getName() + ", already exists.");
					return false;
				}
			}
		}
		//setSupplier(t);
		inventory.add(t);
		System.out.println("Tool: " + t.getName() + ", has been successfully added.");
		return true;
	}
	
	/**
	 * Adds a Supplier to the list of suppliers.
	 * @param s Supplier that is to be added to the list of suppliers
	 * @return true if the Tool was added to the inventory, otherwise false
	 */
//	public boolean addSupplier(Supplier s) {
//		if(!suppliers.isEmpty()) {
//			for(Supplier sup : suppliers) {
//				if((sup.getIdNum() == s.getIdNum()) || (sup.getCompanyName() == s.getCompanyName())) {
//					System.out.println("Sorry, Supplier: " + s.getCompanyName() + ", already exists.");
//					return false;
//				}
//			}
//		}
//		suppliers.add(s);
//		System.out.println("Supplier: " + s.getCompanyName() + ", has been successfully added.");
//		return true;
//	}
	
	/**
	 * Removes a Tool from the inventory.
	 * @param t Tool that is to be removed
	 * @return True if the Tool was removed, false otherwise
	 */
	public boolean removeTool(Tool t) {
		System.out.println("in remove");
		for(int i = 0; i < inventory.size(); i++) {
			if(t.getName().equals(inventory.get(i).getName())) {
				inventory.remove(i);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Search for the Tool that has the given name.
	 * @param name Name of the Tool that is to be searched for
	 * @return Tool that the given name, null otherwise
	 */
	public Tool searchTool(String name) {
		for(Tool t : inventory) {
			if(t.getName().toLowerCase().equals(name.toLowerCase()))
				return t;
		}
		return null;
	}
	
	/**
	 * Search for the Tool that has the given ID-Number.
	 * @param idNum ID-Number of the Tool that is to be searched for
	 * @return Tool that the given ID-Number, null otherwise
	 */
	public Tool searchTool(int idNum) {
		for(Tool t : inventory) {
			if(t.getIdNum() == idNum)
				return t;
		}
		return null;
	}
	
	/**
	 * Obtains the quantity of Tool with the given name.
	 * @param name Name of Tool to get the quantity of
	 * @return Quantity of the Tool with the given name
	 */
	public int toolQuant(String name) {
		return searchTool(name).getQuant();
	}
	
	/**
	 * Obtains the quantity of Tool with the given ID-Number.
	 * @param idNum ID-Number of Tool to get the quantity of
	 * @return Quantity of the Tool with the given ID-Number
	 */
	public int toolQuant(int idNum) {
		return searchTool(idNum).getQuant();
	}
	
	/**
	 * Prints the quantity of every Tool in the inventory.
	 */
	public void toolQuant() {
		for(Tool t : inventory) {
			System.out.println("Tool Name: " + t.getName());
			System.out.println("Quantity: " + t.getQuant() + "\n");
		}
	}
	
	/**
	 * Reduces the quantity of the specified Tool by the given amount.
	 * @param name Name of the Tool that is being reduced in quantity
	 * @param numSold Number to reduce the quantity of the given Tool by
	 * @return true if the sale is valid (i.e. enough in stock), false otherwise
	 */
	public boolean sellTool(String name, int numSold) {
		Tool t = searchTool(name);
		if(validSale(t, numSold)) {
			t.setQuant(t.getQuant() - numSold);
//			if(t.getQuant() < MIN_QUANT) {
//				newOrderLine(t);
//			}
			return true;
		}
		return false;
	}
	
	/**
	 * Reduces the quantity of the specified Tool by the given amount.
	 * @param idNum ID-Number of the Tool that is being reduced in quantity
	 * @param numSold Number to reduce the quantity of the given Tool by
	 * @return true if the sale is valid (i.e. enough in stock), false otherwise
	 */
//	public boolean sellTool(int idNum, int numSold) {
//		Tool t = searchTool(idNum);
//		if(validSale(t, numSold)) {
//			t.setQuant(t.getQuant() - numSold);
//			if(t.getQuant() < MIN_QUANT) {
//				newOrderLine(t);
//			}
//			return true;
//		}
//		return false;
//	}
	
	/**
	 * Produces a new OrderLine of the given Tool and adds it to the Order for the day.
	 * Constructs new Order if one is not already present.
	 * @param t Tool for which a new OrderLine is to be produced
	 */
//	public void newOrderLine(Tool t) {
//		//OrderLine newOrder = new OrderLine(t);
//		if(order == null) {
//			this.order = new Order();
//		}
//		order.addOrderLine(t);
//	}
	
	/**
	 * Prints all the Tools in the inventory to the console
	 */
	public void listTools() {
		for (Tool t : inventory) {
			System.out.println(t);
		}
	}
	
	/**
	 * Determines if a sale is valid.
	 * @param t Tool that was sold
	 * @param numSold Number of the Tools that were sold
	 * @return true if sale is valid, false otherwise
	 */
	private boolean validSale(Tool t, int numSold) {
		if (t == null)
			return false;
		
		else if (t.getQuant() < numSold)
			return false;
		
		return true;
	}
	
	/**
	 * Adds Tools to the inventory from the given file.
	 * @param fileName Name of the file that contains the Tool data
	 */
	public void addToolsFromFile(String fileName) {
		String line = null;
		
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(fileReader);
			while((line = reader.readLine()) != null)
				addToolFromString(line);
			
			reader.close();
		} 
		
		catch (FileNotFoundException e) {
			System.err.println("Unable to open file " + fileName);
			return;
		} 
		catch (IOException e) {
			System.err.println("Unable to read file " + fileName);
			return;
		}
	}
	
	/**
	 * Constructs and adds a new Tool to the inventory using the given String, which is in a specific format.
	 * Format of String: ID-Number;Name;Quantity;Price;Supplier ID-Number
	 * @param s String with Tool data in specified format
	 */
	public void addToolFromString(String s) {
		String[] arr = s.split(";");
		addTool(new Tool(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2]), Double.parseDouble(arr[3]), Integer.parseInt(arr[4])));
	}
	
	/**
	 * Adds Suppliers to the list of suppliers from the given file.
	 * @param fileName Name of the file that contains the Supplier data
	 */
//	public void addSuppliersFromFile(String fileName) {
//		String line = null;
//		
//		try {
//			FileReader fileReader = new FileReader(fileName);
//			BufferedReader reader = new BufferedReader(fileReader);
//			while((line = reader.readLine()) != null)
//				addSupplierFromString(line);
//			
//			reader.close();
//		} 
//		
//		catch (FileNotFoundException e) {
//			System.err.println("Unable to open file " + fileName);
//			return;
//		} 
//		catch (IOException e) {
//			System.err.println("Unable to read file " + fileName);
//			return;
//		}
//	}
	
	/**
	 * Constructs and adds a new Supplier to the list of suppliers using the given String, which is in a specific format.
	 * Format of String: ID-Number;Company Name;Address;Name of Contact
	 * @param s String with Supplier data in specified format
	 */
//	public void addSupplierFromString(String s) {
//		String[] arr = s.split(";");
//		addSupplier(new Supplier(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3]));
//	}
	
	/**
	 * Sets the Supplier of the given Tool.
	 * @param t Tool that is to have its Supplier set
	 */
//	public void setSupplier(Tool t) {
//		if(t.getSupplier() != null) {
//			if(t.getSupplier().getIdNum() == t.getSupId());
//				return;
//		}
//		
//		for (Supplier s : suppliers) {
//			if(s.getIdNum() == t.getSupId()) {
//				t.setSupplier(s);
//				return;
//			}
//		}
//	}
	
	public ArrayList<Tool> getInventory(){
		return inventory;
	}
	
	public ArrayList<Tool> search(String input){
		ArrayList<Tool> tools = new ArrayList<Tool>();
		String[] arr = splitString(input);
		if(!arr[0].equals(""))
			tools.add(searchTool(arr[0]));
		if(!arr[1].equals(""))
			tools.add(searchTool(Integer.parseInt(arr[1])));
		return tools;
	}
	
	private String[] splitString(String s) {
		String s1 = "";
		String s2 = "";
		int index = 0;
		String[] arr = new String[2];
		char a;
		
		while(s.charAt(index) != '\n') {
			s1 += s.charAt(index++);
		}
		
		index++;
		
		while(index < s.length()) {
			s2 += s.charAt(index++);
		}
		
		arr[0] = s1;
		arr[1] = s2;
		return arr;
	}
	
	public boolean change(Tool t) {
		System.out.println("Quantity is: " + t.getQuant());
		Tool tool = searchTool(t.getName());
		if(tool != null) {
			int numSold = tool.getQuant() - t.getQuant();
			if(numSold > 0) {
				return sellTool(t.getName(), numSold);
			}
		}
		return false;
	}
}

