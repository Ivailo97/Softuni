using System;
using System.Text.RegularExpressions;
using System.Collections.Generic;
using System.Numerics;

namespace Furniture
{
    class Program
    {
        static void Main(string[] args)
        {
            Regex regex = new Regex(@">>(?<name>.+)<<(?<price>\d+(\.\d+)?)!(?<quantity>\d+)");

            List<string> products = new List<string>();
            decimal totalPrice = 0;

            while (true)
            {
                string line = Console.ReadLine();

                if (line == "Purchase")
                {
                    break;
                }

                if (regex.IsMatch(line))
                {
                    Match match = regex.Match(line);

                    string product = match.Groups["name"].ToString();
                    decimal price = decimal.Parse(match.Groups["price"].ToString());
                    int count = int.Parse(match.Groups["quantity"].ToString());
                    products.Add(product);
                    totalPrice += price * count;
                }
            }

            Console.WriteLine("Bought furniture:");

            foreach (string product in products)
            {
                Console.WriteLine(product);
            }

            Console.WriteLine($"Total money spend: {totalPrice:f2}");
        }
    }
}
