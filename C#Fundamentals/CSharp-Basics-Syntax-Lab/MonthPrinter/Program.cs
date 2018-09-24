using System;

namespace MonthPrinter
{
    class Program
    {
        static void Main(string[] args)
        {
            int num = int.Parse(Console.ReadLine());

            string[] months = new string[]
            {"January","February","March","April","May","June","July"
            ,"August","September","October","November","December"};

            if(num > 12 || num < 1)
            {
                Console.WriteLine("Error!");
            }
            else
            {
                Console.WriteLine(months[num - 1]);
            }
        }
    }
}
