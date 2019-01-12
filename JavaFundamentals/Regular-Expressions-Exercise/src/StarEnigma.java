import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> attacked = new ArrayList<>();
        List<String> destroyed = new ArrayList<>();

        Pattern pattern = Pattern.compile("[sStTaArR]");

        Pattern pattern1 = Pattern.compile("@(?<name>[A-Za-z]+)[^@\\-,!:>]*?:(?<population>\\d+)[^@\\-,!:>]*?!(?<attackType>A|D)![^@\\-,!:>]*?->(?<soldierCount>\\d+)");
        for (int i = 0; i < n; i++)
        {
            String line = scanner.nextLine();
            Matcher letters =pattern.matcher(line);
            int count = 0;

            while (letters.find()){
                count++;
            }
            StringBuilder decryptedline = new StringBuilder();

            for (int k = 0; k < line.length(); k++)
            {

                decryptedline.append((char)(line.charAt(k) - count));
            }

            Matcher pattern1Matcher = pattern1.matcher(decryptedline.toString());

            if (pattern1Matcher.find())
            {
                if (pattern1Matcher.group("attackType").equals("A"))
                {
                    attacked.add(pattern1Matcher.group("name"));
                }
                else
                {
                    destroyed.add(pattern1Matcher.group("name"));
                }
            }
        }

        System.out.println("Attacked planets: " + attacked.size());
        attacked.stream().sorted(Comparator.naturalOrder()).forEach(x-> System.out.println("-> "+ x));

        System.out.println("Destroyed planets: " + destroyed.size());
        destroyed.stream().sorted(Comparator.naturalOrder()).forEach(x-> System.out.println("-> " + x));
    }
}
