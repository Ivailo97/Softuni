import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        String reversed = "";

        for (int i = 0; i < word.length(); i++) {

            reversed += word.charAt(word.length() - 1 - i);
        }

        System.out.println(reversed);
    }
}
