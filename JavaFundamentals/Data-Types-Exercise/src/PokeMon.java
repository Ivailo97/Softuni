import java.util.Scanner;

public class PokeMon {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int power = Integer.parseInt(scanner.nextLine());
        int distance =Integer.parseInt(scanner.nextLine());
        int factor =Integer.parseInt(scanner.nextLine());
        int counter = 0;

        if (distance > power)
        {
            System.out.println(power);
            System.out.println(0);
        }
        else
        {

            int copyPower = power;

            while (true)
            {

                if (power == 0.5 * copyPower)
                {
                    if (power >= factor && factor != 0)
                    {
                        power /= factor;
                    }

                }

                if (distance > power)
                {
                    break;
                }

                power -= distance;
                counter++;
            }
        }

        System.out.println(power);
        System.out.println(counter);
    }

}
