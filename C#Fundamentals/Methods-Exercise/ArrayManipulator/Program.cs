using System;
using System.Linq;
using System.Collections.Generic;

namespace ArrayManipulator
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> nums = Console.ReadLine().Split().Select(int.Parse).ToList();

            string command = Console.ReadLine();

            while (command != "end")
            {
                string[] tokens = command.Split();

                string action = tokens[0];

                switch (action)
                {
                    case "exchange":
                        int index = int.Parse(tokens[1]);
                        Exchange(nums, index);
                        break;

                    case "max":
                        string type = tokens[1];
                        PrintMaxElement(nums, type);
                        break;

                    case "min":
                        string type1 = tokens[1];
                        PrintMinElement(nums, type1);
                        break;

                    case "first":
                        string type2 = tokens[2];
                        int count = int.Parse(tokens[1]);
                        GetFirst(nums, type2, count);
                        break;
                    case "last":
                        string type3 = tokens[2];
                        int count2 = int.Parse(tokens[1]);
                        GetLast(nums, type3, count2);
                        break;
                }

                command = Console.ReadLine();
            }

            Console.WriteLine($"[{string.Join(", ", nums)}]");
        }

        private static void GetFirst(List<int> nums, string type, int count)
        {
            List<int> first = new List<int>();

            if (count > nums.Count || count < 0)
            {
                Console.WriteLine("Invalid count");
            }
            else
            {
                for (int i = 0; i < nums.Count; i++)
                {
                    if (type == "even")
                    {
                        if (nums[i] % 2 == 0)
                        {
                            first.Add(nums[i]);

                            if (first.Count == count)
                            {
                                break;
                            }
                        }
                    }
                    else
                    {
                        if (nums[i] % 2 != 0)
                        {
                            first.Add(nums[i]);

                            if (first.Count == count)
                            {
                                break;
                            }
                        }
                    }
                }

                Console.WriteLine($"[{string.Join(", ", first)}]");
            }
        }

        private static void PrintMinElement(List<int> nums, string type1)
        {
            switch (type1)
            {
                case "odd":
                    int minOdd = int.MaxValue;
                    bool hasChanged = false;

                    foreach (int num in nums)
                    {
                        if (num % 2 == 1 && num < minOdd)
                        {
                            minOdd = num;
                            hasChanged = true;
                        }
                    }

                    if (hasChanged)
                    {

                        Console.WriteLine(nums.LastIndexOf(minOdd));
                    }
                    else
                    {
                        Console.WriteLine("No matches");
                    }

                    break;

                case "even":
                    int minEven = int.MaxValue;
                    bool hasChanged1 = false;

                    foreach (int num in nums)
                    {
                        if (num % 2 == 0 && num < minEven)
                        {
                            minEven = num;
                            hasChanged1 = true;
                        }
                    }

                    if (hasChanged1)
                    {
                        Console.WriteLine(nums.LastIndexOf(minEven));

                    }
                    else
                    {
                        Console.WriteLine("No matches");
                    }
                    break;
                default:
                    break;
            }
        }

        private static void PrintMaxElement(List<int> nums, string type)
        {
            switch (type)
            {
                case "odd":
                    int maxOdd = int.MinValue;
                    bool hasChanged = false;

                    foreach (int num in nums)
                    {
                        if (num % 2 != 0 && num >= maxOdd)
                        {
                            maxOdd = num;
                            hasChanged = true;
                        }
                    }

                    if (hasChanged)
                    {

                        Console.WriteLine(nums.LastIndexOf(maxOdd));
                    }
                    else
                    {
                        Console.WriteLine("No matches");
                    }

                    break;

                case "even":
                    int maxEven = int.MinValue;
                    bool hasChanged1 = false;

                    foreach (int num in nums)
                    {
                        if (num % 2 == 0 && num >= maxEven)
                        {
                            maxEven = num;
                            hasChanged1 = true;
                        }
                    }

                    if (hasChanged1)
                    {

                        Console.WriteLine(nums.LastIndexOf(maxEven));

                    }
                    else
                    {
                        Console.WriteLine("No matches");
                    }
                    break;
                default:
                    break;
            }
        }

        private static void Exchange(List<int> nums, int index)
        {

            if (index >= nums.Count || index < 0)
            {
                Console.WriteLine("Invalid index");
            }
            else
            {
                List<int> removed = new List<int>();

                for (int i = 0; i < nums.Count; i++)
                {
                    if (i > index)
                    {
                        removed.Add(nums[i]);
                    }
                }

                nums.RemoveRange(index + 1, nums.Count - index - 1);
                nums.InsertRange(0, removed);

            }
        }

        private static void GetLast(List<int> nums, string type, int count)
        {
            if (count > nums.Count || count < 0)
            {
                Console.WriteLine("Invalid count");
            }
            else
            {

                List<int> last = new List<int>();

                for (int i = nums.Count - 1; i >= 0; i--)
                {
                    if (type == "even")
                    {
                        if (nums[i] % 2 == 0)
                        {
                            last.Add(nums[i]);

                            if (last.Count == count)
                            {
                                break;
                            }
                        }
                    }
                    else
                    {
                        if (nums[i] % 2 != 0)
                        {
                            last.Add(nums[i]);

                            if (last.Count == count)
                            {
                                break;
                            }
                        }
                    }
                }

                last.Reverse();

                Console.WriteLine($"[{string.Join(", ", last)}]");
            }
        }
    }
}


