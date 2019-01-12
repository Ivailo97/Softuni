import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] banned = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String word : banned) {

             text = text.replace(word,newString('*',word.length()));
        }

        System.out.println(text);
    }

    public static String newString(char symbol, int number){

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < number; i++) {

            sb.append(symbol);
        }

        return sb.toString();
    }
}
