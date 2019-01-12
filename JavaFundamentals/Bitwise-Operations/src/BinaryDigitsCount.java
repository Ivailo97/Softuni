import java.util.Scanner;

public class BinaryDigitsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        char bit = scanner.nextLine().charAt(0);

        String numberInBinaryReversed = "";
        String binaryResult = "";

        while (number != 0) {

            numberInBinaryReversed += String.valueOf(number % 2);
            number /= 2;
        }

        for (int i = numberInBinaryReversed.length() - 1; i >= 0; i--) {

            binaryResult += numberInBinaryReversed.charAt(i);
        }

        int count = 0;

        for (int i = 0; i < binaryResult.length(); i++) {

            if (binaryResult.charAt(i) == bit) {

                count++;
            }
        }

        System.out.println(count);
    }
}
