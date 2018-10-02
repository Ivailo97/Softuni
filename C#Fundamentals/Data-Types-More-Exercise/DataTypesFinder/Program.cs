using System;

namespace DataTypesFinder
{
    class Program
    {
        static void Main(string[] args)
        {
            while (true)
            {
                string input = Console.ReadLine();

                if (input == "END")
                {
                    break;
                }

                bool isInteger = long.TryParse(input, out long result);
                bool isBool = bool.TryParse(input, out bool result1);
                bool isRealNumber = decimal.TryParse(input, out decimal result2);
                bool isChar = char.TryParse(input, out char result3);
               

                if (isInteger)
                {
                    Console.WriteLine($"{input} is integer type");
                }
                else if (isBool)
                {
                    Console.WriteLine($"{input} is boolean type");
                }
                else if (isRealNumber)
                {
                    Console.WriteLine($"{input} is floating point type");
                }
                else if (isChar)
                {
                    Console.WriteLine($"{input} is character type");
                }
                else
                {
                    Console.WriteLine($"{input} is string type");
                }
            }
        }
    }
}
