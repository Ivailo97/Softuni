import java.util.Scanner;

public class SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int sum = 0;
        int counter = 0;

        for (int i = 1; i <= 1000; i++) {

            if (i % 2 != 0) {
                counter++;
                sum += i;
                System.out.println(i);
            }

            if (counter == n) {
                break;
            }
        }

        System.out.printf("Sum: %d",sum);
    }
}
