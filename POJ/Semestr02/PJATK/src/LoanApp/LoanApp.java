package LoanApp;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class LoanApplication {

	public static void main(String[] args) {
		
		Scanner klawiatura = new Scanner (System.in);
		Pattern compiledPattern = Pattern.compile("[A-Z][a-z]+");
		Matcher matcher = compiledPattern.matcher(klawiatura.nextLine());
		
		
		System.out.println("Podaj imie: ");
		String firstName = matcher();
		System.out.println("Podaj nazwisko: ");
		String surname = klawiatura.nextLine();
		
		System.out.println("Podaj PESEL: ");
		String pesel = klawiatura.nextLine();
		
		System.out.println("Podaj NIP: ");
		String nip = klawiatura.nextLine();
		
		System.out.println("Podaj numer konta: ");
		String bankAccountNumber = klawiatura.nextLine();
		
		System.out.println("Podaj date urodzenia (format DD-MM-RRRR): ");
		String dateOfBirth = klawiatura.nextLine();
		String day = dateOfBirth.substring(0,2);
		String month = dateOfBirth.substring(3,5);
		String year = dateOfBirth.substring(6,10);
		
		//String gender;
		//do {
		System.out.println("Podaj plec (M/K): ");
		String gender = klawiatura.nextLine();
		//} while (gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("K"));
			
		System.out.println("Imie: " + firstName);
		System.out.println("Nazwisko: " + surname);
		System.out.println("PESEL: " + pesel);
		System.out.println("NIP: " + nip);
		System.out.println("Nr. konta bankowego: " + bankAccountNumber);
		System.out.println("Data urodzenia: " + day + "-" + month + "-" + year);
		System.out.println("Plec: " + gender);
		
		
		}
	

 /*	public void validate(String dane) {
		switch(dane) {
		case "firstName":
		case "surname":
			System.out.println("");
		case "pesel":
		case "nip":
		case "bankAccountNumber":
		case "dateOfBirth":
		case "gender":	
		}
	}	*/
	
	
}

