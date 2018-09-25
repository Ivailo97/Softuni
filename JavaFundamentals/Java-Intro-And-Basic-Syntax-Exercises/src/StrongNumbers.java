import java.util.Scanner;

public class StrongNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int numberCopy = number;

        int sum = 0;

        while (numberCopy != 0) {
            int digit = numberCopy % 10;
            numberCopy /= 10;

            int current = 1;

            for (int i = digit; i >= 1; i--) {
                current *= i;
            }

            sum += current;
        }

        if (sum == number) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
