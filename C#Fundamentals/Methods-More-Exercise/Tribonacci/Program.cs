using System;

namespace Tribonacci
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            PrintTribonacci(n);
        }

        private static void PrintTribonacci(int i)
        {

            long f0 = 1;
            long f1 = 1;
            long f2 = 2;

            long f3 = f0 + f1 + f2;

            if (i == 1)
            {
                Console.WriteLine(1);
                return;
            }
            else if (i == 2)
            {
                Console.WriteLine(1 + " " + 1);
                return;
            }

            Console.Write($"{f0} {f1} {f2} ");

            for (int j = 1; j <= i - 3; j++)
            {
                Console.Write($"{f3} ");

                f0 = f1;
                f1 = f2;
                f2 = f3;

                f3 = f0 + f1 + f2;
            }
        }
    }
}
