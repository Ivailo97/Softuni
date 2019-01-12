import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Demon> demons = new TreeMap<>();

        String[] nameLines = scanner.nextLine().split(" *, *");

        for (String name : nameLines) {
            Demon demon = new Demon();

            String demonName = name;

            Pattern pattern = Pattern.compile("[^0-9\\+\\-\\*\\/\\.]");
            Matcher matcher = pattern.matcher(name);

            long health = 0;

            while (matcher.find()) {
                health += matcher.group(0).charAt(0);
            }

            demon.Health = health;

            double damage = 0;

            Pattern pattern1 = Pattern.compile("(-)?\\d+(\\.\\d+)*");
            Matcher matcher1 = pattern1.matcher(name);

            while (matcher1.find()) {
                damage += Double.parseDouble(matcher1.group(0));
            }

            Pattern pattern2 = Pattern.compile("(\\*|\\/)");
            Matcher matcher2 = pattern2.matcher(name);

            while (matcher2.find()) {
                if (matcher2.group(0).equals("/")) {
                    damage /= 2;
                } else {
                    damage *= 2;
                }
            }

            demon.Damage = damage;

            if (!demons.containsKey(demonName)) {
                demons.put(demonName, demon);
            }
        }

        for (var demon : demons.entrySet()) {
            System.out.printf("%s - %s health, %.2f damage\n", demon.getKey(), demon.getValue().Health, demon.getValue().Damage);
        }
    }
}

class Demon {
    public long Health;
    public double Damage;
}
