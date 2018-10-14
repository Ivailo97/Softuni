import java.util.Scanner;

public class SignOfInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String type = GetType(n);

        System.out.printf("The number %d is %s.",n,type);
    }

    private static String GetType(int n) {

        if (n > 0) {
            return "positive";
        } else if (n < 0) {

            return "negative";
        } else {
            return "zero";
        }
    }
}
