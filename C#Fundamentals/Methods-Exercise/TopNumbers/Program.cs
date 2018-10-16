using System;

namespace TopNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            PrintTopNumbers(n);
        }

        private static void PrintTopNumbers(int n)
        {

            for (int i = 1; i <= n; i++)
            {
                int copy = i;
                int sum = 0;
                bool hasOdd = false;

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
                    Console.WriteLine(i);
                }
            }
        }
    }
}
