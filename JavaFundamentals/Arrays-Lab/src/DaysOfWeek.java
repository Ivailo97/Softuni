import java.util.Scanner;

public class DaysOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        String[] arr = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };

        if (number <= 7 && number >= 1)
        {
            System.out.println(arr[number-1]);
        }
        else
        {
            System.out.println("Invalid day!");
        }
    }
}
