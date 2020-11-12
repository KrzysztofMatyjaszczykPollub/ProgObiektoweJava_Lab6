import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Zadanie6_2 {

    public static void drukujMenu() {
        System.out.println("====MENU====");
        System.out.println("1. Podaj liczbę");
        System.out.println("2. Oblicz iloraz cechy i mantysy");
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

    public static double wprowadzLiczbe() {
        double l = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Twoja liczba (xx,xx): ");
        try {
            l = sc.nextDouble();
            //System.out.println("Liczba: " + l);
        }
        catch (InputMismatchException e) {
            System.out.println("Nie podano liczby zmiennoprzecinkowej!");
            wprowadzLiczbe();
        }
        return l;
    }

    public static double obliczIloraz(double l) {
        int cecha = (int)l;
        double mantysa = l - cecha;
        //System.out.printf("Cecha: %d \tMantysa: %.3f\n", cecha, mantysa);
        try {
            if (mantysa == 0.0) {
                throw new ArithmeticException("Wystąpi dzielenie przez 0!");
            }
            else return cecha / mantysa;
        }
        catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            System.out.println("Wychodzę z funkcji z wartością 0...");
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("Witaj świecie!");
        double x = 1.1;
        byte wybor = 1;

        while (wybor != 3) {
            drukujMenu();
            wybor = podajWybor();
            switch (wybor) {
                case 1:
                    x = wprowadzLiczbe();
                    break;
                case 2:
                    System.out.printf("Wynik dzielenia cechy przez mantysę: %.3f\n", obliczIloraz(x));
                    break;
                default:
                    System.out.println("Zły wybór");
                    break;
            }
        }
        System.out.println("Do widzenia");
    }
}
