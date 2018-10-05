import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] numsNext = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int index = 0;
        int sum = 0;
        boolean areEqual = true;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != numsNext[i]) {

                index = i;
                areEqual = false;
                break;
            }

            sum += nums[i];

        }

        if (areEqual) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        } else {
            System.out.printf("Arrays are not identical. Found difference at %d index.", index);
        }
    }
}
