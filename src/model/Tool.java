package model;

import java.io.Serializable;

/**
 * Provides data fields and methods to implement and manipulate a Tool for the store.
 *
 * @author Aaron Dalik
 * @version 1.0
 * @since 02/06/19
 */
public class Tool implements Serializable{

	/**
	 * ID-Number for the Tool.
	 */
	private int idNum;
	
	/**
	 * Name of the Tool.
	 */
	private String name;
	
	/**
	 * Quantity of the Tool in stock.
	 */
	private int quant;
	
	/**
	 * Price of the Tool.
	 */
	private double price;
	
	/**
	 * ID-Number for the Supplier of the Tool.
	 */
	private int supId;
	
	/**
	 * Supplier of the Tool.
	 */
	//private Supplier supplier;
	
	
	/**
	 * Constructs a new Tool.
	 * @param idNum The ID-Number for the Tool
	 * @param name The name of the Tool
	 * @param quant Quantity of the Tool in stock
	 * @param price Price of the Tool
	 * @param supId ID-Number for the Supplier of the Tool
	 * @param supplier Supplier of the Tool
	 */
//	public Tool(int idNum, String name, int quant, double price, int supId, Supplier supplier) {
//		this.idNum = idNum;
//		this.name = name;
//		this.quant = quant;
//		this.price = price;
//		this.supId = supId;
//		this.supplier = supplier;
//	}
	
	/**
	 * Constructs a new Tool.
	 * supplier set to null.
	 * @param idNum The ID-Number for the Tool
	 * @param name The name of the Tool
	 * @param quant Quantity of the Tool in stock
	 * @param price Price of the Tool
	 * @param supId ID-Number for the Supplier of the Tool
	 */
	public Tool(int idNum, String name, int quant, double price, int supId) {
		this.idNum = idNum;
		this.name = name;
		this.quant = quant;
		this.price = price;
		this.supId = supId;
		//this.supplier = null;
	}
	
	/** 
	 * Constructs a new Tool with default quantities.
	 */
//	public Tool() {
//		this(0, "default", 0, 0, 0, null);
//	}
	
	/**
	 * Obtains the name of the Tool.
	 * @return Name of the Tool
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the Tool.
	 * @param name Name of the Tool
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Obtains the ID-Number of the Tool.
	 * @return ID-Number of the Tool
	 */
	public int getIdNum() {
		return idNum;
	}
	
	/**
	 * Obtains the quantity of the Tool in stock.
	 * @return Quantity of the Tool in stock
	 */
	public int getQuant() {
		return quant;
	}
	
	/**
	 * Sets the quantity of the Tool in stock.
	 */
	public void setQuant(int newQuant) {
		quant = newQuant;
	}
	
	/**
	 * Obtains the Supplier of the Tool.
	 * @return Supplier of the Tool
	 */
//	public Supplier getSupplier() {
//		return supplier;
//	}
//	
//	/**
//	 * Sets the Supplier of the Tool.
//	 * @param s Supplier of the Tool.
//	 */
//	public void setSupplier(Supplier s) {
//		supplier = s;
//	}
	
	/**
	 * Obtains the ID-Number for the Supplier of the Tool.
	 * @return ID-Number for the Supplier of the Tool
	 */
	public int getSupId() {
		return supId;
	}
	
	public void reduceQuant(int q) {
		quant -= q;
	}
	
	/**
	 * Returns a String representation of the Tool.
	 */
	public String toString() {
		return "Name: " + name + "\n" + "ID Number: " + idNum + "\n" + "Quantity: " + quant + "\n" + "Price: " + price + "\n"
				+ "Supplier ID Number: " + supId + "\n";
	}
}
