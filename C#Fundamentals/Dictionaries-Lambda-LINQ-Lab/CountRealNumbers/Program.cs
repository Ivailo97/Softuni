using System;
using System.Linq;
using System.Collections.Generic;

namespace CountRealNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            List<double> numbers = Console.ReadLine().Split().Select(double.Parse).ToList();
            Dictionary<double, int> pairs = new Dictionary<double, int>();

            foreach (double number in numbers)
            {
                if (!pairs.ContainsKey(number))
                {
                    pairs.Add(number, 0);
                }

                pairs[number]++;
            }

            foreach (var pair in pairs.OrderBy(x => x.Key))
            {
                Console.WriteLine($"{pair.Key} -> {pair.Value}");
            }
        }
    }
}
