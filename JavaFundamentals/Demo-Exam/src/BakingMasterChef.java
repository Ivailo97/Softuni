import java.util.Scanner;

public class BakingMasterChef {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());

        double pricePerFlour = Double.parseDouble(scanner.nextLine());
        double pricePerEgg = Double.parseDouble(scanner.nextLine());
        double pricePerApron = Double.parseDouble(scanner.nextLine());

        int freePackages = students / 5;

        double totalPrice = pricePerApron * (Math.ceil(students * 1.2)) + pricePerEgg * 10 * students
                + pricePerFlour *(students - freePackages);


        if (totalPrice <= budget){

            System.out.printf("Items purchased for %.2f$.%n",totalPrice);
        }else {
            System.out.printf("%.2f$ more needed.%n",totalPrice - budget);
        }
    }
}
