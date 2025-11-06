package main;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Formatter;
import java.util.Scanner;

import Discount.Discount;
import Orders.Order;
import Products.Product;
import Shipment.Shipment;

//Abdelrahman Moursi
//1-11-2025

public class App {
	public static final LocalDate TODAY = LocalDate.of(2025, 10, 24);
	
	private static Scanner sc = new Scanner(System.in);
	private static WarehouseSystem sys = new WarehouseSystem(TODAY);
	
	
	//variables used in the menu
	private static String currency = "QAR";//for now 
	
	//MENU CONSTANTS==============================================================================================
	
	private static final String WHMENU = "=== Single-Warehouse System (" + currency + ") === \r\n" //shows the currency in the menu
										+ "1) Staff Menu \r\n"
										+ "2) Customer Menu \r\n"
										+ "0) Exit\r\n\n"
										+ "Choice > ";
	
	
	
	//============================================================================================================
	
	public static void main(String[] args) {
		System.out.println("Welcome to the WareHouse System!");
		//load the data from the files 
		
		
		int choice;
		int x; //random variable to not get an error, remove later
		do {
			System.out.print(WHMENU);
			choice = sc.nextInt();//do try catch for invalid input
			
			switch (choice) {
				case 1 -> StaffMenu.run(sc, sys);
				case 2 -> CustomerMenu.run(sc, sys);
				case 0 -> exitSystem();
				default -> System.out.println("Invalid choice!, try again");
			} 
			
		}while(true);
	}
	
	//End of MENUS============================================================================================================
	
	public static void exitSystem() {
		//close scanners, save data, and exit
		System.out.println("=== Exiting the system ===");
		
		//Save the data-------------------------------------------------------------------------------------------------
		System.out.print("Saving Data ");
		FileWriter fr = null;
		Formatter out = null;
		try {
			fr = new FileWriter("Customer_Data", true);
			out = new Formatter(fr);
			// write Customer data to the file
			for (Customer c : sys.getCustomers()) {
				out.format("%s,%s\n", c.getId(), c.getName());
			}
				System.out.print(".");
				out.close();

				// ----
				fr = new FileWriter("Product_Data", true);
				out = new Formatter(fr);
				// write Product data to the file
				for (Product p : sys.getProducts()) {
					out.format("%s", p);
				}
				System.out.print(".");
				out.close();

				// ----
				fr = new FileWriter("Discount_Data", true);
				out = new Formatter(fr);
				// write Discount data to the file
				for (Discount d : sys.getDiscounts()) {
					System.out.println("wrote a discount");
					out.format("%s", d);
				}
				System.out.print(".");
				out.close();

				// ----
				fr = new FileWriter("Order_Data", true);
				out = new Formatter(fr);
				// write Order data to the file
				for (Order o : sys.getOrders()) {
					out.format("%s", o);
				}
				System.out.print(".");
				out.close();

				// ----
				fr = new FileWriter("Shipment_Data", true);
				out = new Formatter(fr);
				// write Shipment data to the file
				for (Shipment s : sys.getShipments()) {
					out.format("%s", s);
				}
				System.out.println(".");
				out.close();
			
		} catch (IOException e) {
			System.out.println("Error" + e);
		} finally {
			System.out.println("Data Saved.");
			out.close(); // close the file writer
		}
		//-----------------------------------------------------------------------------------------------------------------
		
		sc.close(); //close the scanner
		System.exit(0); //exit
	}
}
