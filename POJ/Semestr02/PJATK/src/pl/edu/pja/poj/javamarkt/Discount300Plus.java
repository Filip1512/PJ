package pl.edu.pja.poj.javamarkt;

public class Discount300Plus implements ICanApplyDiscount {

	@Override
	public boolean canApplyDiscount(Cart cart) {
		double totalPrice = cart.getTotalPrice();
		if (totalPrice < 300) {
			return false;
		}
		return true;
	}

	@Override
	public void applyDiscount(Cart cart) {
		for (Product product : cart.getProducts()) {
			double discountPrice = product.getPrice() * 0.95;
			product.setDiscountPrice(discountPrice);
		}
	}

}
