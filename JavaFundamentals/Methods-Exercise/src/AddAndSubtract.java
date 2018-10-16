import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        int sumFirstPair = GetSum(num1, num2);
        int result = Subtract(sumFirstPair, num3);

        System.out.println((result));
    }

    private static int Subtract(int sumFirstPair, int num) {
        return sumFirstPair - num;
    }

    private static int GetSum(int num1, int num2) {
        return num1 + num2;
    }
}

