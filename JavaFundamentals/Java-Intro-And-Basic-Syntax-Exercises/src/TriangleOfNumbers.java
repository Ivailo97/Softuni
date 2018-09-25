import java.util.Scanner;

public class TriangleOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String input = Integer.toString(i);
            Print(input + " ", i);

        }
    }

    private static void Print(String input, int times) {
        for (int i = 0; i < times; i++) {
            System.out.print(input);
        }

        System.out.println();
    }
}
