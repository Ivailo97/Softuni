import java.util.Scanner;

public class NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        PrintMatrix(n);
    }

    private static void PrintMatrix(int n) {
        for (int i = 0; i < n; i++) {
            RepeatString(n);
            System.out.println();
        }
    }

    private static void RepeatString(int number) {
        for (int i = 0; i < number; i++) {
            System.out.print(number + " ");

        }
    }
}

