import java.util.LinkedHashMap;
import java.util.Scanner;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        LinkedHashMap<String,Integer> nameAndPoints = new LinkedHashMap<>();
        LinkedHashMap<String,Integer> languageAndSubmissions = new LinkedHashMap<>();

        while (!line.equals("exam finished"))
        {
            String[] tokens = line.split("-");
            String name = tokens[0];
            String language = tokens[1];

            if (language.equals("banned"))
            {
                if (nameAndPoints.containsKey(name))
                {
                    nameAndPoints.remove(name);
                }

                line = scanner.nextLine();
                continue;
            }

            int points = Integer.parseInt(tokens[2]);

            if (!nameAndPoints.containsKey(name))
            {
                nameAndPoints.put(name, 0);
            }

            if (nameAndPoints.get(name) < points)
            {
                nameAndPoints.put(name,points);
            }

            if (!languageAndSubmissions.containsKey(language))
            {
                languageAndSubmissions.put(language, 1);
            }
            else
            {
                languageAndSubmissions.put(language,languageAndSubmissions.get(language) + 1);
            }

            line = scanner.nextLine();
        }

        System.out.println("Results:");

        nameAndPoints.entrySet().stream().sorted((e1,e2) -> {
            int result = e2.getValue().compareTo(e1.getValue());
            if (result == 0){

                result = e1.getKey().compareTo(e2.getKey());
            }
            return  result;
        }).forEach(e -> System.out.println(e.getKey() + " | " + e.getValue()));


        System.out.println("Submissions:");

        languageAndSubmissions.entrySet().stream().sorted((e1,e2) -> {
            int result = e2.getValue().compareTo(e1.getValue());
            if (result == 0){

                result = e1.getKey().compareTo(e2.getKey());
            }
            return  result;
        }).forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
    }
}
