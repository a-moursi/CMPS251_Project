package Data;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.*;

import Discount.*;
import Orders.*;
import main.*;
import Shipment.*;
import Products.*;

public class SeedData {
	public static void load(WarehouseSystem s) {

		System.out.println("=== Starting up the system ===");

		// data-------------------------------------------------------------------------------------------------
		System.out.print("Loading Data ");
		ObjectInputStream readData = null; // load customers
		try {
			readData = new ObjectInputStream(new FileInputStream("Customer_Data.dat"));
			ArrayList<Customer> customer;
			customer = (ArrayList<Customer>) readData.readObject();
			s.getCustomers().addAll(customer);

		} catch (IOException e) {
			System.out.println("Error reading Customer_Data" + e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (readData != null) {
				try {
					readData.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}

		readData = null;
		try {
			readData = new ObjectInputStream(new FileInputStream("Discount_Data.dat"));
			ArrayList<Discount> discounts = (ArrayList<Discount>) readData.readObject();
			s.getDiscounts().addAll(discounts);

		} catch (IOException e) {
			System.out.println("Error reading Order_Data" + e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (readData != null) {
				try {
					readData.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}

		readData = null;
		try {
			readData = new ObjectInputStream(new FileInputStream("Order_Data.dat"));
			ArrayList<Order> orders = (ArrayList<Order>) readData.readObject();
			s.getOrders().addAll(orders);

		} catch (IOException e) {
			System.out.println("Error reading Order_Data" + e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (readData != null) {
				try {
					readData.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}

		readData = null;
		try {
			readData = new ObjectInputStream(new FileInputStream("Shipment_Data.dat"));

			ArrayList<Shipment> shipments = (ArrayList<Shipment>) readData.readObject();
			s.getShipments().addAll(shipments);

		} catch (IOException e) {
			System.out.println("Error reading Shipment_Data" + e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (readData != null) {
				try {
					readData.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}

	}

	private static void addElectronics(WarehouseSystem s, String id, String name, double price, double w, int stock) {

		Product electronicProduct = new ElectronicProduct(id, name, price, w, stock);
		s.getProducts().add(electronicProduct);

	}

	private static void addBooks(WarehouseSystem s, String id, String name, double price, double w, int stock) {

		Product bookProduct = new BookProduct(id, name, price, w, stock);
		s.getProducts().add(bookProduct);
	}

	private static void addGrocery(WarehouseSystem s, String id, String name, double price, double w, int stock) {

		Product groceryProduct = new GroceryProduct(id, name, price, w, stock);
		s.getProducts().add(groceryProduct);

	}
}
