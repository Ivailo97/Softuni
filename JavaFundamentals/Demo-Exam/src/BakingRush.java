import java.util.Scanner;

public class BakingRush {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String daysEvents = scanner.nextLine();
        int energy = 100;
        int coins = 100;

        String[] events = daysEvents.split("\\|");

        for (String event : events) {

            String[] tokens = event.split("-");
            String nameOrIngredient = tokens[0];
            int number = Integer.parseInt(tokens[1]);

            switch (nameOrIngredient) {

                case "rest":
                    if (energy == 100) {

                        number = 0;
                    } else if (energy + number > 100) {


                        number = 100 - energy;
                        energy = 100;

                    } else {

                        energy += number;
                    }

                    System.out.printf("You gained %d energy.%n", number);
                    System.out.printf("Current energy: %d.%n",energy);
                    break;
                case "order":

                    if (energy - 30 >= 0) {

                        coins += number;
                        energy -= 30;
                        System.out.printf("You earned %d coins.%n", number);
                    } else {
                        energy += 50;
                        System.out.printf("You had to rest!%n");
                        continue;
                    }
                    break;

                default:
                    coins -= number;

                    if (coins > 0) {

                        System.out.printf("You bought %s.%n", nameOrIngredient);
                    } else {

                        System.out.printf("Closed! Cannot afford %s.%n", nameOrIngredient);
                        return;
                    }
                    break;
            }
        }
            System.out.printf("Day completed!%n");
            System.out.printf("Coins: %d%n", coins);
            System.out.printf("Energy: %d%n", energy);
    }
}
