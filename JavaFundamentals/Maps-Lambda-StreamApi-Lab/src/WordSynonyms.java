import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, List<String>> pairs = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n ; i++) {

            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            if (!pairs.containsKey(word)){

                pairs.put(word, new ArrayList<>());
            }

            pairs.get(word).add(synonym);
        }

        for (Map.Entry<String,List<String>> entry: pairs.entrySet()) {

            System.out.println(entry.getKey() + " - " + String.join(", ",entry.getValue()) );
        }
    }
}
