using System;
using System.Linq;
using System.Collections.Generic;

namespace ArrayRotation
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> nums = Console.ReadLine().Split().Select(int.Parse).ToList();

            int n = int.Parse(Console.ReadLine());

            for (int i = 0; i < n % nums.Count; i++)
            {
                int temp = nums[0];
                nums.RemoveAt(0);
                nums.Add(temp);
            }

            Console.WriteLine(string.Join(" ",nums));


        }
    }
}
