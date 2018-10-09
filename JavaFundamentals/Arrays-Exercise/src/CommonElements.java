import java.util.ArrayList;
import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr1 = scanner.nextLine().split(" ");
        String[] arr2 = scanner.nextLine().split(" ");

        ArrayList<String> commons = new ArrayList<>();

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {

                if (arr1[j].equals(arr2[i])) {

                    commons.add(arr2[i]);
                    break;
                }
            }
        }

        System.out.println(String.join(" ", commons));
    }
}
