import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        Print(text,n);
    }

    private static void Print(String text, int n) {

        for (int i = 0; i <n ; i++) {

            System.out.print(text);
        }
    }
}
