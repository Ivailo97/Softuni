using System;
using System.Collections.Generic;
using System.Linq;

namespace DrumSet
{
    class Program
    {
        static void Main(string[] args)
        {
            decimal cash = decimal.Parse(Console.ReadLine());
            List<int> drums = Console.ReadLine().Split().Select(int.Parse).ToList();
            List<int> originals = new List<int>();

            foreach (int drum in drums)
            {
                originals.Add(drum);
            }

            while (true)
            {
                string command = Console.ReadLine();

                if (command == "Hit it again, Gabsy!")
                {
                    break;
                }

                int hitPower = int.Parse(command);

                for (int i = 0; i < drums.Count; i++)
                {
                    int original = originals[i];

                    drums[i] -= hitPower;

                    if (drums[i] <= 0)
                    {
                        decimal price = original * 3;

                        if (cash >= price)
                        {
                            drums[i] = original;
                            cash -= price;
                        }
                        
                    }
                }
            }

            drums = drums.Where(x => x > 0).ToList();

            Console.WriteLine(string.Join(" ",drums));
            Console.WriteLine($"Gabsy has {cash:f2}lv.");
        }
    }
}
