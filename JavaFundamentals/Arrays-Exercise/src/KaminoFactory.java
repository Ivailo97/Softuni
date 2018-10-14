import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class KaminoFactory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int len = Integer.parseInt(scanner.nextLine());

        int sequenceIndex = 0;
        int bestSequenceIndex = 0;

        int sequenceSum = 0;
        int prevSequenceSum = 0;

        int onesInARow = 1;
        int bestOnesInARow = 1;

        ArrayList<String> result = new ArrayList<String>();
        int startOnesIndex = 0;

        int prevBestStartOnesIndex = 1000;

        ArrayList<String> allRows = new ArrayList<String>();

        while (true) {
            String line = scanner.nextLine();
            allRows.add(line);

            String[] sequence = line.split("!+");
            sequenceIndex++;


            if (sequence[0].equals("Clone them")) {
                break;
            }

            int startIndex = Arrays.asList(sequence).indexOf("1");

            for (int i = startIndex + 1; i < sequence.length; i++) {
                if (sequence[i].equals("1")) {
                    onesInARow++;

                    if (onesInARow > 1) {
                        startOnesIndex = i - onesInARow + 1;
                    } else {
                        startOnesIndex = i;
                    }

                    sequenceSum = 0;

                    for (int j = 0; j < sequence.length; j++) {

                        sequenceSum += Integer.parseInt(sequence[j]);
                    }

                    if (onesInARow > bestOnesInARow ||
                            onesInARow == bestOnesInARow &&
                                    startOnesIndex < prevBestStartOnesIndex ||
                            onesInARow == bestOnesInARow && startOnesIndex == prevBestStartOnesIndex
                                    && sequenceSum > prevSequenceSum
                            ) {
                        bestOnesInARow = onesInARow;

                        bestSequenceIndex = sequenceIndex;

                        result = new ArrayList<>(Arrays.asList(sequence));

                        sequenceSum = 0;

                        for (int j = 0; j < sequence.length; j++) {

                            sequenceSum += Integer.parseInt(sequence[j]);
                        }

                        prevSequenceSum = sequenceSum;

                        prevBestStartOnesIndex = startOnesIndex;
                    }
                } else {
                    onesInARow = 0;

                }
            }

            if (bestOnesInARow == 1 && startIndex < prevBestStartOnesIndex) {

                result = new ArrayList<>(Arrays.asList(sequence));

                sequenceSum = 0;

                for (int i = 0; i < sequence.length; i++) {

                    sequenceSum += Integer.parseInt(sequence[i]);
                }

                prevBestStartOnesIndex = startIndex;

                bestSequenceIndex = sequenceIndex;
            }

            onesInARow = 1;

        }

        int[] resultSeqNums = Arrays.stream(allRows.get(bestSequenceIndex - 1)
                .split("!+")).mapToInt(Integer::parseInt)
                .toArray();

        int resultSum = 0;

        for (int num : resultSeqNums) {

            resultSum += num;
        }

        System.out.printf("Best DNA sample %d with sum: %d.%n", bestSequenceIndex, resultSum);

        System.out.println(String.join(" ", result));
    }
}

