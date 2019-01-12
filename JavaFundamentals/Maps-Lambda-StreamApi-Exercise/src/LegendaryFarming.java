import java.util.LinkedHashMap;
import java.util.Scanner;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> items = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> junks = new LinkedHashMap<>();

        boolean legendaryItemObtained = false;

        String currencyForLegendaryItem = "";

        items.put("shards", 0);
        items.put("motes", 0);
        items.put("fragments", 0);

        while (!legendaryItemObtained) {
            String line = scanner.nextLine().toLowerCase();

            String[] tokens = line.split("\\s+");

            for (int i = 0; i < tokens.length; i++) {
                boolean isNum;

                try {
                    int num = Integer.parseInt(tokens[i]);
                    isNum = true;
                } catch (Exception e) {

                    isNum = false;
                }

                if (tokens[i].equals("shards") || tokens[i].equals("motes") || tokens[i].equals("fragments")) {

                    items.put(tokens[i], items.get(tokens[i]) + Integer.parseInt(tokens[i - 1]));

                    if (items.get(tokens[i]) >= 250) {
                        currencyForLegendaryItem = tokens[i];

                        legendaryItemObtained = true;
                        items.put(tokens[i], items.get(tokens[i]) - 250);
                        break;
                    }
                } else if (!isNum) {
                    if (!junks.containsKey(tokens[i])) {
                        junks.put(tokens[i], 0);
                    }
                    junks.put(tokens[i], junks.get(tokens[i]) + Integer.parseInt(tokens[i - 1]));
                }
            }
        }

        String legendaryItem = "";

        switch (currencyForLegendaryItem) {
            case "motes":
                legendaryItem = "Dragonwrath";
                break;
            case "shards":
                legendaryItem = "Shadowmourne";
                break;
            case "fragments":
                legendaryItem = "Valanyr";
                break;
            default:
                break;
        }

        System.out.println(legendaryItem + " obtained!");

        items.entrySet().stream().sorted((e1, e2) -> {

            int result = e2.getValue().compareTo(e1.getValue());
            if (result == 0) {

                result = e1.getKey().compareTo(e2.getKey());
            }
            return result;
        }).forEach(x -> System.out.println(x.getKey() + ": " + x.getValue()));

        junks.entrySet().stream().sorted((y1, y2) -> {

            int result = y1.getKey().compareTo(y2.getKey());
            return result;
        }).forEach(y -> System.out.println(y.getKey() + ": " + y.getValue()));
    }
}

