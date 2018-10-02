using System;
using System.Linq;


namespace FromLeftToTheRight
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            for (int i = 0; i < n; i++)
            {
                long[] nums = Console.ReadLine().Split().Select(long.Parse).ToArray();

                if (nums[0] > nums[1])
                {
                    int sum = 0;
                    char[] numAsString = nums[0].ToString().ToCharArray();

                    for (int k = 0; k < numAsString.Length; k++)
                    {
                        sum += int.Parse(numAsString[k].ToString());
                    }

                    Console.WriteLine(sum);
                }
                else
                {
                    int sum = 0;
                    char[] numAsString = nums[1].ToString().ToCharArray();

                    for (int k = 0; k < numAsString.Length; k++)
                    {
                        sum += int.Parse(numAsString[k].ToString());
                    }

                    Console.WriteLine(sum);
                }
            }

        }
    }
}
