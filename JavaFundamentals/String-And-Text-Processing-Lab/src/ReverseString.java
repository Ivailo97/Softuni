import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){

            String line = scanner.nextLine();

            if (line.equals("end")){
                break;
            }

            StringBuilder sb = new StringBuilder();

            for (int i = line.length() - 1; i >= 0 ; i--) {

                sb.append(line.charAt(i));
            }

            System.out.printf("%s = %s%n",line,sb);
        }
    }
}
