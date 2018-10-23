using System;
using System.Collections.Generic;
using System.Linq;

namespace PokemonDontGo
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> nums = Console.ReadLine().Split().Select(int.Parse).ToList();

            long removedSum = 0;

            while (nums.Count > 0)
            {
                int index = int.Parse(Console.ReadLine());

                int removedNumber = 0;

                if (index < nums.Count && index > -1)
                {
                    removedNumber = nums[index];

                    nums.RemoveAt(index);

                    removedSum += removedNumber;

                    for (int i = 0; i < nums.Count; i++)
                    {
                        if (nums[i] <= removedNumber)
                        {
                            nums[i] += removedNumber;
                        }
                        else
                        {
                            nums[i] -= removedNumber;
                        }
                    }
                }
                else if (index < 0)
                {
                    removedNumber = nums[0];

                    removedSum += removedNumber;

                    nums[0] = nums[nums.Count - 1];

                    for (int i = 0; i < nums.Count; i++)
                    {
                        if (nums[i] <= removedNumber)
                        {
                            nums[i] += removedNumber;
                        }
                        else
                        {
                            nums[i] -= removedNumber;
                        }
                    }

                }
                else if (index >= nums.Count)
                {
                    removedNumber = nums[nums.Count - 1];

                    removedSum += removedNumber;

                    nums[nums.Count - 1] = nums[0];

                    for (int i = 0; i < nums.Count; i++)
                    {
                        if (nums[i] <= removedNumber)
                        {
                            nums[i] += removedNumber;
                        }
                        else
                        {
                            nums[i] -= removedNumber;
                        }
                    }
                }
            }
            Console.WriteLine(removedSum);
        }
    }
}

