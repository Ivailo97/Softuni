import java.util.Scanner;

public class TroubleShooting {
    public static void main(String[] args) {

        Scanner elly = new Scanner(System.in);

        int sequence = Integer.parseInt(elly.nextLine());

        String line = elly.nextLine();

        int bestLength = 0;
        String bestDna = "";
        int bestIndex = 0;
        int bestSum = 0;
        int counter = 0;
        int bestCounter = 0;

        while (!line.equalsIgnoreCase("clone them!")) {

            counter++;

            String replaced = line.replaceAll("!", "");

            String[] dnas = replaced.split("0");

            int maxLength = 0;

            int sum = 0;

            for (int i = 0; i < dnas.length; i++) {

                if (dnas[i].length() > maxLength) {

                    maxLength = dnas[i].length();
                }

                sum += dnas[i].length();
            }

            int beginIndex = replaced.indexOf(GetString(maxLength));

            if (maxLength > bestLength
                    || counter == 1
                    || (beginIndex < bestIndex)
                    || sum > bestSum
                    || sum > bestSum) {

                bestLength = maxLength;
                bestDna = replaced;
                bestIndex = beginIndex;
                bestSum = sum;
                bestCounter = counter;

            }

            line = elly.nextLine();
        }

        System.out.printf("Best DNA sample %d with sum: %d.", bestCounter, bestSum);
        System.out.println();

        for (int i = 0; i < bestDna.length(); i++) {

            System.out.print(bestDna.charAt(i) + " ");
        }
        System.out.println();
    }
    public static String GetString (int len){

        String result = "";

        for (int i = 0; i < len; i++) {

            result += "1";
        }

        return result;
    }
}