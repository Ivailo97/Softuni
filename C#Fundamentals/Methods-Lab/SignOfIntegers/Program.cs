using System;

namespace SignOfIntegers
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            string type = GetType(n);

            Console.WriteLine($"The number {n} is {type}.");
        }

        private static string GetType(int n)
        {

            if (n > 0)
            {
                return "positive";
            }
            else if (n < 0)
            {

                return "negative";
            }
            else
            {
                return "zero";
            }
        }
    }
}
