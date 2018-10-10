import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortPrintArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] nums = new int[n];

        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

        for (int i = 0; i < n; i++) {

            String name = scanner.nextLine();
            int number = 0;
            char[] nameArr = name.toCharArray();

            for (int j = 0; j < name.length(); j++) {

                boolean isVowel = VowelOrNot(vowels, nameArr[j]);

                if (isVowel) {
                    number += nameArr[j] * name.length();
                } else {
                    number += nameArr[j] / name.length();
                }

                nums[i] = number;
            }
        }

        Arrays.sort(nums);

        for (int num : nums) {
            System.out.println(num);
        }
    }

    private static boolean VowelOrNot(char[] vowels, char letter) {

        boolean isVowel = false;

        for (char vowel : vowels) {

            if (letter == vowel) {

                isVowel = true;
                break;
            }
        }

        return isVowel;
    }
}

