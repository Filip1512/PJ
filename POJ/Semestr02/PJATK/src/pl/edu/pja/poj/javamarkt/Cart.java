package pl.edu.pja.poj.javamarkt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cart {
	
	private List<Product> products = new ArrayList<>();

	public List<Product> getProducts() {
		return products;
	}

	public Product getCheapestProduct() {
		
		Product cheapest = null;
		
		for (Product product : products) {
			if (cheapest == null) {
				cheapest = product;
			} else {
				if (product.getPrice() < cheapest.getPrice()) {
					cheapest = product;
				}
			}
		}
		
		return cheapest;
	}
	
	public Product getMostExpensiveProduct() {
		
		Product mostExpensive = null;
		
		for (Product product : products) {
			if (mostExpensive == null) {
				mostExpensive = product;
			} else {
				if (product.getPrice() > mostExpensive.getPrice()) {
					mostExpensive = product;
				}
			}
		}
		
		return mostExpensive;
	}
	
	public List<Product> getNCheapestProducts(int n) {
		List<Product> cheapestProducts = new ArrayList<Product>();
		
		sortProducts();
		
		for (int i = 0; i < n; i++) {
			cheapestProducts.add(products.get(i));
		}
		
		return cheapestProducts;
	}
	
	public void sortProducts() {
		Comparator<Product> ascendingComparator = new ProductComparatorAscending();
		products.sort(ascendingComparator);
	}
	
	public void applyDiscount(ICanApplyDiscount discount) {
		if (discount.canApplyDiscount(this)) {
			discount.applyDiscount(this);
		}
	}
	
	public double getTotalPrice() {
		double totalPrice = 0;
		
		for (Product product : products) {
			totalPrice = totalPrice + product.getPrice();
		}
		
		return totalPrice;
	}
	
	public void displayInfo() {
		for (Product product : products) {
			System.out.println(product);
		}
	}
}
