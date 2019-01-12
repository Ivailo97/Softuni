import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile(">>(?<name>.+)<<(?<price>\\d+(\\.\\d+)?)!(?<quantity>\\d+)");

        List<String> products = new ArrayList<>();
        double totalPrice = 0;

        while (true) {
            String line = scanner.nextLine();

            if (line.equals("Purchase")) {
                break;
            }

            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {


                String product = matcher.group("name");
                double price = Double.parseDouble(matcher.group("price"));
                int count = Integer.parseInt(matcher.group("quantity"));
                products.add(product);
                totalPrice += price * count;
            }
        }

        System.out.println("Bought furniture:");

        for (String product : products) {
            System.out.println(product);
        }

        System.out.printf("Total money spend: %.2f%n", totalPrice);
    }
}
