package model.tets;

public class Okrag implements Figura{

	private int promien;

	public Okrag(int promien) {
		super();
		this.promien = promien;
	}

	@Override
	public int obliczObwod() {
		return (int) (2 * promien * Math.PI);
	}

	@Override
	public int obliczPole() {
		return (int) (Math.PI * promien * promien);
	}

}
