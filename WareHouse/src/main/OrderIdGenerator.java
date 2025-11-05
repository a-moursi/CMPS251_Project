package main;
//Anas Ali Khan
//11/05/2025

public class OrderIdGenerator {
	private static int counter = 1001; // initializes the counter to initial value
	
	public String nextId() {
		counter++; // increments counter 
		String result = String.valueOf(counter); // converts the integer counter to String
		return result; // returns the result
	}
}
