using System;
using System.Collections.Generic;

namespace LettersChangeNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] words = Console.ReadLine().Split(" \t".ToCharArray(), StringSplitOptions.RemoveEmptyEntries);

            double sum = 0;

            foreach (var word in words)
            {
                char firstLetter = word[0];

                int num = int.Parse(word.Substring(1, word.Length - 2));

                char lastLetter = word[word.Length - 1];

                double currentSum = 0;

                if (char.IsUpper(firstLetter))
                {

                    currentSum = num * 1.0 / (firstLetter - 64);
                }
                else
                {
                    currentSum = num * 1.0 * (firstLetter - 96);
                }

                if (char.IsUpper(lastLetter))
                {
                    currentSum -= (lastLetter - 64.0);
                }
                else
                {
                    currentSum += (lastLetter - 96.0);
                }

                sum += currentSum;
            }

            Console.WriteLine($"{sum:f2}");
        }
    }
}
