package prob1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import jakarta.xml.bind.*;

public class JAXBGenerateObject {
	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream(
					"C:\\Users\\User\\Desktop\\test-soa\\Lab2\\src\\main\\java\\prob1\\customer-jaxb.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Customer cus = (Customer) jaxbUnmarshaller.unmarshal(is);
			System.out.println("Customer Name: " + cus.getName());
			ArrayList<PhoneNumber> phoneList = (ArrayList<PhoneNumber>) cus.getPhoneNumbers();
			
			for (PhoneNumber p : phoneList) {
				System.out.println("phone number Id: " + p.getNumber());
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
