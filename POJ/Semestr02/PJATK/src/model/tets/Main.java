package model.tets;

public class Main {

	public static void main(String[] args) {
		// uruchamiamy program
		
		Figura kwadrat = new Kwadrat(5);
	//	kwadrat.setBok(10);
			
		Figura okrag = new Okrag(5);
		
		
		zrobCosZFigura(kwadrat);
		
		zrobCosZFigura(okrag);

		System.out.println("");
		

	}
	
	static void zrobCosZFigura(Figura figura){
		
		System.out.println(figura.obliczPole());
		
	}


}
