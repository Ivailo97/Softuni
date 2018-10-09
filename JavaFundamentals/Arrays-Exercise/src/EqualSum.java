import java.util.Arrays;
import java.util.Scanner;

public class EqualSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int leftSum = 0;
        int rightSum = 0;
        int index = 0;

        if (arr.length == 1) {
            System.out.println(0);
        } else {
            for (int l = 0; l < arr.length; l++) {
                if (l > 0) {
                    for (int g = 0; g < l; g++) {
                        leftSum += arr[g];
                    }

                    for (int h = l + 1; h < arr.length; h++) {
                        rightSum += arr[h];
                    }

                    if (rightSum == leftSum) {
                        index = l;
                        System.out.println(index);
                        return;
                    } else {
                        leftSum = 0;
                        rightSum = 0;
                    }
                } else {
                    for (int h = l + 1; h < arr.length; h++) {
                        rightSum += arr[h];
                    }

                    if (rightSum == leftSum) {
                        index = l;
                        System.out.println(index);
                        return;
                    } else {
                        leftSum = 0;
                        rightSum = 0;
                    }
                }
            }
            System.out.println("no");
        }
    }
}
