import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] nums1 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayList<String> nums = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {

            nums.add(String.valueOf(nums1[i]));

        }

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n ; i++) {

            String temp = nums.get(0);
            nums.remove(0);
            nums.add(temp);
        }

        System.out.println(String.join(" ", nums));
    }
}
