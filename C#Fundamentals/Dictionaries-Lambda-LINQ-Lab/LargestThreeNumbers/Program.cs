using System;
using System.Collections.Generic;
using System.Linq;

namespace LargestThreeNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> nums = Console.ReadLine().Split().Select(int.Parse).OrderByDescending(x => x).ToList();
            int end = Math.Min(3, nums.Count);

            for (int i = 0; i < end; i++)
            {
                Console.Write(nums[i] + " ");
            }
        }
    }
}
