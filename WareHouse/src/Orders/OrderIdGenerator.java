package Orders;
//Anas Ali Khan

//11/05/2025

public class OrderIdGenerator {
	private static int counter = 1001; // initializes the counter to initial value

	public static String nextId() {
		String result = String.valueOf(counter); // converts the integer counter to String
		counter++; // increments counter

		return result; // returns the result
	}
}
