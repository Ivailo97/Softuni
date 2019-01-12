import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RageQuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine().toUpperCase();

        String[] words = line.split("\\d+");
        String[] counts1 = line.split("\\D+");
        List<Integer> counts = new ArrayList<>();

        for (String count : counts1) {
            if (count.equals("")){
                continue;
            }
            counts .add( Integer.parseInt(count.trim()));
        }

        StringBuilder message = new StringBuilder();

        for (int i = 0; i <  words.length; i++) {

            if (counts.get(i) != 0 ) {

                for (int k = 0; k < counts.get(i) ; k++) {

                    message.append(words[i]);
                }
            }
        }

        List<Character> uniqueSymbols = message.toString().chars()
                .mapToObj(x-> (char) x).distinct().collect(Collectors.toList());

        System.out.println("Unique symbols used: " + uniqueSymbols.size());
        System.out.println(message);
    }
}

