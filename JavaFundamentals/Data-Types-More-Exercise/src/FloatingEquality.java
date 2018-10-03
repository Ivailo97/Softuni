import java.util.Scanner;

public class FloatingEquality {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double numOne = Double.parseDouble(scanner.nextLine());
        double numTwo = Double.parseDouble(scanner.nextLine());

        double diff = Math.abs(numOne - numTwo);

        if (diff > 0.000001){

            System.out.println("False");
        }else {
            System.out.println("True");
        }
    }
}
