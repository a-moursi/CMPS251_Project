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

//Name: Abdelrahman Moursi
//ID: 202406103
//Date: 01-11-2025

public class App {
	public static final LocalDate TODAY = LocalDate.of(2025, 10, 24);
	public final static String currency = "QAR";//extra added variable
	
	private static Scanner sc = new Scanner(System.in);
	private static WarehouseSystem sys = new WarehouseSystem(TODAY);
	
	//MENU CONSTANTS==============================================================================================
	
	private static final String WHMENU = "=== Single-Warehouse System (" + currency + ") === \r\n"
										+ "1) Staff Menu \r\n"
										+ "2) Customer Menu \r\n"
										+ "0) Exit\r\n\n"
										+ "Choice > ";
	
	//============================================================================================================
	
	public static void main(String[] args) {
		System.out.println("Welcome to the WareHouse System!");
		//-----------------------------------
		//load the data from the files 
		
	//Show System MENU----------------------
		
		int choice;
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
			
				//Customer data -----
			for (Customer c : sys.getCustomers()) {
				out.format("%s,%s\n", c.getId(), c.getName());
			}
				System.out.print(".");
				out.close();

				// Products data----
				fr = new FileWriter("Product_Data", true);
				out = new Formatter(fr);
				// write Product data to the file
				for (Product p : sys.getProducts()) {
					out.format("%s", p);
				}
				System.out.print(".");
				out.close();

				// Discounts data----
				fr = new FileWriter("Discount_Data", true);
				out = new Formatter(fr);
				// write Discount data to the file
				for (Discount d : sys.getDiscounts()) {
					out.format("%s", d);
				}
				System.out.print(".");
				out.close();

				// Order data----
				fr = new FileWriter("Order_Data", true);
				out = new Formatter(fr);
				// write Order data to the file
				for (Order o : sys.getOrders()) {
					out.format("%s", o);
				}
				System.out.print(".");
				out.close();

				// shipment data----
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
