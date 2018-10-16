using System;
using System.Linq;
using System.Collections.Generic;

namespace ArrayManipulatorBEAST_MODE_ACTIVATED
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> numbers = Console.ReadLine().Split().Select(int.Parse).ToList();

            while (true)
            {
                string[] tokens = Console.ReadLine().Split();

                if (tokens[0] == "end")
                {
                    break;
                }

                string action = tokens[0];

                switch (action)
                {
                    case "exchange":
                        numbers = Exchange(tokens, numbers);
                        break;

                    case "max":
                        int index = GetMaxIndex(tokens, numbers);
                        if (index == -1)
                        {
                            Console.WriteLine("No matches");
                        }
                        else
                        {
                            Console.WriteLine(index);
                        }
                        break;

                    case "min":
                        int minIndex = GetMinIndex(tokens, numbers);
                        if (minIndex == -1)
                        {
                            Console.WriteLine("No matches");
                        }
                        else
                        {
                            Console.WriteLine(minIndex);
                        }
                        break;

                    case "first":
                        if (int.Parse(tokens[1]) > numbers.Count)
                        {
                            Console.WriteLine("Invalid count");
                        }
                        else
                        {
                            PrintFirst(tokens,numbers);
                        }
                        break;

                    case "last":
                        if (int.Parse(tokens[1]) > numbers.Count )
                        {
                            Console.WriteLine("Invalid count");
                        }
                        else
                        {
                            PrintLast(tokens, numbers);
                        }
                        break;
                }
            }

            Console.WriteLine($"[{string.Join(", ", numbers)}]");
        }

        private static void PrintLast(string[] tokens, List<int> numbers)
        {
            int count = int.Parse(tokens[1]);
            string type = tokens[2];

            List<int> lastEvenNumbers = new List<int>();
            List<int> lastOddNumbers = new List<int>();

            for (int i = numbers.Count - 1; i >= 0 ; i--)
            {
                if (numbers[i] % 2 == 0)
                {
                    lastEvenNumbers.Add(numbers[i]);

                    if (lastEvenNumbers.Count == count)
                    {
                        break;
                    }
                }
            }

            for (int i = numbers.Count - 1; i >= 0; i--)
            {
                if (numbers[i] % 2 != 0)
                {
                    lastOddNumbers.Add(numbers[i]);

                    if (lastOddNumbers.Count == count)
                    {
                        break;
                    }
                }
            }

            lastEvenNumbers.Reverse();
            lastOddNumbers.Reverse();

            if (type == "even")
            {
                Console.WriteLine($"[{string.Join(", ",lastEvenNumbers)}]");
            }
            else
            {
                Console.WriteLine($"[{string.Join(", ",lastOddNumbers)}]");
            }
        }

        private static void PrintFirst(string[] tokens, List<int> numbers)
        {
            int count = int.Parse(tokens[1]);
            string type = tokens[2];

            List<int> firstEvenNumbers = new List<int>();
            List<int> firstOddNumbers = new List<int>();

            for (int i = 0; i < numbers.Count; i++)
            {
                if (numbers[i] % 2 == 0)
                {
                    firstEvenNumbers.Add(numbers[i]);

                    if (firstEvenNumbers.Count == count)
                    {
                        break;
                    }
                }
            }

            for (int i = 0; i < numbers.Count; i++)
            {
                if (numbers[i] % 2 != 0)
                {
                    firstOddNumbers.Add(numbers[i]);

                    if (firstOddNumbers.Count == count)
                    {
                        break;
                    }
                }
            }

            if (type == "even")
            {
                Console.WriteLine($"[{string.Join(", ",firstEvenNumbers)}]");
            }
            else
            {
                Console.WriteLine($"[{string.Join(", ",firstOddNumbers)}]");
            }
        }

        private static int GetMinIndex(string[] tokens, List<int> numbers)
        {
            string type = tokens[1];
            int minEvenIndex = -1;
            int minOddIndex = -1;
            int minEvenNum = int.MaxValue;
            int minOddNum = int.MaxValue;

            for (int i = 0; i < numbers.Count; i++)
            {
                if (numbers[i] % 2 == 0 && numbers[i] <= minEvenNum)
                {
                    minEvenNum = numbers[i];
                    minEvenIndex = i;
                }
                else if (numbers[i] % 2 != 0 && numbers[i] <= minOddNum)
                {
                    minOddNum = numbers[i];
                    minOddIndex = i;
                }
            }

            if (type == "even")
            {
                return minEvenIndex;
            }
            else
            {
                return minOddIndex;
            }
        }

        private static int GetMaxIndex(string[] tokens, List<int> numbers)
        {
            string type = tokens[1];
            int maxEvenIndex = -1;
            int maxOddIndex = -1;
            int maxEvenNum = int.MinValue;
            int maxOddNum = int.MinValue;

            for (int i = 0; i < numbers.Count; i++)
            {
                if (numbers[i] % 2 == 0 && numbers[i] >= maxEvenNum)
                {
                    maxEvenNum = numbers[i];
                    maxEvenIndex = i;
                }
                else if (numbers[i] % 2 != 0 && numbers[i] >= maxOddNum)
                {
                    maxOddNum = numbers[i];
                    maxOddIndex = i;
                }
            }

            if (type == "even")
            {
                return maxEvenIndex;

            }
            else
            {
                return maxOddIndex;
            }
        }

        private static List<int> Exchange(string[] tokens, List<int> numbers)
        {
            int index = int.Parse(tokens[1]);

            if (index < 0 || index >= numbers.Count)
            {
                Console.WriteLine("Invalid index");

            }
            else
            {
                List<int> changed = new List<int>();

                for (int i = 0; i < numbers.Count; i++)
                {
                    if (i > index)
                    {
                        changed.Add(numbers[i]);
                    }
                }

                for (int i = 0; i <= index; i++)
                {
                    changed.Add(numbers[i]);
                }

                numbers = changed;
            }

            return numbers;
        }
    }
}
