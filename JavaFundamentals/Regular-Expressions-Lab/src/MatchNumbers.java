import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("(^|(?<=\\s))-?\\d+(\\.\\d+)?($|(?=\\s))");
        Matcher matcher = pattern.matcher(input);

        List<String> matches = new ArrayList<>();

        while (matcher.find()){

            matches.add(matcher.group());
        }

        System.out.println(String.join(" ",matches));
    }
}
