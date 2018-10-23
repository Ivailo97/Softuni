import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int[] bombNums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int bombNumber = bombNums[0];
        int range = bombNums[1];

        int bombIndex = nums.indexOf(bombNumber);

        while (bombIndex != -1) {
            int left = bombIndex - range;
            int right = bombIndex + range;

            if (left < 0) {
                left = 0;
            }

            if (right > nums.size() - 1) {

                right = nums.size() - 1;
                nums.subList(left, right).clear();
                nums.remove(nums.size() - 1);

            }else {

                nums.subList(left, right + 1).clear();
            }

            bombIndex = nums.indexOf(bombNumber);
        }

        int sum = 0;

        for (int num : nums) {
            sum += num;
        }
        System.out.println(sum);
    }
}
