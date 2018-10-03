import java.util.Scanner;

public class DataTypeFinder {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            String input = scanner.nextLine();

            if (input.equals("END")) {
                break;
            }

            boolean isNum = true;

            try {
                int num = Integer.parseInt(input);
            } catch (Exception e) {

                isNum = false;
            }

            boolean isDouble = true;

            try {
                double num = Double.parseDouble(input);

            } catch (Exception e) {
                isDouble = false;
            }

            if (isNum) {
                System.out.printf("%s is integer type%n",input);
            } else if (input.length() == 1) {
                System.out.printf("%s is character type%n",input);
            } else if (isDouble) {
                System.out.printf("%s is floating point type%n",input);
            } else if (input.equalsIgnoreCase("True")
                    || input.equalsIgnoreCase("False")) {
                System.out.printf("%s is boolean type%n",input);
            } else {
                System.out.printf("%s is string type%n",input);
            }
        }
    }
}



