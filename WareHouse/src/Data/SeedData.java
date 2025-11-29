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
		File productFile = new File("Product_Data.dat");
		File discountsFile = new File("Discount_Data.dat");
		File orderFile = new File("Order_Data.dat");
		File shipmentFile = new File("Shipment_Data.dat");

		customerFile = (customerFile.exists()) ? new File("Customer_Data.dat") : new File("CSeed");
		productFile = (productFile.exists()) ? new File("Product_Data.dat") : new File("P_Seed");
		discountsFile = (discountsFile.exists()) ? new File("Discount_Data.dat") : new File("D_Seed");
		orderFile = (orderFile.exists()) ? new File("Order_Data.dat") : new File("O_Seed");
		shipmentFile = (shipmentFile.exists()) ? new File("Shipment_Data.dat") : new File("S_Seed");

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

		readData = null; // load products
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
	}
}
