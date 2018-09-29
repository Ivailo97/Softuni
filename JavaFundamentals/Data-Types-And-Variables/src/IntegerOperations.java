import java.math.BigInteger;
import java.util.Scanner;

public class IntegerOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger num1 = new BigInteger(scanner.nextLine());
        BigInteger num2 = new BigInteger(scanner.nextLine());
        BigInteger num3 = new BigInteger(scanner.nextLine());
        BigInteger num4 = new BigInteger(scanner.nextLine());

        BigInteger sum = ((num1.add(num2)).divide(num3)).multiply(num4);

        System.out.println(sum);
    }
}
