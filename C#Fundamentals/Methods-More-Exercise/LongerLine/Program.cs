using System;

namespace LongerLine
{
    class Program
    {
        static void Main(string[] args)
        {
            double x1 = double.Parse(Console.ReadLine());
            double y1 = double.Parse(Console.ReadLine());

            double x2 = double.Parse(Console.ReadLine());
            double y2 = double.Parse(Console.ReadLine());

            double x3 = double.Parse(Console.ReadLine());
            double y3 = double.Parse(Console.ReadLine());

            double x4 = double.Parse(Console.ReadLine());
            double y4 = double.Parse(Console.ReadLine());

            PrintLongerLine(x1, y1, x2, y2, x3, y3, x4, y4);
        }

        static void PrintMinToCenter(double num1, double num2, double num3, double num4)
        {
            double sum1 = CalculatePythagorean(num1, num2);
            double sum2 = CalculatePythagorean(num3, num4);

            if (sum1 <= sum2)
            {
                Console.WriteLine($"({num1}, {num2})({num3}, {num4})");
            }
            else
            {
                Console.WriteLine($"({num3}, {num4})({num1}, {num2})");
            }
        }

        static double CalculatePythagorean(double x, double y)
        {
            double result = Math.Sqrt(x * x + y * y);
            return result;
        }

        static void PrintLongerLine(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4)
        {
            double firstLine = CalculatePythagorean(Math.Pow(x2 - x1, 2), Math.Pow(y2 - y1, 2));
            double secondLine = CalculatePythagorean(Math.Pow(x4 - x3, 2), Math.Pow(y4 - y3, 2));

            if (firstLine >= secondLine)
            {
                PrintMinToCenter(x1, y1, x2, y2);
            }
            else
            {
                PrintMinToCenter(x3, y3, x4, y4);
            }
        }
    }
}
