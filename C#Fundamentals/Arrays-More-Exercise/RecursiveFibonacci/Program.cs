using System;

namespace RecursiveFibonacci
{
    class Program
    {
        static void Main(string[] args)
        {

            int number = int.Parse(Console.ReadLine());

            Console.WriteLine(Fib(number - 1));
        }

        static long Fib(int n)
        {
            if (n < 2)
            {
                return 1L;
            }

            return Fib(n - 1) + Fib(n - 2);
        }
    }
}
