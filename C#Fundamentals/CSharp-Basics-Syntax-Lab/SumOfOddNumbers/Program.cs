using System;

namespace SumOfOddNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int num = int.Parse(Console.ReadLine());

            int sum = 0;
            int count = 0;

            for (int i = 1; i < 1000; i++)
            {
                if (i % 2 != 0)
                {
                    sum += i;
                    count++;
                    Console.WriteLine(i);
                }

                if (count == num)
                {
                    break;
                }
            }

            Console.WriteLine($"Sum: {sum}");
        }
    }
}
