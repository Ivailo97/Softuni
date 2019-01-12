import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, List<Double>> pairs = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!pairs.containsKey(name)) {

                pairs.put(name, new ArrayList<>());
            }

            pairs.get(name).add(grade);
        }

        pairs.entrySet().stream().filter(x -> x.getValue()
                .stream().mapToDouble(e -> e).average().getAsDouble() >= 4.50)
                .sorted((y1, y2) -> {
                    int result = Double.compare(y2.getValue().stream().mapToDouble(a -> a).average().getAsDouble(),
                            y1.getValue().stream().mapToDouble(a1 -> a1).average().getAsDouble());

                    return result;
                }).forEach(i -> System.out.printf("%s -> %.2f%n", i.getKey(),
                i.getValue().stream().mapToDouble(d -> d).average().getAsDouble()));
    }
}

