import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> participants = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        Map<String, Integer> racers = new LinkedHashMap<>();

        Pattern regexForLetter = Pattern.compile("([a-zA-Z]+)");
        Pattern regexForNumbers = Pattern.compile("\\d");

        while (true) {
            String line = scanner.nextLine();

            if (line.equals("end of race")) {
                break;
            }

            Matcher letters = regexForLetter.matcher(line);
            StringBuilder name = new StringBuilder();
            while (letters.find()) {
                name.append(letters.group(0));
            }

            int km = 0;

            Matcher numbers = regexForNumbers.matcher(line);

            while (numbers.find()) {
                km += Integer.parseInt(numbers.group(0));
            }

            String racer = name.toString();

            if (participants.contains(racer)) {
                if (!racers.containsKey(racer)) {
                    racers.put(racer, 0);
                }

                racers.put(racer, racers.get(racer) + km);
            }
        }

        Map<String, Integer> newMap = new LinkedHashMap<>();

        racers.entrySet().stream()
                .sorted((x1, x2) -> Integer.compare(x2.getValue(), x1.getValue()))
                .forEach(x -> newMap.put(x.getKey(), x.getValue()));

        String[] places = new String[]{"1st place: ", "2nd place: ", "3rd place: "};
        int index = 0;
        for (var entry : newMap.entrySet()) {

            System.out.println(places[index] + entry.getKey());
            index++;

            if (index > 2) {
                break;
            }
        }
    }
}
