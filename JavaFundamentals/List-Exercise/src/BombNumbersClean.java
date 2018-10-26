import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbersClean {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String[] tokens = scanner.nextLine().split("\\s+");

        int bomb = Integer.parseInt(tokens[0]);
        int power = Integer.parseInt(tokens[1]);

        while (numbers.contains(bomb)){

            int index = numbers.indexOf(bomb);
            int left = index - power;
            int right = index + power;

            left = Math.max(left, 0);
            right = Math.min(right,numbers.size() - 1);

            numbers.subList(left,right + 1).clear();

        }

        System.out.println(numbers.stream().mapToInt(x->x).sum());
    }
}
