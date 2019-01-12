import java.util.LinkedHashMap;
import java.util.Scanner;

public class Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> userAndTotalPoints = new LinkedHashMap<>();
        LinkedHashMap<String, LinkedHashMap<String, Integer>> data = new LinkedHashMap<>();

        while (true) {
            String line = scanner.nextLine();

            if (line.equals("no more time")) {

                break;
            }

            String[] tokens = line.split(" -> ");
            String name = tokens[0];
            String contest = tokens[1];
            int points = Integer.parseInt(tokens[2]);

            if (!data.containsKey(contest)) {

                data.put(contest, new LinkedHashMap<>());
            }

            if (!data.get(contest).containsKey(name)) {

                data.get(contest).put(name, Integer.MIN_VALUE);
            }

            if (points > data.get(contest).get(name)) {

                data.get(contest).put(name, points);
            }
        }

        for (var entry : data.entrySet()) {

            for (var value : entry.getValue().entrySet()) {

                if (!userAndTotalPoints.containsKey(value.getKey())) {

                    userAndTotalPoints.put(value.getKey(), value.getValue());
                }else {

                    userAndTotalPoints.put(value.getKey(), userAndTotalPoints.get(value.getKey()) + value.getValue());
                }
            }
        }

        System.out.println();

        int[] number = new int[1];

        data.entrySet().forEach(x -> {

            number[0] = 0;
            System.out.printf("%s: %d participants%n", x.getKey(), x.getValue().size());
            x.getValue().entrySet().stream().sorted((e1, e2) -> {

                int result = Integer.compare(e2.getValue(), e1.getValue());

                if (result == 0) {

                    result = e1.getKey().compareTo(e2.getKey());
                }

                return result;

            }).forEach(y -> {

                System.out.printf("%d. %s <::> %d%n", ++number[0], y.getKey(), y.getValue());
            });
        });

        number[0] = 0;

        System.out.println("Individual standings:");

        userAndTotalPoints.entrySet().stream().sorted((e1, e2) -> {
            int result = Integer.compare(e2.getValue(), e1.getValue());

            if (result == 0) {

                result = e1.getKey().compareTo(e2.getKey());
            }

            return  result;
        }).forEach(x-> System.out.printf("%d. %s -> %d%n",++number[0],x.getKey(),x.getValue()));
    }
}
