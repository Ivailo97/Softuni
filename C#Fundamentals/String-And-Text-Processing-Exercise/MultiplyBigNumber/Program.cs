using System;
using System.Text;

namespace MultiplyBigNumber
{
    class Program
    {
        static void Main(string[] args)
        {
            string num1AsString = Console.ReadLine();
            int num2 = int.Parse(Console.ReadLine());

            if (num2 == 0)
            {
                Console.WriteLine(0);
            }
            else
            {
                StringBuilder result = new StringBuilder();
                int remainder = 0;

                for (int i = num1AsString.Length - 1; i >= 0; i--)
                {
                    int digit = int.Parse(num1AsString[i].ToString());
                    int currentSum = num2 * digit + remainder;

                    remainder = currentSum / 10;
                    result.Append(currentSum % 10);
                }

                result.Append(remainder);
                string output = result.ToString().TrimEnd('0');

                for (int i = output.Length - 1; i >= 0; i--)
                {
                    Console.Write(output[i]);
                }
            }
        }
    }
}
