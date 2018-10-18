using System;

namespace Methods_More_Exercise
{
    class Program
    {
        static void Main(string[] args)
        {
            string type = Console.ReadLine();

            switch (type)
            {
                case "string":
                    string input = Console.ReadLine();
                    PrintResult(input);
                    break;
                case "real":
                    double number = double.Parse(Console.ReadLine());
                    PrintResult(number);
                    break;
                case "int":
                    int num = int.Parse(Console.ReadLine());
                    PrintResult(num);
                    break;
            }

        }

        private static void PrintResult(double number)
        {

            Console.WriteLine($"{number * 1.5:f2}");

        }

        private static void PrintResult(int number)
        {

            Console.WriteLine($"{number * 2}");
        }

        private static void PrintResult(String input)
        {

            Console.WriteLine($"${input}$");
        }
    }
}
