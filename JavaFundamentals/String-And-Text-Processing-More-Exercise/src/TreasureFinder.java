import java.util.Arrays;
import java.util.Scanner;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] keySequence = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        while (true) {

            String line = scanner.nextLine();
            if (line.equals("find")) {
                break;
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < line.length(); i++) {

                int keyIndex = i % keySequence.length;
                int decreasedASCII = line.charAt(i) - keySequence[keyIndex];
                char newSymbol = (char) decreasedASCII;
                sb.append(newSymbol);
            }

            line = sb.toString();

            int startIndexOfType = line.indexOf('&') + 1;
            int endIndexOfType = line.lastIndexOf('&');
            String type = line.substring(startIndexOfType, endIndexOfType);
            int startIndexOfCoordinates = line.indexOf('<') + 1;
            int endIndexOfCoordinates = line.indexOf('>');
            String coordinates = line.substring(startIndexOfCoordinates, endIndexOfCoordinates);

            System.out.printf("Found %s at %s%n",type,coordinates);
        }
    }
}
