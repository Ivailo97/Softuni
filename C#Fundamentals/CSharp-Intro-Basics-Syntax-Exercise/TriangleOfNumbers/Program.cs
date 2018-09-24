using System;

namespace TriangleOfNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            for (int i = 1; i <= n; i++)
            {
                Print($"{i} ", i);
                
            }
        }

        public static void Print(string input, int times)
        {
            for (int i = 0; i < times; i++)
            {
                Console.Write(input);
            }

            Console.WriteLine();
        }
    }
}
