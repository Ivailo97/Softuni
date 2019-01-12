using System;
using System.Text.RegularExpressions;

namespace ExtractEmail
{
    class Program
    {
        static void Main(string[] args)
        {
            string line = Console.ReadLine();

            string pattern1 = @"(?<= )[A-Za-z0-9]+([.\-_][A-Za-z0-9]+)*@[A-Za-z]+(\-[A-Za-z]+)*(\.[A-Za-z]+)+";

            Regex regex = new Regex(pattern1);

            MatchCollection matchesUsers = regex.Matches(line);

            foreach (Match item in matchesUsers)
            {
                Console.WriteLine(item);
            }
        }
    }
}
