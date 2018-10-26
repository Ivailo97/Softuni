import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> line = new ArrayList<>();
        String text = scanner.nextLine();

        for (Character character : text.toCharArray()) {

            line.add(character.toString());
        }

        List<Integer> digits = new ArrayList<>();
        List<String> nonNumbers = new ArrayList<>();

        for (int i = 0; i < line.size(); i++) {

            if (Character.isDigit(line.get(i).charAt(0))) {
                digits.add(Integer.parseInt(line.get(i) + ""));
            } else {
                nonNumbers.add(line.get(i));
            }
        }

        List<Integer> take = new ArrayList<>();
        List<Integer> skip = new ArrayList<>();

        for (int i = 0; i < digits.size(); i++) {
            if (i % 2 == 0) {
                take.add(digits.get(i));
            } else {
                skip.add(digits.get(i));
            }
        }

        String result = "";
        int skiped = 0;
        int taken = 0;

        for (int i = 0; i < take.size(); i++) {

            int total = skiped + taken;

            List<String> current = nonNumbers.stream().skip(total).collect(Collectors.toList());
            List<String> results = new ArrayList<>();

            int end = Math.min(take.get(i),current.size());

            for (int j = 0; j < end; j++) {

                results.add(current.get(j));
            }
            result += String.join("", results);

            skiped += skip.get(i);
            taken += take.get(i);
        }

        System.out.println(result);
    }
}
