package pl.edu.pja.poj.javamarkt;

public class Discount200PlusMug implements ICanApplyDiscount {

	@Override
	public boolean canApplyDiscount(Cart cart) {
		double totalPrice = cart.getTotalPrice();
		if (totalPrice < 200) {
			return false;
		}
		return true;
	}

	@Override
	public void applyDiscount(Cart cart) {
		Product mug = new Product("mug", "Mug", 0, 0);
		cart.getProducts().add(mug);
	}

}
