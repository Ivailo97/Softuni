import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        PrintVowelsCount(text);
    }

    private static void PrintVowelsCount(String text) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);

            for (int k = 0; k < vowels.length; k++) {
                if (vowels[k] == String.valueOf(current).toLowerCase().charAt(0)) {
                    count++;
                }
            }
        }

        System.out.println((count));
    }
}

