using System;
using System.Linq;

namespace EqualArrays
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] nums = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int[] numsNext = Console.ReadLine().Split().Select(int.Parse).ToArray();

            int index = 0;
            int sum = 0;
            bool areEqual = true;

            for (int i = 0; i < nums.Length; i++)
            {

                if (nums[i] != numsNext[i])
                {

                    index = i;
                    areEqual = false;
                    break;
                }

                sum += nums[i];

            }

            if (areEqual)
            {
                Console.WriteLine($"Arrays are identical. Sum: {sum}");
            }
            else
            {
                Console.WriteLine($"Arrays are not identical. Found difference at {index} index");
            }
        }
    }
}
