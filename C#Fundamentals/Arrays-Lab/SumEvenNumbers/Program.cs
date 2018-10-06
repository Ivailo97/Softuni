using System;
using System.Linq;

namespace EvenOddSumSubtraction
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] nums = Console.ReadLine().Split().Select(int.Parse).ToArray();

            int oddSum = 0;
            int evenSum = 0;

            for (int i = 0; i < nums.Length; i++)
            {

                if (nums[i] % 2 == 0)
                {
                    evenSum += nums[i];
                }
                else
                {
                    oddSum += nums[i];
                }
            }

            int diff = evenSum - oddSum;

            Console.WriteLine(diff);
        }
    }
}
