import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int diviser = 0;

        if (num % 10 == 0) {
            diviser = 10;
        } else if (num % 7 == 0) {
            diviser = 7;
        } else if (num % 6 == 0) {
            diviser = 6;
        } else if (num % 3 == 0) {
            diviser = 3;
        } else if (num % 2 == 0) {
            diviser = 2;
        }

        if (diviser == 0) {
            System.out.println("Not divisible");
        } else {
            System.out.printf("The number is divisible by %d", diviser);
        }
    }
}
