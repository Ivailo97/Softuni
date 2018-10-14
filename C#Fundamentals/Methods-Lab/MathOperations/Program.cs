using System;

namespace MathOperations
{
    class Program
    {
        static void Main(string[] args)
        {
            int firstNum = int.Parse(Console.ReadLine());
            string action = Console.ReadLine();
            int lastNum = int.Parse(Console.ReadLine());

            PrintResult(firstNum, action, lastNum);
        }

        private static void PrintResult(int firstNum, String action, int lastNum)
        {
            double sum = 0;
            switch (action)
            {
                case "/":
                    sum = firstNum / lastNum;
                    break;
                case "*":
                    sum = firstNum * lastNum;
                    break;
                case "+":
                    sum = firstNum + lastNum;
                    break;
                case "-":
                    sum = firstNum - lastNum;
                    break;
            }

            Console.WriteLine($"{Math.Round(sum,2)}");
        }
    }
}
