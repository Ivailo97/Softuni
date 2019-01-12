import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .sorted((n1,n2) -> n2.compareTo(n1)).collect(Collectors.toList());

        int end = Math.min(3, numbers.size());

        for (int i = 0; i < end; i++) {

            System.out.print(numbers.get(i) + " ");
        }
    }
}
