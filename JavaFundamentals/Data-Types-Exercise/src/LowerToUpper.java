import java.util.Scanner;

public class LowerToUpper {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char symbolOne = scanner.nextLine().charAt(0);


        if (Character.toUpperCase(symbolOne) == symbolOne)
        {
            System.out.println("upper-case");
        }
        else
        {
            System.out.println("lower-case");
        }
    }
}
