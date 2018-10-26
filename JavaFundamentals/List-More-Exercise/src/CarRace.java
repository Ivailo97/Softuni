import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        double leftSum = 0;
        double rightSum = 0;

        for (int i = 0; i < numbers.size() / 2; i++) {

            if (numbers.get(i) == 0) {
                leftSum *= 0.8;
            }

            leftSum += numbers.get(i);

            if (numbers.get(numbers.size() - 1 - i) == 0) {
                rightSum *= 0.8;
            }

            rightSum += numbers.get(numbers.size() - 1 - i);
        }

        if (leftSum < rightSum) {
            System.out.printf("The winner is left with total time: %.1f%n", leftSum);
        } else {
            System.out.printf("The winner is right with total time: %.1f%n", rightSum);
        }
    }
}
