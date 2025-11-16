package Data;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import main.WarehouseSystem;

public class SeedData {
	public static void load(WarehouseSystem sys) {//not working now, working on fix(Osama please fix)

//		System.out.println("=== Starting up the system ===");
//
//		// data-------------------------------------------------------------------------------------------------
//		System.out.print("Loading Data ");
//		ObjectInputStream in = null;
//		try {
//			in = new ObjectInputStream(new FileInputStream("Customer_Data"));
//			in.readObject()
//			in.close();
//
//			in = new ObjectInputStream(new FileInputStream("Discount_Data"));
//			in.readObject(sys.getDiscounts());
//			in.close();
//
//			in = new ObjectInputStream(new FileInputStream("Order_Data"));
//			in.readObject(sys.getOrders());
//			in.close();
//
//			in = new ObjectInputStream(new FileInputStream("Shipment_Data"));
//			in.readObject(sys.getShipments());
//			in.close();
//		} catch (IOException ioe) {
//
//		} finally {
//			try {
//				in.close();
//			} catch (IOException e) {
//
//			}
//		}

	}

	private static void addElectronics(WarehouseSystem sys, String id, String name, double price, double weight,
			int stock) {

	}

	private static void addBooks(WarehouseSystem sys, String id, String name, double price, double weight, int stock) {

	}

	private static void addGrocery(WarehouseSystem sys, String id, String name, double price, double weight,
			int stock) {

	}
}
