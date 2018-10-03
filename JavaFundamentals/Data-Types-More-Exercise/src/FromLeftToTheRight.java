import java.util.Scanner;

public class FromLeftToTheRight {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String[] nums = scanner.nextLine().split(" ");

            boolean isInteger = true;

            try {
                Integer.parseInt(nums[0]);
            } catch (Exception e) {

                isInteger = false;
            }

            boolean isDecimal = true;

            try {
                Double.parseDouble(nums[0]);
            } catch (Exception e) {
                isDecimal = false;
            }

            boolean condiditon = true;

            if (isDecimal) {
                condiditon = Double.parseDouble(nums[0]) > Double.parseDouble(nums[1]);
            } else if (isInteger) {
                condiditon = Integer.parseInt(nums[0]) > Integer.parseInt(nums[1]);
            }

            if (condiditon) {

                long sum = 0;

                char[] numAsString = nums[0].toCharArray();

                for (int k = 0; k < numAsString.length; k++) {

                    try {
                        sum += Long.parseLong(numAsString[k] + "");
                    } catch (Exception e) {

                        continue;
                    }
                }

                System.out.println(sum);
            } else {
                long sum = 0;

                char[] numAsString = nums[1].toCharArray();

                for (int k = 0; k < numAsString.length; k++) {
                    try {
                        sum += Long.parseLong(numAsString[k] + "");
                    } catch (Exception e) {

                        continue;
                    }
                }

                System.out.println(sum);
            }
        }
    }
}
