
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace NetherRealms
{
    class Program
    {
        static void Main(string[] args)
        {
            Dictionary<string, Demon> demons = new Dictionary<string, Demon>();

            string[] nameLines = Regex.Split(Console.ReadLine(), @" *, *");

            foreach (string name in nameLines)
            {
                Demon demon = new Demon();

                string demonName = name;

                MatchCollection matchedSymbols = Regex.Matches(name, @"[^0-9\+\-\*\/\.]");

                long health = 0;

                foreach (Match symbol in matchedSymbols)
                {
                    health += char.Parse(symbol.Value);
                }

                demon.Health = health;

                double damage = 0;

                MatchCollection matches = Regex.Matches(name, @"(-)?\d+(\.\d+)*");

                foreach (Match match in matches)
                {
                    damage += double.Parse(match.Value);
                }

                MatchCollection operators = Regex.Matches(name, @"(\*|\/)");

                foreach (Match match in operators)
                {
                    if (match.Value == "/")
                    {
                        damage /= 2;
                    }
                    else
                    {
                        damage *= 2;
                    }
                }

                demon.Damage = damage;

                if (demons.ContainsKey(demonName) == false)
                {
                    demons.Add(demonName, demon);
                }
            }

            foreach (var demon in demons.OrderBy(x => x.Key))
            {
                Console.WriteLine($"{demon.Key} - {demon.Value.Health} health, {demon.Value.Damage:f2} damage");
            }
        }
    }

    class Demon
    {
        public long Health { get; set; }
        public double Damage { get; set; }
    }
}
