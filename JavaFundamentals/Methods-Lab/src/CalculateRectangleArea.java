import java.util.Scanner;

public class CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());

        PrintArea(width,length);
    }

    private static void PrintArea(int width, int length) {

        System.out.println(width * length);
    }
}
