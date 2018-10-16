using System;

namespace FactorialDivision
{
    class Program
    {
        static void Main(string[] args)
        {
            int numberOne = int.Parse(Console.ReadLine());
            int numberTwo = int.Parse(Console.ReadLine());

            long firstFactorialSum = GetFactorial(numberOne);
            long secondFactorialSum = GetFactorial(numberTwo);


            double result = firstFactorialSum / (secondFactorialSum * 1.00);
            Console.WriteLine($"{result:f2}");

        }

        private static long GetFactorial(int numberOne)
        {
            long sum = 1;

            for (int i = 1; i <= numberOne; i++)
            {
                sum *= i;

            }

            return sum;
        }
    }
}
