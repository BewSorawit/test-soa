package prob1;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.Marshaller;

public class JAXBExample {
	public static void main(String[] args) {
		// Path to your XML file
		String xmlFilePath = "C:\\Users\\User\\Desktop\\test-soa\\Lab2\\src\\main\\java\\prob1\\customer-jaxb.xml";

		try {
			// Create JAXB context and initialize Unmarshaller
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			// Unmarshal XML to object
			Customer customer = (Customer) jaxbUnmarshaller.unmarshal(new File(xmlFilePath));

			// Print the details
			System.out.println("Customer Name: " + customer.getName());
			List<PhoneNumber> phoneNumbers = customer.getPhoneNumbers();
			for (PhoneNumber phoneNumber : phoneNumbers) {
				System.out.println("Phone Number: " + phoneNumber.getNumber());
			}

			// If you want to marshal (convert object to XML)
			// Create JAXB context and initialize Marshaller
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// Convert object to XML and print to console
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(customer, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
