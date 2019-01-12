import java.util.Scanner;

public class CaesarCipher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            char current = (char) (line.charAt(i) + 3);
            sb.append(current);
        }

        System.out.println(sb);
    }
}
