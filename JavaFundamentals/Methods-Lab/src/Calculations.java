import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String action = scanner.nextLine();

        int firstNum = Integer.parseInt(scanner.nextLine());
        int lastNum = Integer.parseInt(scanner.nextLine());

        PrintResult(action, firstNum, lastNum);
    }

    public static void PrintResult(String action, int num1, int num2) {

        switch (action) {

            case "add":
                System.out.println(num1 + num2);
                break;

            case "subtract":
                System.out.println(num1 - num2);
                break;

            case "multiply":
                System.out.println(num1 * num2);
                break;

            case "divide":
                System.out.println(num1 / num2);
                break;
        }
    }
}
