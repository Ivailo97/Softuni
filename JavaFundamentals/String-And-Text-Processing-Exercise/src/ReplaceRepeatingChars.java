import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            if (i == 0) {
                sb.append(line.charAt(i));
                continue;
            }

            if (sb.toString().charAt(sb.length() - 1) != line.charAt(i)) {
                sb.append(line.charAt(i));
            }
        }

        System.out.println(sb);

    }
}

