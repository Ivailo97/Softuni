import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine()
                .split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        while (true) {
            String command = scanner.nextLine();

            if (command.equals("end")) {
                break;
            }

            String[] tokens = command.split("\\s+");
            String action = tokens[0];

            switch (action) {
                case "Delete":

                    String element = tokens[1];
                    list = list.stream().filter(x ->x != Integer.parseInt(element)).collect(Collectors.toList());
                    break;

                case "Insert":

                    int number = Integer.parseInt(tokens[1]);
                    int index = Integer.parseInt(tokens[2]);

                    if (index >= list.size()|| index < 0) {
                        continue;
                    }

                    list.add(index, number);
                    break;
            }
        }
        System.out.println(list.toString().replaceAll("[\\[\\],]",""));
    }
}
