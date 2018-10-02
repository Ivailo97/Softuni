import java.util.Scanner;

public class DolarsToPounds {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Double pounds = Double.parseDouble(scanner.nextLine());

        Double dollars = pounds * 1.31;

        System.out.printf("%.3f",dollars);
    }
}
