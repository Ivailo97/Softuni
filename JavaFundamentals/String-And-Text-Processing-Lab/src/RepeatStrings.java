import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split(" ");

        StringBuilder sb = new StringBuilder();

        for (String word : data) {

            for (int i = 0; i <word.length() ; i++) {

                sb.append(word);
            }
        }

        System.out.println(sb);
    }
}
