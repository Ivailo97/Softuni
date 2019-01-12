import java.util.Scanner;

public class pthBit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int position = Integer.parseInt(scanner.nextLine());

        int shiftedNumeber = number >> position;

        int result = shiftedNumeber & 1;

        System.out.println(result);
    }
}
