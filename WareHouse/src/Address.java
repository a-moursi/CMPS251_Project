public class Address {
<<<<<<< HEAD
 
=======
	
>>>>>>> 0b00db0b9b19727af4f3a2d504f80593a6595f45
	private String street;
	private String city;
	private String country;
	
<<<<<<< HEAD
	//----------------------------------
	
	public Address(String street, String city, String country) {
		this.setStreet(street);
		this.setCity(city);
		this.setCountry(country);
	}
	
	//-----------------------------------------------------

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	//--------------------------------------------
	
	public String toSingleLine() {
		String result = null;
		
		return result;
	}
	
	
=======
	public Address(String street, String city, String country) {
		super();
		this.street = street;
		this.city = city;
		this.country = country;
	}
	
	public String toSingleLine() {
		
		return String.format("%s, %s, %s",street,city,country);
		
	}

>>>>>>> 0b00db0b9b19727af4f3a2d504f80593a6595f45
	
}
