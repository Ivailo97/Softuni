import java.util.*;

public class Snowwhite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Dwarf> dwarves = new ArrayList<>();

        LinkedHashMap<String, Integer> colorAndCount = new LinkedHashMap<>();

        String line = scanner.nextLine();

        while (!line.equals("Once upon a time")) {
            String[] tokens = line.split(" <:> ");
            String name = tokens[0];
            String color = tokens[1];
            int physics = Integer.parseInt(tokens[2]);

            Dwarf dwarf = new Dwarf(name, physics, color, 1);

            boolean hasAdded = false;
            boolean hasSameNameAndColor = false;

            for (Dwarf unit : dwarves) {
                if (unit.Name.equals(dwarf.Name)) {
                    if (unit.Color.equals(dwarf.Color)) {
                        hasSameNameAndColor = true;
                        if (dwarf.Physics > unit.Physics) {
                            unit.Physics = dwarf.Physics;
                            hasAdded = true;
                            break;
                        }
                    }
                }
            }

            if (!hasAdded && !hasSameNameAndColor) {
                dwarves.add(dwarf);

                if (!colorAndCount.containsKey(color)) {
                    colorAndCount.put(color, 0);
                }

                colorAndCount.put(color, colorAndCount.get(color) + 1);
            }

            line = scanner.nextLine();
        }

        for (Dwarf unit : dwarves) {
            for (var color : colorAndCount.entrySet()) {
                if (unit.Color.equals(color.getKey())) {
                    unit.ColorCount = color.getValue();
                }
            }
        }

        dwarves.stream().sorted((e1, e2) -> {
            int result = Integer.compare(e2.Physics, e1.Physics);
            if (result == 0) {
                result = Integer.compare(e2.ColorCount, e1.ColorCount);
            }
            return result;
        }).forEach(x -> System.out.printf("(%s) %s <-> %d%n", x.Color, x.Name, x.Physics));
    }
}

class Dwarf {

    public String Name;
    public int Physics;
    public String Color;
    public int ColorCount;

    public Dwarf(String name, int physics, String color, int colorCount) {

        Name = name;
        Physics = physics;
        Color = color;
        ColorCount = colorCount;
    }
}
