using System;
using System.Collections.Generic;
using System.Linq;

namespace BombNumbers
{
    class Program
    {
        static void Main()
        {
            List<int> nums = Console.ReadLine().Split().Select(int.Parse).ToList();
            int[] bombNums = Console.ReadLine().Split().Select(int.Parse).ToArray();

            int bombNumber = bombNums[0];
            int range = bombNums[1];

            int bombIndex = nums.IndexOf(bombNumber);

            while (bombIndex != -1)
            {
                int left = bombIndex - range;
                int right = bombIndex + range;

                if (left < 0)
                {
                    left = 0;
                }

                if (right > nums.Count - 1)
                {
                    right = nums.Count - 1;
                }

                int count = right - left + 1;
                nums.RemoveRange(left, count);

                bombIndex = nums.IndexOf(bombNumber);
            }

            int sum = 0;
            foreach (int num in nums)
            {
                sum += num;
            }

            Console.WriteLine(sum);
        }
    }
}