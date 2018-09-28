using System;

namespace CircleArea
{
    class Program
    {
        static void Main(string[] args)
        {
            double rad = double.Parse(Console.ReadLine());

            double area = Math.PI * rad * rad;

            Console.WriteLine($"{area:f12}");

        }
    }
}
