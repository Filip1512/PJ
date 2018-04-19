import java.util.Scanner;

public class LoanApplication {

	public static void main(String[] args) {
		
		Scanner klawiatura = new Scanner (System.in);
		
		System.out.println("Podaj imie: ");
		String firstName = klawiatura.nextLine();
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
		
		System.out.println("Podaj plec (M/K): ");
		String gender = klawiatura.nextLine();
		
		System.out.println(firstName);
		System.out.println(surname);
		System.out.println(pesel);
		System.out.println(nip);
		System.out.println(bankAccountNumber);
		System.out.println(dateOfBirth);
		System.out.println(gender);
		
		
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

