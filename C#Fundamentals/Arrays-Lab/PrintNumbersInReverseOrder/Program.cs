using System;

namespace PrintNumbersInReverseOrder
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            String[] nums = new String[n];


            for (int i = 0; i < n; i++)
            {

                nums[n - 1 - i] = Console.ReadLine();
            }

            Console.WriteLine(string.Join(" ", nums));
        }
    }
}
