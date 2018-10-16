import java.util.Scanner;

public class MiddleCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        PrintMiddle(text);
    }

    private static void PrintMiddle(String text) {
        if (text.length() % 2 == 0) {
            System.out.println((text.charAt(text.length() / 2 - 1) + "" + text.charAt(text.length() / 2)));
        } else {
            System.out.println((text.charAt(text.length() / 2)));
        }
    }
}
