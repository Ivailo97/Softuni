using System;
using System.Text.RegularExpressions;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Race
{
    class Program
    {
        static void Main(string[] args)
        {
            List<string> participants = Console.ReadLine().Split(", ").ToList();
            Dictionary<string, int> racers = new Dictionary<string, int>();
            Regex regexForLetters = new Regex(@"([a-zA-Z]+)");
            Regex regexForNumbers = new Regex(@"\d");

            while (true)
            {
                string line = Console.ReadLine();

                if (line == "end of race")
                {
                    break;
                }

                MatchCollection letters = regexForLetters.Matches(line);
                StringBuilder name = new StringBuilder();
                foreach (Match match in letters)
                {
                    name.Append(match.ToString());
                }

                int km = 0;

                MatchCollection numbers = regexForNumbers.Matches(line);

                foreach (Match item in numbers)
                {
                    km += int.Parse(item.ToString());
                }

                string racer = name.ToString();

                if (participants.Contains(racer))
                {
                    if (!racers.ContainsKey(racer))
                    {
                        racers.Add(racer, 0);
                    }

                    racers[racer] += km;
                }
            }

            racers = racers.OrderByDescending(x => x.Value).ToDictionary(x => x.Key, y => y.Value);

            Console.WriteLine($"1st place: {racers.First().Key}");
            racers.Remove(racers.First().Key);
            Console.WriteLine($"2nd place: {racers.First().Key}");
            racers.Remove(racers.First().Key);
            Console.WriteLine($"3rd place: {racers.First().Key}");

        }
    }
}
