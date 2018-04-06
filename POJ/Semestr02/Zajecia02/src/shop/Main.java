package shop;

public class Main {

    public static void main(String[] args) {

        Product product1 = new Product();
        product1.setCode("a");
        product1.setName("Product1");
        product1.setPrice(10);
        product1.setDiscountPrice(10);
        
        Product product2 = new Product("b", "Product2", 88, 88);
        Product product3 = new Product("c", "Product3", 37, 37);
        Product product4 = new Product("d", "Product4", 121, 121);
        Product product5 = new Product("e", "Product5", 99, 99);
        
        System.out.println(product1);
        System.out.println(product2);

        Cart cart = new Cart();
        cart.getProducts().add(product1);
        cart.getProducts().add(product2);
        cart.getProducts().add(product3);
        cart.getProducts().add(product4);
        cart.getProducts().add(product5);
        Product cheapest = cart.getCheapestProduct();

        System.out.println("Najtanszy produkt to: " + cheapest);

        double totalPrice = cart.getTotalPrice();
        System.out.println("Calkowita cena koszyka: " + totalPrice);
        cart.displayInfo();
    }
}