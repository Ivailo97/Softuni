import java.util.*;

public class MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] encryptedWords = scanner.nextLine().split(" \\| ");
        Map<String,Character> pairs = new HashMap<>();
        pairs.put(".-",'A');
        pairs.put("-...",'B');
        pairs.put("-.-.",'C');
        pairs.put("-..",'D');
        pairs.put(".",'E');
        pairs.put("..-.",'F');
        pairs.put("--.",'G');
        pairs.put("....",'H');
        pairs.put("..",'I');
        pairs.put(".---",'J');
        pairs.put("-.-",'K');
        pairs.put(".-..",'L');
        pairs.put("--",'M');
        pairs.put("-.",'N');
        pairs.put("---",'O');
        pairs.put(".--.",'P');
        pairs.put("--.-",'Q');
        pairs.put(".-.",'R');
        pairs.put("...",'S');
        pairs.put("-",'T');
        pairs.put("..-",'U');
        pairs.put("...-",'V');
        pairs.put(".--",'W');
        pairs.put("-..-",'X');
        pairs.put("-.--",'Y');
        pairs.put("--..",'Z');

        List<String>  decryptedWords = new ArrayList<>();

        for (int i = 0; i < encryptedWords.length ; i++) {

            StringBuilder sb = new StringBuilder();
            String[] letters = encryptedWords[i].split(" ");

            for (int j = 0; j < letters.length; j++) {

                sb.append(pairs.get(letters[j]));
            }

            decryptedWords.add(sb.toString());
        }

        System.out.println(String.join(" ",decryptedWords));
    }
}
