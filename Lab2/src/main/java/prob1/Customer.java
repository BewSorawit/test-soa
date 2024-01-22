package prob1;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

// จำเป็นต้องมี RootElement
@XmlRootElement
public class Customer {
	private String name;
	private List<PhoneNumber> phoneNumbers;

	public Customer() {
		super();
		this.phoneNumbers = new ArrayList<PhoneNumber>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "phone-number")
	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

}
