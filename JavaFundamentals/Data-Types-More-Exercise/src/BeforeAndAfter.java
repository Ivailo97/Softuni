import java.util.Scanner;

public class BeforeAndAfter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        System.out.println("Before:");
        System.out.printf("a = %d%n",a);
        System.out.printf("b = %d%n",b);

        System.out.println("After:");
        System.out.printf("a = %d%n",b);
        System.out.printf("b = %d%n",a);

    }
}