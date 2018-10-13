using System;
using System.Collections.Generic;
using System.Linq;

namespace LongestIncreasingSubsequence
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] nums = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int[] len = new int[nums.Length];
            int[] prev = new int[nums.Length];

            int bestIndex = CalculateLongestIncreasingSubsequence(nums, len, prev);

            int[] lis = RestoreLIS(nums, prev, bestIndex);

            Console.WriteLine(string.Join(" ", lis));
        }

        private static int CalculateLongestIncreasingSubsequence(int[] nums, int[] len, int[] prev)
        {
            int maxIndex = 0;
            int maxLen = 0;
          
            for (int x = 0; x < nums.Length; x++)
            {
                len[x] = 1;
                prev[x] = -1;

                for (int i = 0; i < x; i++)
                {
                    if (nums[x] > nums[i] && len[i] + 1 > len[x])
                    {
                        len[x] = 1 + len[i];
                        prev[x] = i;
                    }
                }

                if (len[x] > maxLen)
                {
                    maxLen = len[x];
                    maxIndex = x;
                }
            }

            return maxIndex;
        }            

        public static int[] RestoreLIS(int[] nums, int[] prev, int lastIndex)
        {
            var longestSeq = new List<int>();

            while (lastIndex != -1 )
            {
                longestSeq.Add(nums[lastIndex]);
                lastIndex = prev[lastIndex];
            }

            longestSeq.Reverse();

            return longestSeq.ToArray();
        }
    }
}
