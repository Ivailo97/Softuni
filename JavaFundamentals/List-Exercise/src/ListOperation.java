import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        while (true) {
            String command = scanner.nextLine();

            if (command.equals("End")) {
                break;
            }

            String[] tokens = command.split(" ");
            String action = tokens[0];

            switch (action) {
                case "Add":
                    int number = Integer.parseInt(tokens[1]);
                    numbers.add(number);
                    break;

                case "Insert":
                    int element = Integer.parseInt(tokens[1]);
                    int position = Integer.parseInt(tokens[2]);

                    if (position < 0 || position >= numbers.size()) {
                        System.out.println("Invalid index");
                        continue;
                    }

                    numbers.add(position, element);
                    break;

                case "Remove":
                    int index = Integer.parseInt(tokens[1]);
                    if (index < 0 || index > numbers.size()) {
                        System.out.println("Invalid index");
                        continue;
                    }
                    numbers.remove(index);
                    break;

                case "Shift":
                    String direction = tokens[1];
                    int count = Integer.parseInt(tokens[2]);

                    if (direction.equals("left")) {
                        for (int i = 0; i < count % numbers.size(); i++) {
                            int temp = numbers.get(0);
                            numbers.remove(0);
                            numbers.add(temp);
                        }
                    } else if (direction.equals("right")) {
                        for (int i = 0; i < count % numbers.size(); i++) {
                            int temp = numbers.get(numbers.size() - 1);
                            numbers.remove(numbers.size() - 1);
                            numbers.add(0, temp);
                        }
                    }
                    break;
            }
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
