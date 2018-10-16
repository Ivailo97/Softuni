import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOne = Integer.parseInt(scanner.nextLine());
        int numberTwo = Integer.parseInt(scanner.nextLine());

        long firstFactorialSum = GetFactorial(numberOne);
        long secondFactorialSum = GetFactorial(numberTwo);


        double result = firstFactorialSum / (secondFactorialSum * 1.00);
        System.out.printf("%.2f",result);

    }

    private static long GetFactorial(int numberOne) {
        long sum = 1;

        for (int i = 1; i <= numberOne; i++) {
            sum *= i;

        }

        return sum;
    }
}

