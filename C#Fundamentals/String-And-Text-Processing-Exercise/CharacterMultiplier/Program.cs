using System;

namespace CharacterMultiplier
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] strings = Console.ReadLine().Split();

            int sum = GetSum(strings[0], strings[1]);
            Console.WriteLine(sum);
        }

        public static int GetSum(string first, string second)
        {
            int sum = 0;
            int minLen = Math.Min(first.Length, second.Length);
            int maxLen = Math.Max(first.Length, second.Length);
            string maxString = "";
            int count = 0;

            if (first.Length == maxLen)
            {
                maxString = first;
            }
            else
            {
                maxString = second;
            }

            for (int i = 0; i < minLen; i++)
            {
                sum += first[i] * second[i];
                count = i;
            }

            for (int i = count + 1; i < maxLen; i++)
            {
                sum += maxString[i];
            }
            return sum;
        }
    }
}
