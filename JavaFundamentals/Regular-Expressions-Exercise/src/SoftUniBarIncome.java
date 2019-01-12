import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile
                ("^%(?<customer>[A-Z][a-z]+)%([^|,$%.]*?)<(?<product>\\w+)>([^|,$%.]*?)\\|(?<count>\\d+)\\|([^|,$%.]*?)(?<price>\\d+\\.?\\d+)\\$$");

        double totalPrice = 0;
        while (true) {
            String line = scanner.nextLine();

            if (line.equals("end of shift")) {
                break;
            }

            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                String name = matcher.group("customer");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));

                System.out.printf("%s: %s - %.2f%n", name, product, price * count);
                totalPrice += price * count;
            }
        }
        System.out.printf("Total income: %.2f%n", totalPrice);
    }
}
