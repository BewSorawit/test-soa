package order.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {
	@JsonProperty("orderId")
	private String orderId; // Assuming orderId is a unique identifier
	@JsonProperty("products")
	private ArrayList<Product> products;
	@JsonProperty("totalPrice")
	private double totalPrice;
	@JsonProperty("customerName")
	private String customerName; // Assume customer name for simplicity

	public Order() {
		super();
	}

	public Order(String orderId, ArrayList<Product> products, double totalPrice, String customerName) {
		this.orderId = orderId;
		this.products = products;
		this.totalPrice = totalPrice;
		this.customerName = customerName;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(orderId, other.orderId);
	}
}
