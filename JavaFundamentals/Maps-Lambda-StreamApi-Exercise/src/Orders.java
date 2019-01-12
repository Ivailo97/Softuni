import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> productAndQuantity = new LinkedHashMap<>();
        LinkedHashMap<String, Double> productAndPrice = new LinkedHashMap<>();

        while (true) {
            String line = scanner.nextLine();

            if (line.equals("buy")) {
                break;
            }

            String[] tokens = line.split("\\s+");

            String item = tokens[0];
            double price = Double.parseDouble(tokens[1]);
            int quantity = Integer.parseInt(tokens[2]);

            if (!productAndQuantity.containsKey(item)) {
                productAndQuantity.put(item, 0);
                productAndPrice.put(item, 0.0);
            }

            productAndPrice.put(item, price);
            productAndQuantity.put(item, productAndQuantity.get(item) + quantity);
        }

        for (Map.Entry<String, Double> entry : productAndPrice.entrySet()) {

            double price = entry.getValue() * productAndQuantity.get(entry.getKey());
            System.out.printf("%s -> %.2f%n",entry.getKey(),price);
        }
    }
}
