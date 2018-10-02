import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long startingYield = Long.parseLong(scanner.nextLine());

        int days = 0;
        long res = 0;

        while (startingYield >= 100) {

            res += startingYield;
            days++;
            startingYield -= 10;
            res -= 26;
        }

        if (days > 0) {
            res -= 26;
        }

        System.out.println(days);
        System.out.println(res);
    }
}
