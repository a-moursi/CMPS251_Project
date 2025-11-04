package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Formatter;
import java.util.Scanner;

//Abdelrahman Moursi
//1-11-2025

public class App {
	public static final LocalDate TODAY = LocalDate.of(2025, 10, 24);
	
	private static Scanner sc = new Scanner(System.in);
	private static WarehouseSystem system = new WarehouseSystem(TODAY);
	
	
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
				case 1 -> StaffMenu.run(sc, system);
				case 2 -> CustomerMenu.run(sc, system);
				case 0 -> exitSystem();
				default -> System.out.println("Invalid choice!, try again");
			} 
			
		}while(true);
	}
	
	//End of MENUS============================================================================================================
	
	public static void exitSystem() {
		//close scanners, save data, and exit
		System.out.println("Exiting the system ....");
		
		//Save the data-------------------------------------------------------------------------------------------------
		System.out.println("Saving Data ...");
		FileWriter fr = null;
		Formatter out = null;
		try {
			fr = new FileWriter("System_Data",true);
			out = new Formatter(fr);
			
			//write data to the file
		}catch(IOException e){
			System.out.println("Error" + e);
		}finally {
			out.close(); //close the file writer
		}
		//-----------------------------------------------------------------------------------------------------------------
		
		sc.close(); //close the scanner
		
		System.exit(0); //exit
	}
}
