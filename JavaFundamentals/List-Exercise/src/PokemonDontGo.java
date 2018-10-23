import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        long removedSum = 0;

        while (nums.size() > 0) {
            int index = Integer.parseInt(scanner.nextLine());

            int removedNumber = 0;

            if (index < nums.size() && index > -1) {
                removedNumber = nums.get(index);

                nums.remove(index);

                removedSum += removedNumber;

                for (int i = 0; i < nums.size(); i++) {
                    if (nums.get(i) <= removedNumber) {
                        nums.set(i, nums.get(i) + removedNumber);
                    } else {
                        nums.set(i, nums.get(i) - removedNumber);
                    }
                }
            } else if (index < 0) {
                removedNumber = nums.get(0);

                removedSum += removedNumber;

                nums.set(0, nums.get(nums.size() - 1));

                for (int i = 0; i < nums.size(); i++) {
                    if (nums.get(i) <= removedNumber) {
                        nums.set(i, nums.get(i) + removedNumber);
                    } else {
                        nums.set(i, nums.get(i) - removedNumber);
                    }
                }

            } else if (index >= nums.size()) {
                removedNumber = nums.get(nums.size() - 1);

                removedSum += removedNumber;

                nums.set(nums.size() - 1, nums.get(0));

                for (int i = 0; i < nums.size(); i++) {
                    if (nums.get(i) <= removedNumber) {
                        nums.set(i,nums.get(i) + removedNumber);
                    } else {
                        nums.set(i,nums.get(i) - removedNumber);
                    }
                }
            }
        }
        System.out.println(removedSum);
    }
}
