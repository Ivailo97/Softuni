import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] prev = new String [1];

        for (int i = 1; i <= n; i++) {

            String[] sequence = new String[i];
            sequence[0] = "1";
            sequence[sequence.length - 1] = "1";

            if ( i <= 2){

                System.out.println(String.join(" ",sequence));
                prev = sequence;
                continue;
            }

            if (prev.length != 1){

                for (int j = 0; j < prev.length - 1 ; j++) {

                    sequence[j + 1] = String.valueOf(Integer.parseInt(prev[j]) + Integer.parseInt(prev[j + 1]));
                }

                System.out.println(String.join(" ",sequence));
                prev = sequence;
            }
        }
    }
}
