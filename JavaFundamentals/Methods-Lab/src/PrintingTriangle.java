import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        PrintTriangle(n);
    }

    private static void PrintTriangle(int n) {

        for (int i = 1; i <= n; i++) {

            for (int j = 0; j < i; j++) {

                System.out.print(j + 1 + " ");

            }
            System.out.println();
        }

        for (int i = n - 1; i > 0; i--) {

            for (int j = 1; j <= i; j++) {

                System.out.print( j  + " ");
            }

            System.out.println();
        }
    }
}
