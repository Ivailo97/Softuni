import java.util.Arrays;
import java.util.Scanner;

public class FromLeftToTheRight {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n ; i++) {

            int[] num = Arrays.stream(scanner.nextLine()
                    .split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if (num[0] > num[1]){

                int sum = 0;

                int copy = num[0];

                while (copy != 0){

                    sum += copy % 10;
                    copy /= 10;
                }

                System.out.println(sum);
            }else {

                int sum = 0;

                int copy = num[1];

                while (copy != 0){

                    sum += copy % 10;
                    copy /= 10;
                }

                System.out.println(sum);
            }
        }
    }
}
