using System;
using System.Collections.Generic;
using System.Linq;

namespace Courses
{
    class Program
    {
        static void Main(string[] args)
        {
            Dictionary<string, List<string>> pairs = new Dictionary<string, List<string>>();

            while (true)
            {
                string line = Console.ReadLine();

                if (line == "end")
                {
                    break;
                }

                string[] tokens = line.Split(" : ");
                string courseName = tokens[0];
                string studentName = tokens[1];

                if (!pairs.ContainsKey(courseName))
                {
                    pairs.Add(courseName, new List<string>());
                }

                if (!pairs[courseName].Contains(studentName))
                {
                    pairs[courseName].Add(studentName);
                }
            }

            foreach (var pair in pairs.OrderByDescending(x => x.Value.Count))
            {
                Console.WriteLine($"{pair.Key}: {pair.Value.Count}");

                foreach (var student in pair.Value.OrderBy(x => x))
                {
                    Console.WriteLine($"-- {student}");
                }
            }
        }
    }
}
