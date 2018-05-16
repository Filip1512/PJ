package pl.edu.pja.poj.javamarkt;

public class Discount30PercentForGivenProduct implements ICanApplyDiscount {
	
	private Product discountedProduct;
	
	public Discount30PercentForGivenProduct(Product discountedProduct) {
		this.discountedProduct = discountedProduct;
	}

	@Override
	public boolean canApplyDiscount(Cart cart) {
		if (discountedProduct == null) {
			return false;
		}
		return true;
	}

	@Override
	public void applyDiscount(Cart cart) {
		double discountPrice = discountedProduct.getPrice() * 0.7;
		discountedProduct.setDiscountPrice(discountPrice);
	}

}
