using System;

namespace MultiplyEven
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            int result = GetResult(n);

            Console.WriteLine(result);
        }

        private static int GetResult(int n)
        {

            int evenSum = 0;
            int oddSum = 0;

            while (n != 0)
            {

                int digit = n % 10;

                if (digit % 2 == 0)
                {

                    evenSum += digit;
                }
                else
                {

                    oddSum += digit;
                }

                n /= 10;
            }

            int result = evenSum * oddSum;

            return result;

        }
    }
}

