import java.util.InputMismatchException;
import java.util.Scanner;

public class Zadanie6_1 {

    public static void drukujMenu() {
        System.out.println("===MENU===");
        System.out.println("1. Wczytaj liczbe x");
        System.out.println("2. Wczytaj liczbe y");
        System.out.println("3. x + y");
        System.out.println("4. x - y");
        System.out.println("5. x * y");
        System.out.println("6. x / y");
        System.out.println("7. x ^ y");
        System.out.println("8. sqrt(x)");
        System.out.println("9. Wyjście z programu");
    }

    public static void kalkulator() {
        Scanner sc = new Scanner(System.in);
        double x = 0, y = 0;
        short wybor = 1;
        while (wybor != 9) {
            try {
                drukujMenu();
                System.out.print("Twój wybór: ");
                wybor = sc.nextShort();
                switch (wybor) {
                    case 1 : //Wczytaj liczbe x
                        System.out.print("Podaj x: ");
                        x = sc.nextInt();
                        System.out.println("Wczytano liczbę X");
                        break;
                    case 2: //Wczytaj liczbe y
                        System.out.print("Podaj y: ");
                        y = sc.nextInt();
                        System.out.println("Wczytano liczbę Y");
                        break;
                    case 3: //x + y
                        System.out.println(x + " + " + y + " = " + (x+y));
                        break;
                    case 4: //x - y
                        System.out.println(x + " - " + y + " = " + (x-y));
                        break;
                    case 5: //x * y
                        System.out.println(x + " * " + y + " = " + x*y);
                        break;
                    case 6: //x / y
                        if (y == 0) {
                            throw new ArithmeticException("Błąd przy mianowniku!");
                        }
                        else {
                            System.out.println(x + " / " + y + " = " + x/y);
                        }
                        break;
                    case 7: //x ^ y
                        System.out.println(x + " ^ " + y + " = " + Math.pow(x, y));
                        break;
                    case 8: //sqrt(x)
                        if (x < 0) {
                            throw new ArithmeticException("Błąd! Niemożliwy pierwiastek z liczby ujemnej!");
                        }
                        else {
                            System.out.println("sqrt(x) = " + Math.sqrt(x));
                        }
                        break;
                    default: //zły wybór
                        System.out.println("Zły wybór!");
                        break;
                }
            }
            catch (ArithmeticException e) {
                System.out.println(e.getMessage());
                //e.printStackTrace();
                System.out.println("Resetuję program...");
                kalkulator();
            }
            catch (InputMismatchException e) {
                System.out.println("Błąd przy wprowadzaniu danych");
                System.out.println("Resetuję program...");
                kalkulator();
            }
        }
        System.out.println("Do widzenia");
    }

    public static void main(String[] args) {
        kalkulator();
    }
}
