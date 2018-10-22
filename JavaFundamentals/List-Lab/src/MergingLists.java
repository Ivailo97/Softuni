import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> resultList = new ArrayList<>();

        for (int i = 0;; i++) {

            if (i >= firstList.size() && i < secondList.size()){

                for (int j = i; j <  secondList.size(); j++) {

                    resultList.add(secondList.get(j));
                }

                break;
            }

            if (i >= secondList.size() && i < firstList.size()){

                for (int j = i; j < firstList.size() ; j++) {

                    resultList.add(firstList.get(j));
                }

                break;
            }

            if (i == secondList.size() && i == firstList.size()){

                break;
            }

            resultList.add(firstList.get(i));
            resultList.add(secondList.get(i));
        }

        System.out.println(JoinNumbersByDelimiter(resultList," "));
    }

    public static String JoinNumbersByDelimiter(List<Integer> numbers, String delimiter) {

        String result = "";

        for (int i = 0; i < numbers.size(); i++) {

            if (i != numbers.size() - 1) {
                result += numbers.get(i) + delimiter;
            } else {
                result += numbers.get(i);
            }
        }
        return result;
    }
}
