package main;

import java.util.Scanner;

//Abdelrahman Moursi
//1-11-2025

public class StaffMenu {
	private static final String STAFFMENU = "\n--- Staff Menu --\r\n"
			+ "1) Add Customer (ID + Name) \r\n"
			+ "2) List/Toggle Discounts \r\n"
			+ "3) Create Discount\r\n"
			+ "4) Add Product \r\n"
			+ "5) Update Shipment Status \r\n"
			+ "6) Reports (~15)\r\n"
			+ "0) Back \r\n\n"
			+ "Choice > ";
	
	public static void run(Scanner sc, WarehouseSystem sys) {
		
		int choice;
		boolean exit=false;
		int x; //random variable to not get an error, remove later
		do {
			System.out.print(STAFFMENU);
			choice = sc.nextInt();//do try catch for invalid input
			
			switch (choice) {
				case 1 -> addCustomer(sc, sys);
				case 2 -> listToggleDiscounts(sc, sys);
				case 3 -> createDiscount(sc, sys);
				case 4 -> addProduct(sc, sys);
				case 5 -> updateShipment(sc, sys);
				case 6 -> x=1;
				case 0 -> exit=true;
				default -> System.out.println("Invalid choice!, try again");
			} 
			
		}while(!exit);
	}
	
	private static void addCustomer(Scanner sc, WarehouseSystem sys) {
		System.out.println("Adding new customer....");
		//get customer info and make a new customer and pass it (id and name) 
		//check if the id is valid and that it doesn't already exist 
		sys.addCustomer(null);
		
	}
	
	private static void listToggleDiscounts(Scanner sc, WarehouseSystem sys) {
		System.out.println("Printing discount list...");
		System.out.println(sys.getDiscounts());
	}
	
	private static void createDiscount(Scanner sc, WarehouseSystem sys) {
		
	}
	
	private static void addProduct(Scanner sc, WarehouseSystem sys) {
		System.out.println("Adding new product....");
		//get product info and make a new product and pass it (id, name, currency, price, weightKg, stockQty)
		//check if the id is valid and that it doesn't already exist 
		sys.addProduct(null);
	}
	
	private static void updateShipment(Scanner sc, WarehouseSystem sys) {
		
	}
	
}
