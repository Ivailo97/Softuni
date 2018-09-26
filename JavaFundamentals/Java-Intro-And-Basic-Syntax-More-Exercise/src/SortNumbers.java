import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         Integer[] nums = new Integer[3];

        for (int i = 0; i < 3; i++) {

            nums[i] = Integer.parseInt(scanner.nextLine());
        }

        Arrays.sort(nums,Collections.reverseOrder());

        for (Integer num : nums) {

            System.out.println(num);
        }

    }
}
