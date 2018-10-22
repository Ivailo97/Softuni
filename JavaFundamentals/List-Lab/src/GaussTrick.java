import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Long> numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Long::parseLong)
                .collect(Collectors.toList());

        int len = numbers.size() / 2;

        for (int i = 0; i < len; i++) {

            numbers.set(i, numbers.get(i) + numbers.get(numbers.size() - 1));
            numbers.remove(numbers.size() - 1);
        }

        String result = JoinNumbersByDelimiter(numbers, " ");
        System.out.println(result);
    }

    public static String JoinNumbersByDelimiter(List<Long> numbers, String delimiter) {

        String result = "";

        for (int i = 0; i < numbers.size(); i++) {

            if (i != numbers.size() - 1) {
                result += numbers.get(i) + delimiter;
            } else {
                result += numbers.get(i);
            }
        }

        return result;
    }
}
