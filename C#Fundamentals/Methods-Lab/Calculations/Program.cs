using System;

namespace Calculations
{
    class Program
    {
        static void Main(string[] args)
        {
            string action = Console.ReadLine();
            int firstNum = int.Parse(Console.ReadLine());
            int lastNum = int.Parse(Console.ReadLine());

            PrintResult(action, firstNum, lastNum);
        }

        public static void PrintResult(string action, int num1, int num2)
        {
            switch (action)
            {
                case "add":
                    Console.WriteLine(num1 + num2);
                    break;

                case "subtract":
                    Console.WriteLine(num1 - num2);
                    break;

                case "multiply":
                    Console.WriteLine(num1 * num2);
                    break;

                case "divide":
                    Console.WriteLine(num1 / num2);
                    break;
            }
        }
    }
}

