import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] pair = new String[2];

        int sum = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == sum) {
                    pair[0] = String.valueOf(nums[i]);
                    pair[1] = String.valueOf(nums[j]);

                    System.out.println(String.join(" ", pair));
                }
            }
        }
    }
}
