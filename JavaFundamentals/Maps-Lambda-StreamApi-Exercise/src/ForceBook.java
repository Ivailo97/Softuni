import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> sideAndUsers = new HashMap<>();

        while (true) {
            String line = scanner.nextLine();

            if (line.equals("Lumpawaroo")) {
                break;
            }

            if (line.contains(" | ")) {
                String[] tokens = line.split(" \\| ");
                String side = tokens[0];
                String user = tokens[1];

                boolean contains = false;

                for (List<String> pair : sideAndUsers.values()) {

                    for (String name : pair) {

                        if (name.equals(user)) {

                            contains = true;
                            break;
                        }
                    }
                }

                if (!contains) {
                    if (!sideAndUsers.containsKey(side)) {
                        sideAndUsers.put(side, new ArrayList<>());
                    }

                    sideAndUsers.get(side).add(user);
                }
            } else {
                String[] tokens = line.split(" -> ");
                String user = tokens[0];
                String side = tokens[1];

                boolean contains = false;

                for (List<String> pair : sideAndUsers.values()) {

                    for (String name : pair) {

                        if (name.equals(user)) {

                            contains = true;
                            break;
                        }
                    }
                }

                if (contains) {
                    String prevSide = "";

                    for (Map.Entry<String, List<String>> pair : sideAndUsers.entrySet()) {

                        if (pair.getValue().contains(user)) {

                            prevSide = pair.getKey();
                        }
                    }

                    sideAndUsers.get(prevSide).remove(user);

                    if (!sideAndUsers.containsKey(side)) {
                        sideAndUsers.put(side, new ArrayList<>());
                    }

                    sideAndUsers.get(side).add(user);
                    System.out.printf("%s joins the %s side!%n", user, side);

                } else {

                    if (!sideAndUsers.containsKey(side)) {
                        sideAndUsers.put(side, new ArrayList<>());
                    }

                    sideAndUsers.get(side).add(user);
                    System.out.printf("%s joins the %s side!%n", user, side);
                }
            }
        }

        sideAndUsers.entrySet().stream().filter(x -> x.getValue().size() > 0).sorted((x1, x2) -> {
            int result = Integer.compare(x2.getValue().size(), x1.getValue().size());
            if (result == 0) {
                result = x1.getKey().compareTo(x2.getKey());
            }
            return result;

        }).forEach(e -> {
            System.out.printf("Side: %s, Members: %d%n", e.getKey(), e.getValue().size());
            e.getValue().stream().sorted().forEach(y -> System.out.printf("! %s%n", y));
        });
    }
}

