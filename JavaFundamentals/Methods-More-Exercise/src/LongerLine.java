import java.util.Scanner;

public class LongerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());

        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());

        double x3 = Double.parseDouble(scanner.nextLine());
        double y3 = Double.parseDouble(scanner.nextLine());

        double x4 = Double.parseDouble(scanner.nextLine());
        double y4 = Double.parseDouble(scanner.nextLine());

        PrintLongerLine(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    static void PrintMinToCenter(double num1, double num2, double num3, double num4) {
        double sum1 = CalculatePythagorean(num1, num2);
        double sum2 = CalculatePythagorean(num3, num4);

        if (sum1 <= sum2) {
            System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", num1, num2, num3, num4);
        } else {
            System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", num3, num4, num1, num2);
        }
    }

    static double CalculatePythagorean(double x, double y) {
        double result = Math.sqrt(x * x + y * y);
        return result;
    }

    static void PrintLongerLine(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        double firstLine = CalculatePythagorean(Math.pow(x2 - x1, 2), Math.pow(y2 - y1, 2));
        double secondLine = CalculatePythagorean(Math.pow(x4 - x3, 2), Math.pow(y4 - y3, 2));

        if (firstLine >= secondLine) {
            PrintMinToCenter(x1, y1, x2, y2);
        } else {
            PrintMinToCenter(x3, y3, x4, y4);
        }
    }
}

