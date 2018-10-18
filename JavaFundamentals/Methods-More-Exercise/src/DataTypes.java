import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();

        switch (type) {
            case "string":
                String input = scanner.nextLine();
                PrintResult(input);
                break;
            case "real":
                double number = Double.parseDouble(scanner.nextLine());
                PrintResult(number);
                break;
            case "int":
                int num = Integer.parseInt(scanner.nextLine());
                PrintResult(num);
                break;
        }

    }

    private static void PrintResult(double number) {

        System.out.printf("%.2f%n", number * 1.5);

    }

    private static void PrintResult(int number) {

        System.out.println(number * 2);
    }

    private static void PrintResult(String input) {

        System.out.printf("$%s$%n", input);
    }
}
