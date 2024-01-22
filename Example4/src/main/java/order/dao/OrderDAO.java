package order.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import order.entity.Order;
import order.entity.Product;
import order.entity.ShoppingCart;

public class OrderDAO {

	private static ArrayList<Order> orders = new ArrayList<>();

	public OrderDAO() {

	}

	static {
		// Creating sample products
		Product product1 = new Product("Laptop", 999.99, 2, "High-performance laptop");
		Product product2 = new Product("Mouse", 19.99, 5, "Wireless mouse");

		// Creating a shopping cart
		ArrayList<Product> productsInCart = new ArrayList<>();
		productsInCart.add(product1);
		productsInCart.add(product2);

		ShoppingCart shoppingCart = new ShoppingCart(productsInCart);

		// Creating an order with a sample orderId
		String sampleOrderId = "123456"; // You should use a unique identifier here
		Order order = new Order(sampleOrderId, shoppingCart.getProducts(), shoppingCart.calculateTotal(), "John Doe");
		orders.add(order);
	}

	public static ArrayList<Order> getAllOrders() {
		return orders;
	}

	public static boolean updateOrder(Order updatedOrder) {
		for (Order order : orders) {
			if (order.equals(updatedOrder)) {
				// Update order details
				order.setProducts(updatedOrder.getProducts());
				order.setTotalPrice(updatedOrder.getTotalPrice());
				order.setCustomerName(updatedOrder.getCustomerName());
				return true; // Successfully updated
			}
		}
		return false; // Order not found
	}

	public static boolean deleteOrder(String orderId) {
		Iterator<Order> iterator = orders.iterator();
		while (iterator.hasNext()) {
			Order order = iterator.next();
			if (order.getOrderId().equals(orderId)) {
				iterator.remove();
				return true;
			}
		}
		return false; // Order not found
	}

	public static List<Order> getOrdersByName(String name) {
		List<Order> result = new ArrayList<>();

		for (Order order : orders) {
			if (order.getCustomerName().equalsIgnoreCase(name)) {
				result.add(order);
			}
		}
		return result;
	}

}
