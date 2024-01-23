package entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PhoneNumber implements Serializable {
	private String number;

	public PhoneNumber() {
		// Required default constructor for JAXB
	}

	public PhoneNumber(String number) {
		super();
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
