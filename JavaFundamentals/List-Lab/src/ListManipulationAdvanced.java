import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        String command = scanner.nextLine();

        while (!command.equals("end")) {

            String[] tokens = command.split(" ");
            String action = tokens[0];
            switch (action) {
                case "Contains":
                    int numberToCheck = Integer.parseInt(tokens[1]);

                    boolean contains = numbers.contains(numberToCheck);

                    if (numbers.contains(numberToCheck)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    if (tokens[1].equals("even")) {

                        List<Integer> evenNumbers = numbers.stream()
                                .filter(x -> x % 2 == 0)
                                .collect(Collectors.toList());

                        System.out.println(evenNumbers.toString().replaceAll("[\\[\\],]", ""));
                    } else {

                        List<Integer> oddNumbers = numbers.stream()
                                .filter(x -> x % 2 != 0)
                                .collect(Collectors.toList());

                        System.out.println(oddNumbers.toString().replaceAll("[\\[\\],]", ""));
                    }
                    break;
                case "Get":
                    System.out.println(numbers.stream().mapToInt(x -> x).sum());
                    break;
                case "Filter":
                    String condition = tokens[1];
                    int numToCompare = Integer.parseInt(tokens[2]);
                    List<Integer> filtered = new ArrayList<>();

                    if (condition.equals(">=")) {
                        filtered = numbers.stream().filter(x -> x >= numToCompare).collect(Collectors.toList());
                    } else if (condition.equals("<=")) {
                        filtered = numbers.stream().filter(x -> x <= numToCompare).collect(Collectors.toList());
                    } else if (condition.equals("<")) {
                        filtered = numbers.stream().filter(x -> x < numToCompare).collect(Collectors.toList());
                    }else if (condition.equals(">")){
                        filtered = numbers.stream().filter(x -> x > numToCompare).collect(Collectors.toList());
                    }

                    System.out.println(filtered.toString().replaceAll("[\\[\\],]",""));
                    break;

            }
            command = scanner.nextLine();
        }
    }
}
