using System;

namespace Division
{
    class Program
    {
        static void Main(string[] args)
        {
            int num = int.Parse(Console.ReadLine());

            int diviser = 0;

            if (num % 10 == 0)
            {
                diviser = 10;
            }
            else if (num % 7 == 0)
            {
                diviser = 7;
            }
            else if (num % 6 == 0)
            {
                diviser = 6;
            }
            else if (num % 3 == 0)
            {
                diviser = 3;
            }
            else if (num % 2 == 0)
            {
                diviser = 2;
            }

            if (diviser == 0)
            {
                Console.WriteLine("Not divisible");
            }
            else
            {
                Console.WriteLine($"The number is divisible by {diviser}");
            }
        }
    }
}
