import java.util.Scanner;

public class MultiplyBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String num1AsString = scanner.nextLine();
        int num2 = Integer.parseInt(scanner.nextLine());

        if (num2 == 0)
        {
            System.out.println(0);
        }
        else
        {
            StringBuilder result = new StringBuilder();
            int remainder = 0;

            for (int i = num1AsString.length() - 1; i >= 0; i--)
            {
                int digit = Integer.parseInt(num1AsString.charAt(i) + "");
                int currentSum = num2 * digit + remainder;

                remainder = currentSum / 10;
                result.append(currentSum % 10);
            }

            result.append(remainder);
             String output = result.toString().replaceAll("0+$","");

            for (int i = output.length() - 1; i >= 0; i--)
            {
                System.out.print(output.charAt(i));
            }
        }
    }
}
