import java.util.Scanner;

public class BackIn30Minutes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int h = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine()) + 30;

        int totalTime = h * 60 + m;
        int totalHours = totalTime / 60;
        int totalMinutes = totalTime % 60;

        if (totalHours >= 24) {
            totalHours -= 24;
        }

        if (totalMinutes < 10) {
            System.out.printf("%d:0%d", totalHours, totalMinutes);
        } else {
            System.out.printf("%d:%d", totalHours, totalMinutes);
        }
    }
}
