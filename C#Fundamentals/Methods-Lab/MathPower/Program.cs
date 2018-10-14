using System;

namespace MathPower
{
    class Program
    {
        static void Main(string[] args)
        {
            double number = double.Parse(Console.ReadLine());
            int power = int.Parse(Console.ReadLine());
            double result = Power(number, power);


            Console.WriteLine(result);
        }


        private static double Power(double number, int power)
        {

            double result = 0d;

            result = Math.Pow(number, power);
            return result;

        }
    }
}

