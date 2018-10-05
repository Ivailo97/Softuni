import java.util.Arrays;
import java.util.Scanner;

public class SumEvenNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] % 2 == 0){

                sum+= nums[i];
            }
        }

        System.out.println(sum);
    }
}
