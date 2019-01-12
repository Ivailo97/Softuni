import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ASCIISimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char first = scanner.nextLine().charAt(0);
        char last = scanner.nextLine().charAt(0);
        String text = scanner.nextLine();

        int sum = 0;

        if (last < first) {

            char temp = first;
            first = last;
            last = temp;
        }

        first += 1;

        List<Character> symbols = new ArrayList<>();

        for (char i = first; i < last; i++) {

            symbols.add(i);

        }

        for (int i = 0; i < text.length(); i++) {

            if (symbols.contains(text.charAt(i))) {

                sum += text.charAt(i);
            }
        }

        System.out.println(sum);

    }
}
