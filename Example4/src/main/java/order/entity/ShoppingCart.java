package order.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShoppingCart {
	@JsonProperty("products")
	private ArrayList<Product> products;

	public ShoppingCart() {
		super();
	}

	public ShoppingCart(ArrayList<Product> products) {
		super();
		this.products = products;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public double calculateTotal() {
		double total = 0;
		for (Product product : products) {
			total += product.getPrice() * product.getQuantity();
		}
		return total;
	}

}
