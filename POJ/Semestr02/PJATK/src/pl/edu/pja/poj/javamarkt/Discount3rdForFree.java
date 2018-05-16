package pl.edu.pja.poj.javamarkt;

public class Discount3rdForFree implements ICanApplyDiscount {

	@Override
	public boolean canApplyDiscount(Cart cart) {
		if (cart.getProducts().size() < 3) {
			return false;
		}
		return true;
	}

	@Override
	public void applyDiscount(Cart cart) {
		Product cheapest = cart.getCheapestProduct();
		cheapest.setDiscountPrice(0);
	}

}
