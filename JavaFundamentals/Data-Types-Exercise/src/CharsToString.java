import java.util.Scanner;

public class CharsToString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String symbolOne = scanner.nextLine();
        String symbolTwo = scanner.nextLine();
        String symbolThree = scanner.nextLine();

        System.out.printf("%s%s%s",symbolOne,symbolTwo,symbolThree);
    }
}
