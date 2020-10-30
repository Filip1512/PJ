package zad01;

import java.util.Scanner;

public class NWW {
 
	public int nwd(int x, int y) {
		while (x != y) {
		if (x > y)
			x -= y;
		else
			y -= x;
		}
		return x;
	}
	
	public int nww;

	int x,y;
	 
	Scanner sc = new Scanner(System.in);
	
	System.out.print("Podaj pierwsza liczbe: ");
	x = sc.nextInt();
	
	System.out.print("Podaj druga liczbe: ");
	y = sc.nextInt();
	
	System.out.println("NWW liczb " + x + " i " + y + " wynosi: " + ((x*y)/nwd(x,y));
	}
}