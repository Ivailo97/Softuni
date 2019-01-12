using System;
using System.Collections.Generic;
using System.Linq;

namespace Orders
{
    class Program
    {
        static void Main(string[] args)
        {
            Dictionary<string, int> productAndQuantiry = new Dictionary<string, int>();
            Dictionary<string, decimal> productAndPrice = new Dictionary<string, decimal>();

            while (true)
            {
                string line = Console.ReadLine();

                if (line == "buy")
                {
                    break;
                }

                string[] tokens = line.Split();

                string item = tokens[0];
                decimal price = decimal.Parse(tokens[1]);
                int quantity = int.Parse(tokens[2]);


                if (!productAndQuantiry.ContainsKey(item))
                {
                    productAndQuantiry.Add(item, 0);
                    productAndPrice.Add(item, 0);
                }

                productAndPrice[item] = price;
                productAndQuantiry[item] += quantity;
            }

            foreach (var pair in productAndPrice)
            {
                decimal price = pair.Value * productAndQuantiry[pair.Key];
                Console.WriteLine($"{pair.Key} -> {price:f2}");
            }
        }
    }
}
