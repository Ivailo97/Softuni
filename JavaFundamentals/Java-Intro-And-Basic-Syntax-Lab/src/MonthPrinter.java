import java.util.Scanner;

public class MonthPrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] months = new String[]{"January", "February", "March", "April", "May", "June"
                , "July", "August", "September", "October", "November", "December"};

        int num = Integer.parseInt(scanner.nextLine());

        if (num > 12 || num < 1) {
            System.out.println("Error!");
        } else {
            System.out.println(months[num - 1]);
        }
    }
}
