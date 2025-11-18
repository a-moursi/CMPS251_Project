package main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Scanner;

import Data.SeedData;

//Name: Abdelrahman Moursi
//ID: 202406103
//Date: 01-11-2025

public class App {
	public static final LocalDate TODAY = LocalDate.of(2025, 10, 24);
	public final static String currency = "QAR";// extra added variable

	private static Scanner sc = new Scanner(System.in);
	private static WarehouseSystem sys = new WarehouseSystem(TODAY);

	// MENU
	// CONSTANTS==============================================================================================

	private static final String WHMENU = "\n=== Single-Warehouse System (" + currency + ") === \r\n"
			+ "1) Staff Menu \r\n" + "2) Customer Menu \r\n" + "0) Exit\r\n\n" + "Choice > ";

	// ============================================================================================================

	public static void main(String[] args) {
		System.out.println("Welcome to the WareHouse System!");
		// -----------------------------------
		// load the data from the files
		SeedData.load(sys);

		// Show System MENU----------------------

		int choice;
		do {
			System.out.print(WHMENU);
			choice = sc.nextInt();// do try catch for invalid input
			switch (choice) {
			case 1 -> StaffMenu.run(sc, sys);
			case 2 -> {
				if (sys.getCustomers().size() == 0)
					System.out.println("No customers in the system");
				else
					CustomerMenu.run(sc, sys);
			}
			case 0 -> exitSystem();
			default -> System.out.println("Invalid choice!, try again(Main Menu)");
			}
		} while (true);
	}

	// close scanners, save data, and exit
	public static void exitSystem() {
		System.out.println("=== Exiting the system ===");

		// Save
		// data-------------------------------------------------------------------------------------------------
		System.out.print("Saving Data ");
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream("Customer_Data"));
			out.writeObject(sys.getCustomers());
			out.close();

			out = new ObjectOutputStream(new FileOutputStream("Discount_Data"));
			out.writeObject(sys.getDiscounts());
			out.close();

			out = new ObjectOutputStream(new FileOutputStream("Order_Data"));
			out.writeObject(sys.getOrders());
			out.close();

			out = new ObjectOutputStream(new FileOutputStream("Shipment_Data"));
			out.writeObject(sys.getShipments());
			out.close();
		} catch (IOException ioe) {

		} finally {
			try {
				out.close();
			} catch (IOException e) {

			}
		}

		// -----------------------------------------------------------------------------------------------------------------

		sc.close(); // close the scanner
		System.exit(0); // exit
	}
}
