package order.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
	@JsonProperty("name")
	private String name;

	@JsonProperty("price")
	private double price;

	@JsonProperty("quantity")
	private int quantity;

	@JsonProperty("description")
	private String description;

	public Product() {
		super();
	}

	public Product(String name, double price, int quantity, String description) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
