import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numAsString = scanner.nextLine();

        while (!numAsString.equals("END")) {
            IsPalindrome(numAsString);
            numAsString = scanner.nextLine();
        }
    }

    private static void IsPalindrome(String num) {
        boolean isPalindrome = true;

        for (int i = 0; i < num.length() / 2; i++) {
            if (num.charAt(i) != num.charAt(num.length() - 1 - i)) {

                isPalindrome = false;
                break;
            }
        }
        System.out.println(isPalindrome);
    }
}

