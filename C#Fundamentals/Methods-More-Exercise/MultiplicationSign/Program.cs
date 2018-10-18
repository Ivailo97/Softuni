using System;

namespace MultiplicationSign
{
    class Program
    {
        static void Main(string[] args)
        {
            int num1 = int.Parse(Console.ReadLine());
            int num2 = int.Parse(Console.ReadLine());
            int num3 = int.Parse(Console.ReadLine());

            int[] nums = new int[3];
            nums[0] = num1;
            nums[1] = num2;
            nums[2] = num3;

            PrintSign(nums);
        }

        private static void PrintSign(int[] nums)
        {

            int negatives = 0;

            for (int i = 0; i < nums.Length; i++)
            {

                if (nums[i] < 0)
                {
                    negatives++;
                }
                else if (nums[i] == 0)
                {

                    Console.WriteLine("zero");
                    return;
                }
            }

            if (negatives % 2 != 0)
            {

                Console.WriteLine("negative");
            }
            else
            {
                Console.WriteLine("positive");
            }
        }
    }
}
