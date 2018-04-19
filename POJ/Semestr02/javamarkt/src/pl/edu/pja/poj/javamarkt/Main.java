package pl.edu.pja.poj.javamarkt;

public class Main {

	public static void main(String[] args) {
	
		Product product1 = new Product();
		product1.setCode("pr1");
		product1.setName("Product1");
		product1.setPrice(200);
		product1.setDiscountPrice(200);
		
		Product product2 = new Product("pr2", "Product2", 300, 300);
		Product product3 = new Product("pr3", "Product3", 30, 30);
		Product product4 = new Product("pr4", "Product4", 125, 125);
		Product product5 = new Product("pr5", "Product5", 600, 600);
		
		//System.out.println(product1);
		//System.out.println(product2);
		
		Cart cart = new Cart();
		cart.getProducts().add(product2);
		cart.getProducts().add(product1);
		cart.getProducts().add(product3);
		cart.getProducts().add(product4);
		cart.getProducts().add(product5);
		
		Product cheapest = cart.getCheapestProduct();
		System.out.println("Najtanszy produkt to: " + cheapest);
		
		Product mostExpensive = cart.getMostExpensiveProduct();
		System.out.println("Najdrozszy produkt to: " + mostExpensive);
		
		double totalPrice = cart.getTotalPrice();
		System.out.println("Calkowita cena koszyka: " + totalPrice);
		
		
		
		cart.sortProducts();
		
		cart.apply3rdForFreeDiscount();
		//cart.apply30PercentDiscount(null);
		//cart.apply200PlusMugDiscount();
		
		cart.displayInfo();
		
	}

}
