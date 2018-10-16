import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class ArrayManipulator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers1 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < numbers1.length; i++) {

            numbers.add(numbers1[i]);
        }


        while (true) {
            String[] tokens = scanner.nextLine().split(" ");

            if (tokens[0].equals("end")) {
                break;
            }

            String action = tokens[0];

            switch (action) {
                case "exchange":
                    numbers = Exchange(tokens, numbers);
                    break;

                case "max":
                    int index = GetMaxIndex(tokens, numbers);
                    if (index == -1) {
                        System.out.println(("No matches"));
                    } else {
                        System.out.println((index));
                    }
                    break;

                case "min":
                    int minIndex = GetMinIndex(tokens, numbers);
                    if (minIndex == -1) {
                        System.out.println(("No matches"));
                    } else {
                        System.out.println((minIndex));
                    }
                    break;

                case "first":
                    if (Integer.parseInt(tokens[1]) > numbers.size()) {
                        System.out.println(("Invalid count"));
                    } else {
                        PrintFirst(tokens, numbers);
                    }
                    break;

                case "last":
                    if (Integer.parseInt(tokens[1]) > numbers.size()) {
                        System.out.println(("Invalid count"));
                    } else {
                        PrintLast(tokens, numbers);
                    }
                    break;
            }
        }
        String[] numbersAsString = new String[numbers.size()];

        for (int i = 0; i < numbers.size(); i++) {

            numbersAsString[i] = numbers.get(i).toString();
        }

        System.out.printf("[%s]", String.join(", ", numbersAsString));
    }

    private static void PrintLast(String[] tokens, ArrayList<Integer> numbers) {
        int count = Integer.parseInt(tokens[1]);
        String type = tokens[2];

        ArrayList<String> lastEvenNumbers = new ArrayList<>();
        ArrayList<String> lastOddNumbers = new ArrayList<>();

        for (int i = numbers.size() - 1; i >= 0; i--) {
            if (numbers.get(i) % 2 == 0) {
                lastEvenNumbers.add(numbers.get(i).toString());

                if (lastEvenNumbers.size() == count) {
                    break;
                }
            }
        }

        for (int i = numbers.size() - 1; i >= 0; i--) {
            if (numbers.get(i) % 2 != 0) {
                lastOddNumbers.add(numbers.get(i).toString());

                if (lastOddNumbers.size() == count) {
                    break;
                }
            }
        }

        for (int i = 0; i < lastEvenNumbers.size() / 2; i++) {

            String temp = lastEvenNumbers.get(i);
            lastEvenNumbers.set(i,lastEvenNumbers.get(lastEvenNumbers.size() - 1 - i));
            lastEvenNumbers.set(lastEvenNumbers.size() - 1 - i,temp);
        }

        for (int i = 0; i < lastOddNumbers.size() / 2; i++) {

            String temp = lastOddNumbers.get(i);
            lastOddNumbers.set(i,lastOddNumbers.get(lastOddNumbers.size() - 1 - i));
            lastOddNumbers.set(lastOddNumbers.size() - 1 - i,temp);
        }

        if (type.equals("even")) {

            System.out.printf("[%s]%n", String.join(", ", lastEvenNumbers));
        } else {

            System.out.printf("[%s]%n", String.join(", ", lastOddNumbers));
        }
    }

    private static void PrintFirst(String[] tokens, ArrayList<Integer> numbers) {
        int count = Integer.parseInt(tokens[1]);
        String type = tokens[2];

        ArrayList<String> firstEvenNumbers = new ArrayList<>();
        ArrayList<String> firstOddNumbers = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                firstEvenNumbers.add(numbers.get(i).toString());

                if (firstEvenNumbers.size() == count) {
                    break;
                }
            }
        }

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 != 0) {
                firstOddNumbers.add(numbers.get(i).toString());

                if (firstOddNumbers.size() == count) {
                    break;
                }
            }
        }

        if (type.equals("even")) {

            System.out.printf("[%s]%n", String.join(", ", firstEvenNumbers));

        } else {
            System.out.printf("[%s]%n", String.join(", ", firstOddNumbers));
        }
    }

    private static int GetMinIndex(String[] tokens, ArrayList<Integer> numbers) {
        String type = tokens[1];
        int minEvenIndex = -1;
        int minOddIndex = -1;
        int minEvenNum = Integer.MAX_VALUE;
        int minOddNum = Integer.MAX_VALUE;

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0 && numbers.get(i) <= minEvenNum) {
                minEvenNum = numbers.get(i);
                minEvenIndex = i;
            } else if (numbers.get(i) % 2 != 0 && numbers.get(i) <= minOddNum) {
                minOddNum = numbers.get(i);
                minOddIndex = i;
            }
        }

        if (type.equals("even")) {
            return minEvenIndex;
        } else {
            return minOddIndex;
        }
    }

    private static int GetMaxIndex(String[] tokens, ArrayList<Integer> numbers) {
        String type = tokens[1];
        int maxEvenIndex = -1;
        int maxOddIndex = -1;
        int maxEvenNum = Integer.MIN_VALUE;
        int maxOddNum = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.size(); i++) {

            int current = numbers.get(i);
            if (current % 2 == 0 && current >= maxEvenNum) {
                maxEvenNum = numbers.get(i);
                maxEvenIndex = i;
            } else if (current % 2 != 0 && current >= maxOddNum) {
                maxOddNum = numbers.get(i);
                maxOddIndex = i;
            }
        }

        if (type.equals("even")) {
            return maxEvenIndex;

        } else {
            return maxOddIndex;
        }
    }

    private static ArrayList<Integer> Exchange(String[] tokens, ArrayList<Integer> numbers) {
        int index = Integer.parseInt(tokens[1]);

        if (index < 0 || index >= numbers.size()) {
            System.out.println(("Invalid index"));

        } else {
            ArrayList<Integer> changed = new ArrayList<>();

            for (int i = 0; i < numbers.size(); i++) {
                if (i > index) {
                    changed.add(numbers.get(i));
                }
            }

            for (int i = 0; i <= index; i++) {
                changed.add(numbers.get(i));
            }

            numbers = changed;
        }

        return numbers;
    }
}
