package main;

import java.util.Scanner;

//Abdelrahman Moursi
//1-11-2025

public class CustomerMenu {
	
	public static void run(Scanner sc, WarehouseSystem sys) {
		
		String id=null;
		String name=null;
		final String CUSTOMERMENU = "\n--- Customer Menu (ID: " +id+ "," +name+") --\r\n"//shows the ID and Name of the customer chosen the previous menu
				+ "1) List Products (by Category)\r\n"
				+ "2) Add to Cart \r\n"
				+ "3) Remove from Cart \r\n"
				+ "4) View Cart \r\n"
				+ "5) Checkout \r\n"
				+ "0) Logout \r\n\n"
				+ "Choice > ";
		
		//shows a menu for available customers 
		System.out.println("Available Customer IDs: ");
		int i=1;
		for(Customer c : sys.getCustomers()) {
			System.out.printf("%d- %d (%s)\n",i,c.getId(),c.getName());
			i++;
		}
		
		//choose the customer
		System.out.println("Enter Customer ID to login: > ");
		id = sc.next();
		
		//should validate if the input is valid/in the list before continuing
		Customer current = sys.findCustomerById(id); 
		name = current.getName();
		
		int choice;
		boolean exit = false;
		int x; //random variable to not get an error, remove later
		do {
			System.out.print(CUSTOMERMENU);
			choice = sc.nextInt();//do try catch for invalid input
			
			switch (choice) {
				case 1 -> x=1;
				case 2 -> x=1;
				case 0 -> exit=true;
				default -> System.out.println("Invalid choice!, try again");
			} 

		}while(!exit);
	}
	
}
