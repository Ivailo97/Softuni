using System;
using System.Collections.Generic;

namespace AMinerTask
{
    class Program
    {
        static void Main(string[] args)
        {
            Dictionary<string, int> pairs = new Dictionary<string, int>();

            while (true)
            {

                string key = Console.ReadLine();

                if (key == "stop")
                {
                    break;
                }

                if (!pairs.ContainsKey(key))
                {
                    pairs.Add(key, 0);
                }

                int value = int.Parse(Console.ReadLine());

                pairs[key] += value;
            }

            foreach (var pair in pairs)
            {
                Console.WriteLine($"{pair.Key} -> {pair.Value}");
            }
        }
    }
}

