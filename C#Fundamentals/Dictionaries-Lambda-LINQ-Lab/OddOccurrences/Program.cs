using System;
using System.Linq;
using System.Collections.Generic;

namespace OddOccurrences
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] words = Console.ReadLine().ToLower().Split();

            Dictionary<string, int> resultPairs = new Dictionary<string, int>();

            foreach (string word in words)
            {
                if (!resultPairs.ContainsKey(word))
                {
                    resultPairs.Add(word, 0);
                }

                resultPairs[word]++;
            }

            foreach (var pair in resultPairs.Where(x => x.Value % 2 != 0))
            {
                Console.Write(pair.Key + " ");
            }
        }
    }
}
