import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");

        double sum = 0;

        for (var word : words) {

            char firstLetter = word.charAt(0);

            int num = Integer.parseInt(word.substring(1, word.length() - 1));

            char lastLetter = word.charAt(word.length() - 1);

            double currentSum = 0;

            if (Character.isUpperCase(firstLetter)) {

                currentSum = num * 1.0 / (firstLetter - 64);
            } else {
                currentSum = num * 1.0 * (firstLetter - 96);
            }

            if (Character.isUpperCase(lastLetter)) {
                currentSum -= (lastLetter - 64.0);
            } else {
                currentSum += (lastLetter - 96.0);
            }

            sum += currentSum;
        }
        System.out.printf("%.2f%n", sum);
    }
}
