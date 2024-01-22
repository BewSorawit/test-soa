package th.ac.ku.kps.eng.cpe.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
	@JsonProperty("customer_name")
	private String name;
	@JsonProperty("phone_numbers")
	private List<PhoneNumber> phoneNumbers;

	// Default constructor
	public Customer() {
		super();
	}

	public Customer(String name) {
		super();
		this.name = name;
	}

	public Customer(@JsonProperty("customer_name") String name,
			@JsonProperty("phone_numbers") List<PhoneNumber> phoneNumbers) {
		this.name = name;
		this.phoneNumbers = phoneNumbers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

}
