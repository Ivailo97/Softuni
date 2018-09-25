import java.util.Scanner;

public class Padawan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double money = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());

        double priceForSaber = Double.parseDouble(scanner.nextLine());
        double priceForRobe = Double.parseDouble(scanner.nextLine());
        double priceForBelt = Double.parseDouble(scanner.nextLine());

        double totalPrice = (priceForSaber * (Math.ceil(students * 1.1)) + (priceForRobe * students)
                + priceForBelt * (students - students / 6));

        if (money >= totalPrice) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalPrice);
        } else {
            System.out.printf("Ivan Cho will need %.2flv more.", totalPrice - money);
        }
    }
}
