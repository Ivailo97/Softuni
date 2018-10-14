using System;

namespace GreaterOfTwoValues
{
    class Program
    {
        static void Main(string[] args)
        {
            string type = Console.ReadLine().ToLower();

            switch (type)
            {
                case "int":
                    long num1 = long.Parse(Console.ReadLine());
                    long num2 = long.Parse(Console.ReadLine());
                    PrintMaxInt(num1, num2);
                    break;
                case "char":
                    char symbol1 = char.Parse(Console.ReadLine());
                    char symbol2 = char.Parse(Console.ReadLine());
                    PrintMaxChar(symbol1, symbol2);
                    break;
                case "string":
                    string text1 = Console.ReadLine();
                    string text2 = Console.ReadLine();
                    PrintMaxString(text1, text2);
                    break;
            }
        }

        private static void PrintMaxString(string text1, string text2)
        {
            if (text1.CompareTo(text2) >= 0)
            {
                Console.WriteLine(text1);
            }
            else
            {
                Console.WriteLine(text2);
            }
        }

        private static void PrintMaxChar(char symbol1, char symbol2)
        {

            if ((int)symbol1 > (int)symbol2)
            {
                Console.WriteLine(symbol1);
            }
            else
            {
                Console.WriteLine(symbol2);
            }
        }

        private static void PrintMaxInt(long num1, long num2)
        {

            if (num1 > num2)
            {
                Console.WriteLine(num1);
            }
            else
            {
                Console.WriteLine(num2);
            }

        }
    }
}

