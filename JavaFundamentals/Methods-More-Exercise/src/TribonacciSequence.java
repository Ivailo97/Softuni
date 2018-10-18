import java.util.Scanner;

public class TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        PrintTribonacci(n);
    }

    private static void PrintTribonacci(int i) {

        long f0 = 1;
        long f1 = 1;
        long f2 = 2;

        long f3 = f0 + f1 + f2;

        if (i == 1){

            System.out.println(1);
            return;
        }else if (i == 2){
            System.out.println( 1 + " " + 1);
            return;
        }

        System.out.printf("%d %d %d ", f0, f1, f2);

        for (int j = 1; j <= i - 3; j++) {

            System.out.printf("%d ", f3);

            f0 = f1;
            f1 = f2;
            f2 = f3;

            f3 = f0 + f1 + f2;
        }
    }
}
