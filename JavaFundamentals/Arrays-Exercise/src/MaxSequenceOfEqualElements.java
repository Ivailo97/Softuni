import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int len = 1;
        int bestStart = 0;
        int bestLen = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                len++;

                if (len > bestLen) {
                    bestLen = len;
                    bestStart = i - bestLen + 1;
                }
            } else {
                len = 1;

            }
        }

        for (int i = 0; i < bestLen; i++) {
            System.out.print(arr[bestStart + i] + " ");
        }
    }
}
