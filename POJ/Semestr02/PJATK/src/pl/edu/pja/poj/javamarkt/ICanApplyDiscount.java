package pl.edu.pja.poj.javamarkt;

public interface ICanApplyDiscount {
	boolean canApplyDiscount(Cart cart);
	void applyDiscount(Cart cart);
}
