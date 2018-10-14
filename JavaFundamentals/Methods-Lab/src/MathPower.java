import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());
        double result = Power(number, power);

        DecimalFormat fm = new DecimalFormat("###.######");

        System.out.println(fm.format(result));
    }


    private static double Power(double number, int power) {

        double result = 0d;

        result = Math.pow(number,power);
        return result;

    }
}
