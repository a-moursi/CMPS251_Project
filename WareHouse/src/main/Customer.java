package main;

import java.io.Serializable;

//Name: Abdelrahman Moursi
//ID: 202406103

public class Customer implements Serializable  {
	private String id;
	private String name;
	public ShoppingCart shoppingcart = new ShoppingCart();

	// ----------------------------------------------------------------------------------------

	public Customer(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	// ----------------------------------------------------------------------------------------

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	// ----------------------------------------------------------------------------------------

}
