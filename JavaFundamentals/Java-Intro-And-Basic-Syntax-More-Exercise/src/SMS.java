import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SMS {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<Integer, ArrayList<Character>> pairs = new HashMap<>();

        for (int i = 0; i <= 9; i++)
        {
            pairs.put(i, new ArrayList<>());
        }

        pairs.get(0).add(' ');

        int count = 6;
        for (char i = 'a'; i <= 'z'; i++)
        {
            if (i == 'z')
            {
                pairs.get(9).add(i);
            }
            else if (i == 's')
            {
                pairs.get(7).add(i);
            }
            else
            {
                int index = count / 3;
                pairs.get(index).add(i);
                count++;
            }
        }

        int wordLen = Integer.parseInt(scanner.nextLine());
        String sms = "";

        for (int i = 0; i < wordLen; i++)
        {
            String numberAsString = scanner.nextLine();
            char[] array = numberAsString.toCharArray();

            int key = Integer.parseInt(Character.toString(array[0]));

            sms += pairs.get(key).get(numberAsString.length()- 1);

        }

        System.out.println(sms);
    }
}
