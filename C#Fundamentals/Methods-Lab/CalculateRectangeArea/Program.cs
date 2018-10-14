using System;

namespace CalculateRectangeArea
{
    class Program
    {
        static void Main(string[] args)
        {
            int width = int.Parse(Console.ReadLine());
            int length =int.Parse(Console.ReadLine());

            PrintArea(width, length);
        }

        private static void PrintArea(int width, int length)
        {

            Console.WriteLine(width * length);
        }
    }
}

