import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner ivo = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(ivo.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = ivo.nextLine();

        while (!command.equals("end")) {

            String[] tokens = command.split(" ");
            String action = tokens[0];

            switch (action) {
                case "Add":
                    int number = Integer.parseInt(tokens[1]);
                    numbers.add(number);
                    break;
                case "Remove":
                    int numberToRemove = Integer.parseInt(tokens[1]);
                      numbers =   numbers.stream()
                                .filter(x-> !x.toString().equals(numberToRemove + ""))
                                .collect(Collectors.toList());

                    break;
                case "RemoveAt":
                    int index = Integer.parseInt(tokens[1]);
                    numbers.remove(index);
                    break;
                case "Insert":
                    int numberToInsert = Integer.parseInt(tokens[1]);
                    int position = Integer.parseInt(tokens[2]);
                    numbers.add(position, numberToInsert);
                    break;
                    default:
                        break;
            }

            command = ivo.nextLine();
        }

        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
