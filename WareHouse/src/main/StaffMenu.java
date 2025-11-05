package main;

import java.time.LocalDate;
import java.util.Scanner;

import Discount.*;

//Abdelrahman Moursi
//1-11-2025

public class StaffMenu {
	
	public static void run(Scanner sc, WarehouseSystem sys) {
		
		final String STAFFMENU = "\n--- Staff Menu --\r\n"
				+ "1) Add Customer (ID + Name) \r\n"
				+ "2) List/Toggle Discounts \r\n"
				+ "3) Create Discount\r\n"
				+ "4) Add Product \r\n"
				+ "5) Update Shipment Status \r\n"
				+ "6) Reports (~15)\r\n"
				+ "0) Back \r\n\n"
				+ "Choice > ";
		//----------
		
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
				case 6 -> x=1;//Reports
				case 0 -> exit=true;
				default -> System.out.println("Invalid choice!, try again");
			} 
			
		}while(!exit);
	}
	
	private static void addCustomer(Scanner sc, WarehouseSystem sys) {
		//get customer info and make a new customer and pass it (id and name) 
		System.out.print("Customer ID: > ");
		String id = sc.next();
		//check if the id is valid and that it doesn't already exist
		System.out.print("Customer Name: > ");
		String name = sc.next();
		
		sys.addCustomer(new Customer(id,name));
		System.out.printf("Added customer %s (ID: %s)\n",name,id);
		
		
	}
	
	private static void listToggleDiscounts(Scanner sc, WarehouseSystem sys) {
		//print discount list
		int i=1;
		for(Discount d : sys.getDiscounts()) {
			System.out.printf("%d) %s\n",i,d.detailsTail());
			i++;
		}
		//toggle the chosen discount
	}
	
	private static void createDiscount(Scanner sc, WarehouseSystem sys) {
		
		System.out.print("Type: 1) Fixed Amount 2) Percentage\n> ");
		int choice=sc.nextInt();
		System.out.print("Code/Name: > ");
		String code = sc.next();
		System.out.print("Start date (YYYY-MM-DD): > ");
		LocalDate start = LocalDate.parse(sc.next());
		System.out.print("End date (YYYY-MM-DD): > ");
		LocalDate end = LocalDate.parse(sc.next());
		System.out.print("Create as Active? (y/n): > ");
		boolean active = (sc.next().toLowerCase().equals("y")) ? true : false;
		
		switch(choice){
		case 1 -> {System.out.print("Amount (e.g., 10 for 10 QAR): > ");
			double amount = sc.nextDouble();
			sys.addDiscount(new FixedAmountDiscount(code, start, end, active, amount));}
		case 2 -> {System.out.print("Percent (e.g., 10 for 10%): > ");
			double percent = sc.nextDouble();
			sys.addDiscount(new PercentageDiscount(code, start, end, active, percent));}
		}
		
		
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
