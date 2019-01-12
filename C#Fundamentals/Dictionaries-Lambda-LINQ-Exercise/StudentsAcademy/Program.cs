using System;
using System.Collections.Generic;
using System.Linq;

namespace StudentsAcademy
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            Dictionary<string, List<double>> pairs = new Dictionary<string, List<double>>();

            for (int i = 0; i < n; i++)
            {
                string name = Console.ReadLine();
                double grade = double.Parse(Console.ReadLine());

                if (!pairs.ContainsKey(name))
                {

                    pairs.Add(name, new List<double>());
                }

                pairs[name].Add(grade);
            }

            pairs = pairs.Where(x => x.Value.Average() >= 4.50)
                .OrderByDescending(x=>x.Value.Average())
                .ToDictionary(x => x.Key, y => y.Value);

            foreach (var pair in pairs)
            {
                Console.WriteLine($"{pair.Key} -> {pair.Value.Average():f2}");
            }
        }
    }
}
