using System;
using System.Collections.Generic;
using System.Linq;

namespace CountCharsInAString
{
    class Program
    {
        static void Main(string[] args)
        {

            string[] words = Console.ReadLine().Split();

            Dictionary<char, int> pairs = new Dictionary<char, int>();

            foreach (var word in words)
            {

                foreach (var symbol in word)
                {
                    if (!pairs.ContainsKey(symbol))
                    {

                        pairs.Add(symbol, 0);
                    }

                    pairs[symbol]++;

                }
            }

            foreach (var pair in pairs)
            {
                Console.WriteLine($"{pair.Key} -> {pair.Value}");
            }
        }
    }
}
