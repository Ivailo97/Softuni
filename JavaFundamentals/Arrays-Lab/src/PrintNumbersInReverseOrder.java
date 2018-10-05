import java.util.Scanner;

public class PrintNumbersInReverseOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] nums = new String[n];


        for (int i = 0; i < n; i++) {

            nums[n - 1 - i] = scanner.nextLine();
        }

        System.out.println(String.join(" ",nums));
    }
}
