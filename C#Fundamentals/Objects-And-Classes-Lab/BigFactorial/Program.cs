using System;
using System.Numerics;

namespace BigFactorial
{
    class Program
    {
        static void Main(string[] args)
        {
            int f = int.Parse(Console.ReadLine());

            BigInteger result = 1;

            for (int i = 1; i <= f; i++)
            {

                result *= i;
            }

            Console.WriteLine(result);
        }
    }
}
