import java.util.Scanner;

public class CharsInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char start = scanner.nextLine().charAt(0);
        char end = scanner.nextLine().charAt(0);

        PrintRange(start, end);
    }

    private static void PrintRange(char start, char end) {
        if (start > end) {
            char temp = start;
            start = end;
            end = temp;

        }
        for (int i = start + 1; i < end; i++) {
            System.out.print((char) i + " ");
        }
    }
}

