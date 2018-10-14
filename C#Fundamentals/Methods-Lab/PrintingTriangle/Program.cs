using System;

namespace PrintingTriangle
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            PrintTriangle(n);
        }

        private static void PrintTriangle(int n)
        {

            for (int i = 1; i <= n; i++)
            {

                for (int j = 0; j < i; j++)
                {

                    Console.Write(j + 1 + " ");

                }
                Console.WriteLine();
            }

            for (int i = n - 1; i > 0; i--)
            {

                for (int j = 1; j <= i; j++)
                {

                    Console.Write(j + " ");
                }

                Console.WriteLine();
            }
        }
    }
}

