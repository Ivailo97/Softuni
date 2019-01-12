import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        TreeMap<Double, Integer> map = new TreeMap<>();

        for (Double number : numbers) {

            if (!map.containsKey(number)) {

                map.put(number, 1);
            } else {

                map.put(number, map.get(number) + 1);
            }
        }

        for (Map.Entry<Double, Integer> entry : map.entrySet()) {

            DecimalFormat dm = new DecimalFormat("0.#");
            System.out.println(dm.format(entry.getKey()) + " -> " + entry.getValue());
        }
    }
}
