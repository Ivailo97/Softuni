import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstNum = Double.parseDouble(scanner.nextLine());
        String action = scanner.nextLine();
        double lastNum = Double.parseDouble(scanner.nextLine());

        PrintResult(firstNum,action,lastNum);
    }

    private static void PrintResult(double firstNum, String action, double lastNum) {

        double sum = 0;
        switch (action){
            case "/":
                sum = firstNum / lastNum;
                break;
            case "*":
                sum = firstNum * lastNum;
                break;
            case "+":
               sum = firstNum + lastNum;
               break;
            case "-":
                sum = firstNum - lastNum;
                break;
        }

        System.out.printf("%d",Math.round(sum));
    }
}
