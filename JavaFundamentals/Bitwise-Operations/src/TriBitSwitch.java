import java.util.Scanner;

public class TriBitSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int position = Integer.parseInt(scanner.nextLine());

        int mask = 7 << position; // 1 1 1

        int result = number ^ mask;

        System.out.println(result);
    }
}
