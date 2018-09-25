import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Vacation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());

        String type = scanner.nextLine();
        String day = scanner.nextLine();

        double totalPrice = 0;

        Map<String, Map<String, Double>> pairs = new HashMap<>();

        String type1 = "Students";
        String type2 = "Business";
        String type3 = "Regular";

        pairs.put(type1, new HashMap<>());

        pairs.get(type1).put("Monday", 9.5);
        pairs.get(type1).put("Tuesday", 8.0);
        pairs.get(type1).put("Wednesday", 6.85);
        pairs.get(type1).put("Thursday", 7.15);
        pairs.get(type1).put("Friday", 8.45);
        pairs.get(type1).put("Saturday", 9.80);
        pairs.get(type1).put("Sunday", 10.46);

        pairs.put(type2, new HashMap<>());

        pairs.get(type2).put("Monday", 11.8);
        pairs.get(type2).put("Tuesday", 14.50);
        pairs.get(type2).put("Wednesday", 12.60);
        pairs.get(type2).put("Thursday", 13.20);
        pairs.get(type2).put("Friday", 10.90);
        pairs.get(type2).put("Saturday", 15.60);
        pairs.get(type2).put("Sunday", 16.0);

        pairs.put(type3, new HashMap<>());

        pairs.get(type3).put("Monday", 15.0);
        pairs.get(type3).put("Tuesday", 15.0);
        pairs.get(type3).put("Wednesday", 14.80);
        pairs.get(type3).put("Thursday", 13.90);
        pairs.get(type3).put("Friday", 15.0);
        pairs.get(type3).put("Saturday", 20.0);
        pairs.get(type3).put("Sunday", 22.50);

        totalPrice = pairs.get(type).get(day) * people;

        if (type.equals("Students") && people >= 30) {
            totalPrice *= 0.85;
        } else if (type.equals("Business") && people >= 100) {
            double price = totalPrice / people;
            totalPrice = (people - 10) * price;
        } else if (type.equals("Regular") && people >= 10 && people <= 20) {
            totalPrice *= 0.95;
        }

        System.out.printf("Total price: %.2f", totalPrice);
    }
}
