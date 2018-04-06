package shop;

import java.util.ArrayList;
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