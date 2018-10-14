import java.util.Scanner;

public class MultiplyEvenByOds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int result = GetResult(n);

        System.out.println(result);
    }

    private static int GetResult(int n) {

        int evenSum = 0;
        int oddSum = 0;

        while ( n != 0){

            int digit = n % 10;

            if (digit % 2 == 0){

                evenSum += digit;
            }else {

                oddSum += digit;
            }

            n /= 10;
        }

        int result = evenSum * oddSum;

        return  result;

    }
}
