import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fn = Integer.parseInt(scanner.nextLine());

        if (fn == 0){
            System.out.println(0);
            return;
        }
        long f0 = 1;
        long f1 = 1;

        while (fn > 2) {

            long sum = f0 + f1;

            f0 = f1;
            f1 = sum;

            fn--;
        }

        System.out.println(f1);

    }
}
