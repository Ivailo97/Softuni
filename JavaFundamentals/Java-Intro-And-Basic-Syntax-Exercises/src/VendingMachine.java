import java.util.*;

public class VendingMachine {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double money = 0;
        String line = scanner.nextLine();

        while (!line.equals("Start")) {
            double insert = Double.parseDouble(line);

            if (insert != 0.1
                    && insert != 0.2
                    && insert != 0.5
                    && insert != 1
                    && insert != 2) {
                System.out.printf("Cannot accept %.2f%n", insert);
                line = scanner.nextLine();
                continue;
            }

            money += insert;
            line = scanner.nextLine();
        }

        String product = scanner.nextLine();

        Map<String, Double> products = new HashMap<String, Double>();

        products.put("Nuts", 2.0);
        products.put("Water", 0.7);
        products.put("Crisps", 1.5);
        products.put("Soda", 0.8);
        products.put("Coke", 1.0);

        while (!product.equals("End")) {

            if (products.containsKey(product) && money >= products.get(product)) {
                System.out.printf("Purchased %s%n", product);
                money -= products.get(product);
                product = scanner.nextLine();

            } else {

                if (!products.containsKey(product)) {
                    System.out.println("Invalid product");
                    product = scanner.nextLine();
                } else if (money < products.get(product)) {
                    System.out.println("Sorry, not enough money");
                    product = scanner.nextLine();
                }
            }
        }

        System.out.printf("Change: %.2f", money);
    }
}
