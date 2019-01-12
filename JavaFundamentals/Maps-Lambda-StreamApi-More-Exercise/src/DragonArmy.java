import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, Integer>>> dragons = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String line = scanner.nextLine();
            String[] tokens = line.split("\\s+");
            String type = tokens[0];
            String name = tokens[1];

            boolean dmgIsANumber = true;
            boolean healthIsANumber = true;
            boolean armorIsANumber = true;

            try {
                Integer.parseInt(tokens[2]);
            } catch (Exception e) {
                dmgIsANumber = false;
            }

            try {
                Integer.parseInt(tokens[3]);
            } catch (Exception e) {
                healthIsANumber = false;
            }

            try {
                Integer.parseInt(tokens[4]);
            } catch (Exception e) {
                armorIsANumber = false;
            }

            int dmg;
            int health;
            int armor;

            if (dmgIsANumber) {
                dmg = Integer.parseInt(tokens[2]);
            } else {
                dmg = 45;
            }

            if (healthIsANumber) {
                health = Integer.parseInt(tokens[3]);
            } else {
                health = 250;
            }

            if (armorIsANumber) {
                armor = Integer.parseInt(tokens[4]);
            } else {
                armor = 10;
            }

            if (!dragons.containsKey(type)) {
                dragons.put(type, new LinkedHashMap<>());
            }

            if (!dragons.get(type).containsKey(name)) {
                dragons.get(type).put(name, new LinkedHashMap<>());
            }

            if (!dragons.get(type).get(name).containsKey("damage")) {
                dragons.get(type).get(name).put("damage", 0);
            }

            if (!dragons.get(type).get(name).containsKey("health")) {
                dragons.get(type).get(name).put("health", 0);
            }

            if (!dragons.get(type).get(name).containsKey("armor")) {
                dragons.get(type).get(name).put("armor", 0);
            }

            dragons.get(type).get(name).put("damage", dmg);
            dragons.get(type).get(name).put("health", health);
            dragons.get(type).get(name).put("armor", armor);
        }

        for (var dragon : dragons.entrySet()) {
            TreeMap<String, LinkedHashMap<String, Integer>> names = new TreeMap<>(dragon.getValue());

            List<Double> damages = new ArrayList<>();
            List<Double> healths = new ArrayList<>();
            List<Double> armors = new ArrayList<>();

            for (var name : names.entrySet()) {
                damages.add((double) dragons.get(dragon.getKey()).get(name.getKey()).get("damage"));
                healths.add((double) dragons.get(dragon.getKey()).get(name.getKey()).get("health"));
                armors.add((double) dragons.get(dragon.getKey()).get(name.getKey()).get("armor"));
            }

            double damageAvg = damages.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
            double healthAvg = healths.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
            double armorAvg = armors.stream().mapToDouble(Double::doubleValue).average().getAsDouble();

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", dragon.getKey(), damageAvg, healthAvg, armorAvg);

            damages.clear();
            healths.clear();
            armors.clear();

            for (var name : names.entrySet()) {

                System.out.print("-" + name.getKey() + " -> ");
                LinkedHashMap<String, Integer> stats = name.getValue();
                List<String> rowStats = new ArrayList<>();

                for (var stat : stats.entrySet()) {
                    rowStats.add(stat.getKey() + ": " + stat.getValue());
                }

                for (var stat : stats.entrySet()) {
                    System.out.print((String.join(", ", rowStats)));
                    rowStats.clear();
                }
                System.out.println();
            }
        }
    }
}

