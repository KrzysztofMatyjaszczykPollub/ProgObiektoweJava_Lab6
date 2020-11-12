
import java.util.InputMismatchException;
import java.util.Scanner;

public class Zadanie6_3 {

    public static void drukujMenu() {
        System.out.println("====MENU====");
        System.out.println("1. Podaj liczbę");
        System.out.println("2. Oblicz sumę kwadratów cyfr");
        System.out.println("3. Wyjście");
    }

    public static byte podajWybor() {
        byte w = 1;
        Scanner sc = new Scanner(System.in);
        System.out.print("Twoj wybor: ");
        try {
            w = sc.nextByte();
        }
        catch (InputMismatchException e) {
            System.out.println("Podano złą wartość wyboru!");
            podajWybor();
        }
        return w;
    }

    public static int wprowadzLiczbe() {
        int l = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Twoja liczba (zakres <99,999>): ");
        try {
            l = sc.nextInt();
            if ((l < 99) || (l > 999)) throw new Exception("Liczba nie mieści się w zakresie!");
            System.out.println("Liczba: " + l);
        }
        catch (InputMismatchException e) {
            System.out.println("Nie podano liczby całkowitej!");
            wprowadzLiczbe();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            wprowadzLiczbe();
        }
        return l;
    }

    public static int obliczKwadraty(int l) {
        int suma = 0;
        int liczbaCyfr = String.valueOf(l).length();
        System.out.println("Długość liczby: " + liczbaCyfr);
        int[] tabCyfr = new int [liczbaCyfr];
        for (int i = 0; i < liczbaCyfr; i++) {
            tabCyfr[i] = l % 10;
            l = l / 10;
            tabCyfr[i] = tabCyfr[i] * tabCyfr[i];
            suma += tabCyfr[i];
        }
        return suma;
    }

    public static void main(String[] args) {
        System.out.println("Witaj świecie!");
        int x = 1;
        byte wybor = 1;

        while (wybor != 3) {
            drukujMenu();
            wybor = podajWybor();
            switch (wybor) {
                case 1:
                    x = wprowadzLiczbe();
                    break;
                case 2:
                    System.out.printf("Wynik sumy kwadratów cyfr: %d\n", obliczKwadraty(x));
                    break;
                default:
                    System.out.println("Zły wybór");
                    break;
            }
        }
        System.out.println("Do widzenia");
    }
}
