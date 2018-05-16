package tets;

/*
 * 
 * obliczane pole i obwod
 */
public class Kwadrat implements Figura, InnaInterfejs { 
	
	private int bok;
	
	
	public Kwadrat(int bok) {
		this.bok = bok;
	} 

	@Override
	public int obliczObwod() {
		return 4 * bok;
	}

	@Override
	public int obliczPole() {
		return bok*bok;
	}
	
	public void innaMetoda(){
		System.out.println("inna metoda");
	}

	public int getBok() {
		return bok;
	}

	public void setBok(int bok) {
		this.bok = bok;
	}

	@Override
	public void metodaKtoraNieMaNicWspolnegoZObwodemItp() {
		// TODO Auto-generated method stub
		
	}
	
	

}
