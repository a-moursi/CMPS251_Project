package Data;

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.*;

import Discount.*;
import Orders.*;
import main.*;
import Shipment.*;
import Products.*;

public class SeedData {
	public static void load(WarehouseSystem s) {
		
		File customerFile = new File("Customer_Data.dat");
		File discountsFile = new File("Discount_Data.dat");
		File orderFile = new File("Order_Data.dat");
		File shipmentFile = new File("Shipment_Data.dat");
		File productFile = new File("Product_Data.dat");
		
//		
//		customerFile = (customerFile.exists()) ? new File("Customer_Data.dat") :  new File("Customer_Seed.dat");
//		discountsFile = (discountsFile.exists()) ? new File("Discount_Data.dat") : new File("Discount_Seed.dat");
//		orderFile = (orderFile.exists()) ? new File("Order_Data.dat") :  new File("Order_Seed.dat");
//		shipmentFile = (shipmentFile.exists()) ? new File("Shipment_Data.dat") :  new File("Shipment_Seed.dat");
//		productFile = (productFile.exists()) ? new File("Product_Data.dat") : new File("Product_Seed.dat");
		

		
		
		

		// data-------------------------------------------------------------------------------------------------
		
		ObjectInputStream readData = null; // load customers
		try {
			readData = new ObjectInputStream(new FileInputStream(customerFile));
			ArrayList<Customer> customer;
			customer = (ArrayList<Customer>) readData.readObject();
			s.getCustomers().addAll(customer);

		} catch (IOException e) {
			
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
		
		
		 readData = null; // load customers
		try {
			readData = new ObjectInputStream(new FileInputStream(productFile));
			ArrayList<Product> products;
			products = (ArrayList<Product>) readData.readObject();
			s.getProducts().addAll(products);

		} catch (IOException e) {
			
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
			readData = new ObjectInputStream(new FileInputStream(discountsFile));
			ArrayList<Discount> discounts = (ArrayList<Discount>) readData.readObject();
			s.getDiscounts().addAll(discounts);

		} catch (IOException e) {
			
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
			readData = new ObjectInputStream(new FileInputStream(orderFile));
			ArrayList<Order> orders = (ArrayList<Order>) readData.readObject();
			s.getOrders().addAll(orders);

		} catch (IOException e) {
			
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
			readData = new ObjectInputStream(new FileInputStream(shipmentFile));

			ArrayList<Shipment> shipments = (ArrayList<Shipment>) readData.readObject();
			s.getShipments().addAll(shipments);

		} catch (IOException e) {
			
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
		
		
		if (s.getProducts().isEmpty() && s.getCustomers().isEmpty()) {
			System.out.println("Files missing. Generating Seed Data...");

            s.addCustomer(new Customer("C001", "Ahmad"));
            s.addCustomer(new Customer("C002", "Mohammad"));
            s.addCustomer(new Customer("C003", "Nasser"));
            s.addCustomer(new Customer("C004", "Aisha"));
            s.addCustomer(new Customer("C005", "Fatimah"));

            
            s.addDiscount(new PercentageDiscount("P10", LocalDate.of(2025, 10, 14), LocalDate.of(2025, 11, 3), false, 10.0));
            

            s.addDiscount(new FixedAmountDiscount("F15", LocalDate.of(2025, 10, 19), LocalDate.of(2025, 10, 27), false, 15.0));
            
            s.addDiscount(new PercentageDiscount("P5", LocalDate.of(2025, 10, 23), LocalDate.of(2025, 10, 25), false, 5.0));
            
            addElectronics(s, "E1", "Electronic 1", 205.00, 1.5, 8);
            addElectronics(s, "E2", "Electronic 2", 210.00, 1.5, 10);
            addElectronics(s, "E3", "Electronic 3", 215.00, 1.8, 10);
            addElectronics(s, "E4", "Electronic 4", 220.00, 1.8, 8);
            addElectronics(s, "E99", "Tablet 10\"", 899.00, 0.8, 3);

            addBooks(s, "B1", "Book 1", 21.00, 0.5, 9);
            addBooks(s, "B2", "Book 2", 22.00, 0.5, 11);
            addBooks(s, "B3", "Book 3", 23.00, 0.3, 11);
            addBooks(s, "B4", "Book 4", 24.00, 0.3, 14);
            addBooks(s, "B5", "Book 5", 25.00, 0.3, 9);
            addBooks(s, "B99", "Algorithms Handbook", 120.00, 1.2, 5);

            addGrocery(s, "G1", "Grocery 1", 6.00, 0.2, 16);
            addGrocery(s, "G2", "Grocery 2", 7.00, 0.2, 20);
            addGrocery(s, "G3", "Grocery 3", 8.00, 0.33, 19);
            addGrocery(s, "G4", "Grocery 4", 9.00, 0.33, 24);
            addGrocery(s, "G5", "Grocery 5", 10.00, 0.33, 21);
            addGrocery(s, "G99", "Premium Dates Box", 49.50, 1.0, 28);
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