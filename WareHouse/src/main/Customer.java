package main;

//Name: Abdelrahman Moursi
//ID: 202406103
//Date: 01-11-2025

public class Customer {
	private String id;
	private String name;
	
	//----------------------------------------------------------------------------------------

	public Customer(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	//----------------------------------------------------------------------------------------

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
	
	//----------------------------------------------------------------------------------------

}
