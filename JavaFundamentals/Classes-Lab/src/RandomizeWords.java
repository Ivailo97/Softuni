import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");

        Random random = new Random();

        for (int i = 0; i < words.length; i++) {
            int index = random.nextInt(words.length);


            String current = words[i];

            words[i] = words[index];
            words[index] = current;

        }

        System.out.println(String.join("\r\n",words));

    }
}

