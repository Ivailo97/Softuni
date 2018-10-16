import java.util.Scanner;

public class TopNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        PrintTopNumbers(n);
    }

    private static void PrintTopNumbers(int n)
    {

        for (int i = 1; i <= n; i++)
        {
            int copy = i;
            int sum = 0;
            boolean hasOdd = false;

            while (copy != 0)
            {
                int current = copy % 10;

                if (current % 2 != 0)
                {
                    hasOdd = true;
                }
                sum += current;
                copy /= 10;
            }

            if (sum % 8 == 0 && hasOdd)
            {
                System.out.println(i);
            }
        }
    }
}


