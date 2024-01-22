package th.ac.ku.kps.eng.cpe.dao;

import java.util.ArrayList;

import th.ac.ku.kps.eng.cpe.entity.Customer;
import th.ac.ku.kps.eng.cpe.entity.PhoneNumber;

public class CustomerDAO {
	private static ArrayList<Customer> listOfCustomers = new ArrayList<>();

	static {
		// Initial customers for demonstration
		Customer c1 = new Customer("Mr. Smith");
		Customer c2 = new Customer("Mrs. Smitch");
		c2.setPhoneNumbers(new ArrayList<>());
		c2.getPhoneNumbers().add(new PhoneNumber("9876543210"));

		listOfCustomers.add(c1);
		listOfCustomers.add(c2);
	}

	public CustomerDAO() {

	}

	public static ArrayList<Customer> getAllCustomers() {
		return listOfCustomers;
	}

	public static boolean updateCustomer(Customer updatedCustomer) {
		for (Customer customer : listOfCustomers) {
			if (customer.getName().equals(updatedCustomer.getName())) {
				// Update phone numbers
				customer.setPhoneNumbers(updatedCustomer.getPhoneNumbers());
				return true; // Successfully updated
			}
		}
		return false; // Customer not found
	}

	public static boolean patchCustomer(Customer patchedCustomer) {
		for (Customer customer : listOfCustomers) {
			if (customer.getName().equals(patchedCustomer.getName())) {
				// Apply partial updates (assuming phoneNumbers is the only property updated)
				
//				 if (patchedCustomer.getPhoneNumbers() != null) {
	                    customer.getPhoneNumbers().addAll(patchedCustomer.getPhoneNumbers());
//	                }
				return true; // Successfully patched
			}
		}
		return false; // Customer not found
	}

	public static boolean deleteCustomer(Customer customerToDelete) {
		for (Customer customer : listOfCustomers) {
			if (customer.getName().equals(customerToDelete.getName())) {
				listOfCustomers.remove(customer);
				return true; // Successfully deleted
			}
		}
		return false; // Customer not found
	}

}
