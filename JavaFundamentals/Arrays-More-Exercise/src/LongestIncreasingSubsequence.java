import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] len = new int[nums.length];
        int[] prev = new int[nums.length];

        int bestIndex = CalculateLongestIncreasingSubsequence(nums, len, prev);
        ArrayList<Integer> lis = RestoreLIS(nums, prev, bestIndex);
        String[] LIS = new String[lis.size()];

        for (int i = 0; i < lis.size(); i++) {

            LIS[i] = String.valueOf(lis.get(i));
        }
        System.out.println(String.join(" ", LIS));


    }

    private static int CalculateLongestIncreasingSubsequence(int[] nums, int[] len, int[] prev) {
        int maxIndex = 0;
        int maxLen = 0;

        for (int x = 0; x < nums.length; x++) {
            len[x] = 1;
            prev[x] = -1;

            for (int i = 0; i < x; i++) {
                if (nums[x] > nums[i] && len[i] + 1 > len[x]) {
                    len[x] = 1 + len[i];
                    prev[x] = i;
                }
            }

            if (len[x] > maxLen) {
                maxLen = len[x];
                maxIndex = x;
            }
        }

        return maxIndex;
    }

    public static ArrayList<Integer> RestoreLIS(int[] nums, int[] prev, int lastIndex) {

        ArrayList<Integer> longestSeq = new ArrayList<>();

        while (lastIndex != -1) {
            longestSeq.add(nums[lastIndex]);
            lastIndex = prev[lastIndex];
        }

        for (int i = 0; i < longestSeq.size() / 2; i++) {

            int temp = longestSeq.get(i);
            longestSeq.set(i, longestSeq.get(longestSeq.size() - i - 1));
            longestSeq.set(longestSeq.size() - i - 1, temp);
        }

        return longestSeq;
    }
}
