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
		ObjectInputStream readData = null;
		try {
			readData = new ObjectInputStream(new FileInputStream("Customer_Data"));
			ArrayList<Customer> customer;
			try {
				customer = (ArrayList<Customer>) readData.readObject();
				s.getCustomers().addAll(customer);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			readData.close();

			readData = new ObjectInputStream(new FileInputStream("Discount_Data"));

			try {
				ArrayList<Discount> discounts = (ArrayList<Discount>) readData.readObject();
				s.getDiscounts().addAll(discounts);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			readData.close();

			readData = new ObjectInputStream(new FileInputStream("Order_Data"));
			try {
				ArrayList<Order> orders = (ArrayList<Order>) readData.readObject();
				s.getOrders().addAll(orders);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			readData.close();

			readData = new ObjectInputStream(new FileInputStream("Shipment_Data"));

			try {
				ArrayList<Shipment> shipments = (ArrayList<Shipment>) readData.readObject();
				s.getShipments().addAll(shipments);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			readData.close();
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}

	private static void addElectronics(WarehouseSystem s, String id, String name, double price, double w,
			int stock) {
		
			Product electronicProduct = new ElectronicProduct(id, name, price, w, stock);
			s.getProducts().add(electronicProduct);
			
	}

	private static void addBooks(WarehouseSystem s, String id, String name, double price, double w, int stock) {
		
			Product bookProduct = new BookProduct(id, name, price, w, stock);
			s.getProducts().add(bookProduct);
	}

	private static void addGrocery(WarehouseSystem s, String id, String name, double price, double w,
			int stock) {
		
		Product groceryProduct = new GroceryProduct(id, name, price, w, stock);
		s.getProducts().add(groceryProduct);
		
	}
}
