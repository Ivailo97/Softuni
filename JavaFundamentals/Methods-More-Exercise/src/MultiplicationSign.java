import java.util.Scanner;

public class MultiplicationSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        int[] nums = new int[3];
        nums[0] = num1;
        nums[1] = num2;
        nums[2] = num3;

        PrintSign(nums);
    }

    private static void PrintSign(int[] nums) {

        int negatives = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] < 0) {
                negatives++;
            } else if (nums[i] == 0) {

                System.out.println("zero");
                return;
            }
        }

        if (negatives % 2 != 0) {

            System.out.println("negative");
        } else {
            System.out.println("positive");
        }
    }
}
