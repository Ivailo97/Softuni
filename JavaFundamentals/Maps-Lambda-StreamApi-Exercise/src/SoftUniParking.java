import java.util.LinkedHashMap;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> register = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String action = tokens[0];
            String name = tokens[1];

            switch (action) {
                case "register":
                    String licenseNumber = tokens[2];
                    if (register.containsKey(name)) {

                        System.out.println("ERROR: already registered with plate number " + register.get(name));
                    } else {
                        register.put(name, licenseNumber);
                        System.out.printf("%s registered %s successfully%n", name, licenseNumber);
                    }
                    break;
                case "unregister":
                    if (!register.containsKey(name)) {
                        System.out.printf("ERROR: user %s not found%n", name);
                    } else {
                        register.remove(name);
                        System.out.println(name + " unregistered successfully");
                    }
                    break;
            }
        }
        register.entrySet().stream().forEach(x -> System.out.println(x.getKey() + " => " + x.getValue()));
    }

}
