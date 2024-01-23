package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.glassfish.jersey.internal.util.Property;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "customer")
public class Customer implements Serializable {
	private String name;
	private List<PhoneNumber> phoneNumbers;

	public Customer() {
        // Required default constructor for JAXB
    }
	
	public Customer(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<PhoneNumber> getPhoneNumbers() {
		if (phoneNumbers == null) {
			phoneNumbers = new ArrayList<>();
		}
		return phoneNumbers;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

}
