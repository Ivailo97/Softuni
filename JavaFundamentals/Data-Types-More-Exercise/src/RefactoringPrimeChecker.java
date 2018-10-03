import java.util.Scanner;

public class RefactoringPrimeChecker {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int end = Integer.parseInt(scanner.nextLine());

        for (int i = 2; i <= end; i++) {
            boolean isPrime = true;

            for (int k = 2; k < i; k++) {
                if (i % k == 0) {
                    isPrime = false;
                    break;
                }
            }

            System.out.printf("%d -> %s%n", i, isPrime);
        }
    }
}
