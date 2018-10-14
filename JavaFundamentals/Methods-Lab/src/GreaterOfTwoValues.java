import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine().toLowerCase();

        switch (type){
            case "int":
                long num1 = Long.parseLong(scanner.nextLine());
                long num2 = Long.parseLong(scanner.nextLine());
                PrintMaxInt(num1,num2);
                break;
            case "char":
                char symbol1 = scanner.nextLine().charAt(0);
                char symbol2 = scanner.nextLine().charAt(0);
                PrintMaxChar(symbol1,symbol2);
                break;
            case "string":
                String text1 = scanner.nextLine();
                String text2 = scanner.nextLine();
                PrintMaxString(text1,text2);
                break;
        }
    }

    private static void PrintMaxString(String text1, String text2) {
        if (text1.compareTo(text2) >= 0){
            System.out.println(text1);
        }else {
            System.out.println(text2);
        }
    }

    private static void PrintMaxChar(char symbol1, char symbol2) {

        if ((int)symbol1 > (int)symbol2){
            System.out.println(symbol1);
        }else {
            System.out.println(symbol2);
        }
    }

    private static void PrintMaxInt(long num1, long num2) {

        if (num1 > num2){
            System.out.println(num1);
        }else {
            System.out.println(num2);
        }

    }
}
