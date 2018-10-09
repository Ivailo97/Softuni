import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] train = new String[n];
        int sum = 0;

        for (int i = 0; i < n; i++)
        {
            train[i] = scanner.nextLine();
            sum += Integer.parseInt(train[i]);
        }

        System.out.println(String.join(" ", train));
        System.out.println(sum);
    }
}
