using System;
using System.Text.RegularExpressions;
using System.Text;
using System.Collections.Generic;
using System.Linq;

namespace StarEnigma
{
    class Program
    {
        static void Main(string[] args)
        {

            int n = int.Parse(Console.ReadLine());
            List<string> attacked = new List<string>();
            List<string> destroyed = new List<string>();

            Regex letterMatcher = new Regex(@"[sStTaArR]");

            Regex matcher = new Regex(@"@(?<name>[A-Za-z]+)[^@\-,!:>]*?:(?<population>\d+)[^@\-,!:>]*?!(?<attackType>A|D)![^@\-,!:>]*?->(?<soldierCount>\d+)");

            for (int i = 0; i < n; i++)
            {
                string line = Console.ReadLine();
                MatchCollection letters = letterMatcher.Matches(line);
                int count = letters.Count;
                StringBuilder decryptedline = new StringBuilder();

                for (int k = 0; k < line.Length; k++)
                {

                    decryptedline.Append((char)(line[k] - count));
                }

                Match match = matcher.Match(decryptedline.ToString());

                if (match.Success)
                {
                    if (match.Groups["attackType"].ToString() == "A")
                    {
                        attacked.Add(match.Groups["name"].ToString());
                    }
                    else
                    {
                        destroyed.Add(match.Groups["name"].ToString());
                    }
                }
            }

            Console.WriteLine($"Attacked planets: {attacked.Count}");

            foreach (string planet in attacked.OrderBy(x => x))
            {
                Console.WriteLine($"-> {planet}");
            }

            Console.WriteLine($"Destroyed planets: {destroyed.Count} ");

            foreach (string planet in destroyed.OrderBy(x=>x))
            {
                Console.WriteLine($"-> {planet}");
            }
        }
    }
}
