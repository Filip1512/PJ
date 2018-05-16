package pl.edu.pja.poj.javamarkt;

public class Main {

	public static void main(String[] args) {
	
		Product product1 = new Product();
		product1.setCode("abc");
		product1.setName("Product1");
		product1.setPrice(200);
		product1.setDiscountPrice(200);
		
		Product product2 = new Product("def", "Product2", 300, 300);
		Product product3 = new Product("ghj", "Product3", 30, 30);
		
//		System.out.println(product1);
//		System.out.println(product2);
		
		Cart cart = new Cart();
		cart.getProducts().add(product2);
		cart.getProducts().add(product1);
		cart.getProducts().add(product3);
		
//		Product cheapest = cart.getCheapestProduct();
//		System.out.println("Najtanszy produkt to: " + cheapest);
//		
//		double totalPrice = cart.getTotalPrice();
//		System.out.println("Calkowita cena koszyka: " + totalPrice);
		
		cart.sortProducts();
		
		ICanApplyDiscount discount = new Discount300Plus();
		cart.applyDiscount(discount);
		
		
		
		cart.displayInfo();
		
	}

}
