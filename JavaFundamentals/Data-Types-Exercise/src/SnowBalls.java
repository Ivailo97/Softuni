import java.math.BigInteger;
import java.util.Scanner;

public class SnowBalls {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        BigInteger bestValue =  new BigInteger("-1");

        int bestSnowballSnow = 0;
        int bestSnowballTime = 0;
        int bestSnowballQuality = 0;

        for (int i = 0; i < n; i++)
        {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());

            int divided = snowballSnow / snowballTime;
            String dividedAsString = Integer.toString(divided);


            BigInteger currentSum = new BigInteger(dividedAsString);

            BigInteger current =currentSum.pow(snowballQuality);

            int  ress = current.compareTo(bestValue);

            if (ress > 0)
            {
                bestValue = current;
                bestSnowballTime = snowballTime;
                bestSnowballSnow = snowballSnow;
                bestSnowballQuality = snowballQuality;

            }
        }
        System.out.printf("%d : %d = %d (%d)",bestSnowballSnow,bestSnowballTime,bestValue,bestSnowballQuality);

    }
}
