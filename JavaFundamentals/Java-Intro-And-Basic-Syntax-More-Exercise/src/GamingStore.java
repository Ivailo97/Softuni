import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double money = Double.parseDouble(scanner.nextLine());
        String type = scanner.nextLine();
        double totalSpent = 0;

        while (!type.equals("Game Time")) {
            if (type.equals("CS: OG")) {

                if (money < 15.99) {
                    System.out.println("Too Expensive");
                } else {
                    money -= 15.99;
                    totalSpent += 15.99;
                    System.out.println("Bought CS: OG");
                }
                if (money == 0) {
                    System.out.println("Out of money!");
                    break;
                }
            } else if (type.equals("Zplinter Zell")) {

                if (money < 19.99) {
                    System.out.println("Too Expensive");
                } else {
                    money -= 19.99;
                    totalSpent += 19.99;
                    System.out.println("Bought Zplinter Zell");
                }
                if (money == 0) {
                    System.out.println("Out of money!");
                    break;
                }
            } else if (type.equals("RoverWatch")) {

                if (money < 29.99) {
                    System.out.println("Too Expensive");
                } else {
                    money -= 29.99;
                    totalSpent += 29.99;
                    System.out.println("Bought RoverWatch");
                }
                if (money == 0) {
                    System.out.println("Out of money!");
                    break;
                }
            } else if (type.equals("RoverWatch Origins Edition")) {

                if (money < 39.99) {
                    System.out.println("Too Expensive");
                } else {
                    money -= 39.99;
                    totalSpent += 39.99;
                    System.out.println("Bought RoverWatch Origins Edition");
                }
                if (money == 0) {
                    System.out.println("Out of money!");
                    break;
                }
            } else if (type.equals("OutFall 4")) {

                if (money < 39.99) {
                    System.out.println("Too Expensive");
                } else {
                    money -= 39.99;
                    totalSpent += 39.99;
                    System.out.println("Bought OutFall 4");
                }
                if (money == 0) {
                    System.out.println("Out of money!");
                    break;
                }
            } else if (type.equals("Honored 2")) {

                if (money < 59.99) {
                    System.out.println("Too Expensive");
                } else {
                    money -= 59.99;
                    totalSpent += 59.99;
                    System.out.println("Bought Honored 2");
                }
                if (money == 0) {
                    System.out.println("Out of money!");
                    break;
                }
            } else {
                System.out.println("Not Found");
            }

            type = scanner.nextLine();
        }
        if (money > 0) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", totalSpent, money);
        }
    }
}




