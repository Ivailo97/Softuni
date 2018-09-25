import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGames = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int mouses = 0;
        int keyboards = 0;
        int displays = 0;
        int headset = 0;
        int countKeyboardTrashing = 0;

        for (int i = 1; i <= lostGames; i++) {
            if (i % 2 == 0) {
                headset++;
            }
            if (i % 3 == 0) {
                mouses++;
            }
            if (i % 2 == 0 && i % 3 == 0) {
                keyboards++;
                countKeyboardTrashing++;
                if (countKeyboardTrashing % 2 == 0) {
                    displays++;
                }
            }
        }
        double totalPrice = mouses * mousePrice + displays * displayPrice + keyboards * keyboardPrice
                + headset * headsetPrice;
        System.out.printf("Rage expenses: %.2f lv.", totalPrice);
    }
}
