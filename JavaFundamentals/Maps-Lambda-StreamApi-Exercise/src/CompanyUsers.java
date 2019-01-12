import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, List<String>> pairs = new HashMap<>();
        while (true)
        {
            String line = scanner.nextLine();
            if (line.equals("End"))
            {
                break;
            }

            String[] tokens = line.split(" -> ");
            String name = tokens[0];
            String id = tokens[1];

            if (!pairs.containsKey(name))
            {
                pairs.put(name, new ArrayList<>());
            }

            if (!pairs.get(name).contains(id))
            {
                pairs.get(name).add(id);
            }
        }

        pairs.entrySet().stream().sorted((e1,e2) -> {
            int result = e1.getKey().compareTo(e2.getKey());
            return  result;
        }).forEach(e->{
            System.out.println(e.getKey());
            e.getValue().forEach(x -> System.out.printf("-- %s%n",x));
        });
    }
}
