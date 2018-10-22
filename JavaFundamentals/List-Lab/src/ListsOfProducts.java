import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ListsOfProducts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> producs = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            producs.add(scanner.nextLine());
        }

        Collections.sort(producs);

        for (int i = 0; i < n; i++) {

            System.out.printf("%d.%s%n",i + 1,producs.get(i));

        }
    }
}
