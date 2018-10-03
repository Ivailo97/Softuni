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

                bool isNum = true;

                try
                {
                    int num = int.Parse(input);
                }
                catch (Exception e)
                {

                    isNum = false;
                }

                bool isDouble = true;

                try
                {
                    double num = double.Parse(input);

                }
                catch (Exception e)
                {
                    isDouble = false;
                }

                if (isNum)
                {
                    Console.WriteLine($"{input} is integer type");
                }
                else if (input.Length == 1)
                {
                    Console.WriteLine($"{input} is character type");
                }
                else if (isDouble)
                {
                    Console.WriteLine($"{input} is floating point type");
                }
                else if (input.ToLower() == "false"
                      || input.ToLower() == "true")
                {
                    Console.WriteLine($"{input} is boolean type");
                }
                else
                {
                    Console.WriteLine($"{input} is string type");
                }
            }
        }
    }
}
