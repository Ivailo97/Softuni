using System;
using System.Collections.Generic;
using System.Linq;

namespace CompanyUsers
{
    class Program
    {
        static void Main(string[] args)
        {
            Dictionary<string, List<string>> pairs = new Dictionary<string, List<string>>();
            while (true)
            {
                string line = Console.ReadLine();
                if (line == "End")
                {
                    break;
                }

                string[] tokens = line.Split(" -> ");
                string name = tokens[0];
                string id = tokens[1];

                if (!pairs.ContainsKey(name))
                {
                    pairs.Add(name, new List<string>());
                }

                if (!pairs[name].Contains(id))
                {
                    pairs[name].Add(id);
                }
            }

            foreach (var pair in pairs.OrderBy(x => x.Key))
            {
                Console.WriteLine($"{pair.Key}");

                foreach (var id in pair.Value)
                {
                    Console.WriteLine($"-- {id}");
                }
            }
        }
    }
}
