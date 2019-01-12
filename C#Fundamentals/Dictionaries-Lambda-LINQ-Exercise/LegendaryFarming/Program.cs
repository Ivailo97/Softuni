using System;
using System.Linq;
using System.Collections.Generic;

namespace LegendaryFarming
{
    class Program
    {
        static void Main(string[] args)
        {
            Dictionary<string, int> items = new Dictionary<string, int>();
            Dictionary<string, int> junks = new Dictionary<string, int>();

            bool legendaryItemOptained = false;

            string currencyForLegendaryItem = "";

            items.Add("shards", 0);
            items.Add("motes", 0);
            items.Add("fragments", 0);

            while (legendaryItemOptained == false)
            {
                string line = Console.ReadLine().ToLower();

                string[] tokens = line.Split();

                for (int i = 0; i < tokens.Length; i++)
                {
                    bool isNumber = Int32.TryParse(tokens[i], out int number);

                    if (tokens[i] == "shards" || tokens[i] == "motes" || tokens[i] == "fragments")
                    {

                        items[tokens[i]] += int.Parse(tokens[i - 1]);

                        if (items[tokens[i]] >= 250)
                        {
                            currencyForLegendaryItem = tokens[i];

                            legendaryItemOptained = true;
                            items[tokens[i]] -= 250;

                            break;
                        }
                    }
                    else if (isNumber == false)
                    {
                        if (junks.ContainsKey(tokens[i]) == false)
                        {
                            junks.Add(tokens[i], 0);
                        }

                        junks[tokens[i]] += int.Parse(tokens[i - 1]);
                    }
                }
            }

            string legendaryItem = "";

            switch (currencyForLegendaryItem)
            {
                case "motes":
                    legendaryItem = "Dragonwrath";
                    break;
                case "shards":
                    legendaryItem = "Shadowmourne";
                    break;
                case "fragments":
                    legendaryItem = "Valanyr";
                    break;
                default:
                    break;
            }

            Console.WriteLine($"{legendaryItem} obtained!");

            foreach (var item in items.OrderByDescending(x => x.Value).ThenBy(x => x.Key))
            {
                Console.WriteLine($"{item.Key}: {item.Value}");
            }

            foreach (var junk in junks.OrderBy(x => x.Key))
            {
                Console.WriteLine($"{junk.Key}: {junk.Value}");
            }

            Console.WriteLine();
        }
    }
}
