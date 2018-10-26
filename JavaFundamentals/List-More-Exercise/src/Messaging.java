import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String text = scanner.nextLine();
        char[] textAsArray = text.toCharArray();
        List<Character> chars = new ArrayList<>();

        for (char symbol : textAsArray) {
            chars.add(symbol);
        }

        for (int num : numbers) {

            int sum = 0;
            int number = num;

            while (number != 0) {
                sum += number % 10;
                number /= 10;
            }

            int index = sum % text.length();
            System.out.print(text.charAt(index));
            chars.remove(index);

            text = "";

            for (Character symbol : chars) {
                text += symbol;
            }
        }
        System.out.println();
    }
}

