package main;

import java.time.LocalDate;
import java.util.Scanner;

public class App {
	private static Scanner kb = new Scanner(System.in);
	public static final LocalDate TODAY = LocalDate.of(2025, 10, 24);
	
	//variables used in the menus
	private static int id=0;//for now 
	private static String name="ali";//for now 
	private static String currency = "QAR";//for now 
	
	//MENU CONSTANTS-------------------------------------------------------------------------
	
	private static final String WHMENU = "=== Single-Warehouse System (" + currency + ") === \r\n" //shows the currency in the menu
										+ "1) Staff Menu \r\n"
										+ "2) Customer Menu \r\n"
										+ "0) Exit\r\n\n"
										+ "Choice > ";
	
	private static final String STAFFMENU = "\n--- Staff Menu --\r\n"
											+ "1) Add Customer (ID + Name) \r\n"
											+ "2) List/Toggle Discounts \r\n"
											+ "3) Create Discount\r\n"
											+ "4) Add Product \r\n"
											+ "5) Update Shipment Status \r\n"
											+ "6) Reports (~15)\r\n"
											+ "0) Back \r\n\n"
											+ "Choice > ";
	
	private static final String CUSTOMERMENU = "\n--- Customer Menu (ID: " +id+ "," +name+") --\r\n"//shows the ID and Name of the customer chosen the previous menu
											+ "1) List Products (by Category)\r\n"
											+ "2) Add to Cart \r\n"
											+ "3) Remove from Cart \r\n"
											+ "4) View Cart \r\n"
											+ "5) Checkout \r\n"
											+ "0) Logout \r\n\n"
											+ "Choice > ";
	
	//---------------------------------------------------------------------------------------------
	
	public static void main(String[] args) {
		int choice;
		int x; //random variable to not get an error, remove later
		do {
			System.out.print(WHMENU);
			choice = kb.nextInt();//do try catch for invalid input
			
			switch (choice) {
				case 1 -> showStaffMenu();
				case 2 -> showCustomerMenu();
				case 0 -> exitSystem();
				default -> System.out.println("Invalid choice!, try again");
			} 
			
		}while(true);
	}
	
	//MENUS-----------------------------------------------------------------------
	
	public static void showStaffMenu() {
		int choice;
		boolean again=true;
		int x; //random variable to not get an error, remove later
		do {
			System.out.print(STAFFMENU);
			choice = kb.nextInt();//do try catch for invalid input
			
			switch (choice) {
				case 1 -> x=1;
				case 2 -> x=1;
				case 3 -> x=1;
				case 4 -> x=1;
				case 5 -> x=1;
				case 6 -> x=1;
				case 0 -> again=false;
				default -> System.out.println("Invalid choice!, try again");
			} 
			
		}while(again);
	}
	
	public static void showCustomerMenu() {
		
		//shows a menu for available customers before

		int choice;
		boolean again=true;
		int x; //random variable to not get an error, remove later
		do {
			System.out.print(CUSTOMERMENU);
			choice = kb.nextInt();//do try catch for invalid input
			
			switch (choice) {
				case 1 -> x=1;
				case 2 -> x=1;
				case 0 -> again=false;
				default -> System.out.println("Invalid choice!, try again");
			} 

		}while(again);
	}
	
	//End of MENUS----------------------------------------------------------------------------------------------------
	
	public static void exitSystem() {//try to pass exit code, default id 0 (probably we dont need it)
		//close scanners, save data, and exit
		System.out.println("Exiting the system ....");
		
		kb.close();
		
		System.out.println("bye.");
		
		System.exit(0);
	}
}
