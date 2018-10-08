using System;
using System.Linq;

namespace EqualSum
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = Console.ReadLine().Split().Select(int.Parse).ToArray();

            int leftSum = 0;
            int rightSum = 0;
            int index = 0;

            if (arr.Length == 1)
            {
                Console.WriteLine(0);
            }
            else
            {
                for (int l = 0; l < arr.Length; l++)
                {
                    if (l > 0)
                    {
                        for (int g = 0; g < l; g++)
                        {
                            leftSum += arr[g];
                        }

                        for (int h = l + 1; h < arr.Length; h++)
                        {
                            rightSum += arr[h];
                        }

                        if (rightSum == leftSum)
                        {
                            index = l;
                            Console.WriteLine(index);
                            return;
                        }
                        else
                        {
                            leftSum = 0;
                            rightSum = 0;
                        }
                    }
                    else
                    {
                        for (int h = l + 1; h < arr.Length; h++)
                        {
                            rightSum += arr[h];
                        }

                        if (rightSum == leftSum)
                        {
                            index = l;
                            Console.WriteLine(index);
                            return;
                        }
                        else
                        {
                            leftSum = 0;
                            rightSum = 0;
                        }
                    }
                }
                Console.WriteLine("no");
            }
        }
    }
}
