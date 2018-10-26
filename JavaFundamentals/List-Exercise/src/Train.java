import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        int maxCount = Integer.parseInt(scanner.nextLine());

        while (true) {
            String command = scanner.nextLine();

            if (command.equals("end")) {
                break;
            }

            String[] tokens = command.split("\\s+");

            if (tokens[0].equals("Add")) {

                wagons.add(Integer.parseInt(tokens[1]));

            } else {

                int passengers = Integer.parseInt(tokens[0]);

                for (int i = 0; i < wagons.size(); i++) {

                    if (wagons.get(i) + passengers <= maxCount) {

                        wagons.set(i, wagons.get(i) + passengers);
                        break;
                    }
                }
            }
        }
        System.out.println(wagons.toString().replaceAll("[\\[\\],]",""));
    }
}
