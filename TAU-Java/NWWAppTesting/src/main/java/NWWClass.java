import java.util.InputMismatchException;
import java.util.Scanner;

public class NWWClass {
    public static int nwd(int x, int y) {
        while (x != y) {
            if (x > y)
                x -= y;
            else
                y -= x;
        }
        return x;
    }

    public static int nww(int x, int y) {
        return (x * y) / nwd(x,y);
    }

    public static void main(String[] args) {
        int x,y;
        try {
            Scanner sc = new Scanner(System.in);
            //Pobieramy pierwsza liczbe
            System.out.print("Podaj pierwsza liczbe: ");
            x = sc.nextInt();
            //Pobieramy druga liczbe
            System.out.print("Podaj druga liczbe: ");
            y = sc.nextInt();
            if (x < 1 || y < 1){
                throw new IllegalArgumentException();
            }
            //Wyswietlamy NWW
            System.out.print("NWW liczb " + x + " i " + y + " wynosi: " + nww(x, y));
        }
        catch (InputMismatchException e){
            System.out.print("To nie jest liczba!");
        }
        catch (IllegalArgumentException e){
            System.out.print("Liczba musi być większa niż 1!");
        }
    }
}