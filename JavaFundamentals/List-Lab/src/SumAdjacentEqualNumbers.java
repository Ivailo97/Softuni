import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        for (int i = 1; i < numbers.size(); i++) {

            if (numbers.get(i).equals(numbers.get(i - 1))) {

                numbers.set(i - 1, 2 * numbers.get(i));
                numbers.remove(i);
                i  = 0;

            }
        }

        String joined = JoinNumbersByDelimiter(numbers, " ");
        System.out.println(joined);
    }

    public static String JoinNumbersByDelimiter(List<Double> numbers, String delimiter) {

        String result = "";

        for (int i = 0; i < numbers.size(); i++) {

            if (i != numbers.size() - 1) {
                result += new DecimalFormat("0.#").format(numbers.get(i)) + delimiter;
            } else {
                result += new DecimalFormat("0.#").format(numbers.get(i));
            }
        }

        return result;
    }
}
