using System;

namespace DayOfWeek
{
    class Program
    {
        static void Main(string[] args)
        {
            int number = int.Parse(Console.ReadLine());
            string[] arr = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };

            if (number <= 7 && number >= 1)
            {
                Console.WriteLine(arr[number - 1]);
            }
            else
            {

                Console.WriteLine("Invalid day!");
            }
        }
    }
}
