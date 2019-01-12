import java.util.LinkedHashMap;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> pairs = new LinkedHashMap<>();

        while (true) {

            String key = scanner.nextLine();

            if (key.equals("stop")) {
                break;
            }

            if (!pairs.containsKey(key)) {
                pairs.put(key, 0);
            }

            int value = Integer.parseInt(scanner.nextLine());
            pairs.put(key, pairs.get(key) + value);
        }

        pairs.entrySet().stream().forEach(x -> System.out.printf("%s -> %d%n", x.getKey(), x.getValue()));
    }
}
