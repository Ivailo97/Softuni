using System;
using System.Linq;
using System.Collections.Generic;

namespace SoftUniExamResults
{
    class Program
    {
        static void Main(string[] args)
        {
            string line = Console.ReadLine();

            Dictionary<string, int> nameAndPoints = new Dictionary<string, int>();
            Dictionary<string, int> languageAndSubmitions = new Dictionary<string, int>();

            while (line != "exam finished")
            {
                string[] tokens = line.Split('-');

                string name = tokens[0];
                string language = tokens[1];

                if (language == "banned")
                {
                    if (nameAndPoints.ContainsKey(name))
                    {
                        nameAndPoints.Remove(name);
                    }

                    line = Console.ReadLine();
                    continue;
                }

                int points = int.Parse(tokens[2]);

                if (nameAndPoints.ContainsKey(name) == false)
                {
                    nameAndPoints.Add(name, 0);
                }

                if (nameAndPoints[name] < points)
                {
                    nameAndPoints[name] = points;
                }

                if (languageAndSubmitions.ContainsKey(language) == false)
                {
                    languageAndSubmitions.Add(language, 1);
                }
                else
                {
                    languageAndSubmitions[language]++;
                }

                line = Console.ReadLine();
            }

            Console.WriteLine("Results:");
            foreach (var user in nameAndPoints.OrderByDescending(x => x.Value).ThenBy(x => x.Key))
            {
                Console.WriteLine($"{user.Key} | {user.Value}");
            }

            Console.WriteLine("Submissions:");

            foreach (var lan in languageAndSubmitions.OrderByDescending(x => x.Value).ThenBy(x => x.Key))
            {
                Console.WriteLine($"{lan.Key} - {lan.Value}");
            }
        }
    }
}

