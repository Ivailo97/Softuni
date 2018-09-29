import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= num; i++) {
            int sum = 0;
            int copy = i;

            while (copy != 0) {
                int lastDigit = copy % 10;
                copy /= 10;
                sum += lastDigit;
            }

            boolean flag = false;

            if (sum == 5 || sum == 7 || sum == 11) {
                flag = true;
            }

            if (flag){

                System.out.printf("%d -> True%n", i);
            }else {
                System.out.printf("%d -> False%n", i);
            }
        }
    }
}
