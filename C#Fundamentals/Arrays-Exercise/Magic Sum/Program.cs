using System;
using System.Linq;


namespace Magic_Sum
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] nums = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int[] pair = new int[2];

            int sum = int.Parse(Console.ReadLine());

            for (int i = 0; i < nums.Length - 1; i++)
            {
                for (int j =  i + 1; j < nums.Length; j++)
                {

                    if (nums[i] + nums[j] == sum)
                    {
                        pair[0] = nums[i];
                        pair[1] = nums[j];

                        Console.WriteLine(string.Join(" ", pair));
                    }
                }
            }
        }
    }
}
