import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> topList = new ArrayList<>();

        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < arr.length; i++) {
            boolean isTop = false;

            for (int k = i + 1; k < arr.length; k++) {
                if (arr[i] > arr[k]) {
                    isTop = true;

                } else {
                    isTop = false;
                    break;
                }
            }

            if (isTop || i == arr.length - 1) {

                topList.add(String.valueOf(arr[i]));
            }
        }

        System.out.println(String.join(" ", topList));
    }
}

