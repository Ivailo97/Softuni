using System;

namespace NxNMatrix
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            PrintMatrix(n);
        }

        private static void PrintMatrix(int n)
        {
            for (int i = 0; i < n; i++)
            {
                RepeatString(n);
                Console.WriteLine();
            }
        }

        private static void RepeatString(int number)
        {
            for (int i = 0; i < number; i++)
            {
                Console.Write(number + " ");

            }
        }
    }
}
