import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrays = scanner.nextLine().split("\\|+");
        List<String> resultList = new ArrayList<>();

        for (int i = arrays.length - 1; i >= 0; i--) {

            String current = arrays[i].trim();

            if (current.isEmpty()){
                continue;
            }

            List<String> currentArray = Arrays.stream(current
                    .split("\\s+")).collect(Collectors.toList());


            resultList.addAll(currentArray);
        }
        System.out.println(resultList.toString().replaceAll("[\\[\\],]",""));
    }
}

