package Shipment;

import java.io.Serializable;

//Name: Salih Alhaj
//ID: 202405408
//Date: 11-11-2025

public class Address implements Serializable {

	private String street;
	private String city;
	private String country;

	public Address(String street, String city, String country) {
		super();
		this.street = street;
		this.city = city;
		this.country = country;
	}

	public String toSingleLine() {

		return String.format("%s, %s, %s", street, city, country);

	}

}
