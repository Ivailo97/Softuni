import java.util.LinkedHashMap;
import java.util.Scanner;

public class MobaChalenger {

    public static void main(String[] args) {

        LinkedHashMap<String, LinkedHashMap<String, Integer>> data = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> playerAndTotalPoints = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();

            if (line.equals("Season end")) {

                break;
            }

            if (line.contains(" -> ")) {

                String[] tokens = line.split(" -> ");
                String player = tokens[0];
                String position = tokens[1];
                int skill = Integer.parseInt(tokens[2]);

                if (!data.containsKey(player)) {

                    data.put(player, new LinkedHashMap<>());
                    playerAndTotalPoints.put(player, 0);
                }

                if (!data.get(player).containsKey(position)) {

                    data.get(player).put(position, 0);
                }

                if (data.get(player).get(position) < skill) {

                    data.get(player).put(position, skill);
                    playerAndTotalPoints.put(player, playerAndTotalPoints.get(player) + skill);
                }

            } else {

                String[] tokens = line.split(" vs ");
                String firstPlayer = tokens[0];
                String secondPlayer = tokens[1];

                if (data.containsKey(firstPlayer) && data.containsKey(secondPlayer)) {

                    boolean hasCommon = false;
                    for (var entry : data.get(firstPlayer).entrySet()) {
                        for (var entry1 : data.get(secondPlayer).entrySet()) {
                            if (entry.getKey().equals(entry1.getKey())) {
                                hasCommon = true;
                                break;
                            }
                        }
                    }

                    if (hasCommon) {
                        int firstTotalPoints = playerAndTotalPoints.get(firstPlayer);
                        int secondTotalPoints = playerAndTotalPoints.get(secondPlayer);

                        if (firstTotalPoints > secondTotalPoints) {

                            data.remove(secondPlayer);
                            playerAndTotalPoints.remove(secondPlayer);
                        } else if (firstTotalPoints < secondTotalPoints) {

                            playerAndTotalPoints.remove(firstPlayer);
                            data.remove(firstPlayer);
                        }
                    }
                }
            }
        }

        playerAndTotalPoints.entrySet().stream().sorted((e1, e2) -> {
            int result = Integer.compare(e2.getValue(), e1.getValue());
            if (result == 0) {
                result = e1.getKey().compareTo(e2.getKey());
            }
            return result;
        }).forEach(x -> {
            System.out.printf("%s: %d skill%n", x.getKey(), x.getValue());
            data.get(x.getKey()).entrySet().stream().sorted((x1, x2) -> {
                int result = Integer.compare(x2.getValue(), x1.getValue());
                if (result == 0) {
                    result = x1.getKey().compareTo(x2.getKey());
                }
                return result;
            }).forEach(y -> {
                System.out.printf("- %s <::> %d%n", y.getKey(), y.getValue());
            });
        });
    }
}
