using System;

namespace SpecialNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int num = int.Parse(Console.ReadLine());

            for (int i = 1; i <= num; i++)
            {
                int sum = 0;
                int copy = i;

                while (copy != 0)
                {
                    int lastDigit = copy % 10;
                    copy /= 10;
                    sum += lastDigit;
                }

                bool flag = false;

                if (sum == 5 || sum == 7 || sum == 11)
                {
                    flag = true;
                }

                Console.WriteLine($"{i} -> {flag}");
            }
        }
    }
}
