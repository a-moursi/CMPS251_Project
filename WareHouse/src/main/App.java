package main;

import java.time.LocalDate;
import java.util.Scanner;

//Abdelrahman Moursi
//1-11-2025

public class App {
	public static final LocalDate TODAY = LocalDate.of(2025, 10, 24);
	
	private static Scanner sc = new Scanner(System.in);
	private static WarehouseSystem system = new WarehouseSystem(TODAY);
	
	
	//variables used in the menu
	private static String currency = "QAR";//for now 
	
	//MENU CONSTANTS-------------------------------------------------------------------------
	
	private static final String WHMENU = "=== Single-Warehouse System (" + currency + ") === \r\n" //shows the currency in the menu
										+ "1) Staff Menu \r\n"
										+ "2) Customer Menu \r\n"
										+ "0) Exit\r\n\n"
										+ "Choice > ";
	
	
	
	//---------------------------------------------------------------------------------------------
	
	public static void main(String[] args) {
		int choice;
		int x; //random variable to not get an error, remove later
		do {
			System.out.print(WHMENU);
			choice = sc.nextInt();//do try catch for invalid input
			
			switch (choice) {
				case 1 -> StaffMenu.run(sc, system);
				case 2 -> CustomerMenu.run(sc, system);
				case 0 -> exitSystem();
				default -> System.out.println("Invalid choice!, try again");
			} 
			
		}while(true);
	}
	
	//End of MENUS----------------------------------------------------------------------------------------------------
	
	public static void exitSystem() {//try to pass exit code, default id 0 (probably we dont need it)
		//close scanners, save data, and exit
		System.out.println("Exiting the system ....");
		
		sc.close();
		
		System.out.println("bye.");
		
		System.exit(0);
	}
}
