using System;

namespace StrongNumber
{
    class Program
    {
        static void Main(string[] args)
        {
            int number = int.Parse(Console.ReadLine());
            int numberCopy = number;

            int sum = 0;

            while (numberCopy != 0)
            {
                int digit = numberCopy % 10;
                numberCopy /= 10;

                int current = 1;

                for (int i = digit; i >= 1; i--)
                {
                    current *= i;
                }

                sum += current;
            }

            if (sum == number)
            {
                Console.WriteLine("yes");
            }
            else
            {
                Console.WriteLine("no");
            }
        }
    }
}
