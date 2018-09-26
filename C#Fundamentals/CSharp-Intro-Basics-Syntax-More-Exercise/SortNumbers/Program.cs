using System;
using System.Linq;

namespace SortNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] nums = new int[3];

            for (int i = 0; i < nums.Length; i++)
            {
                nums[i] = int.Parse(Console.ReadLine());
            }

            foreach (int num in nums.OrderByDescending(x=>x))
            {
                Console.WriteLine(num);
            }
        }
    }
}
