using System;
using System.Text.RegularExpressions;
using System.Text;
using System.Linq;

namespace RageQuit
{
    class Program
    {
        static void Main(string[] args)
        {
            string line = Console.ReadLine().ToUpper();

            Regex regex = new Regex(@"(?<text>[^\d]{1,20})(?<count>\d+)");

            MatchCollection matches = regex.Matches(line);

            StringBuilder builder = new StringBuilder();

            foreach (Match match in matches)
            {
                int count = int.Parse(match.Groups["count"].ToString());

                if (count <= 20 && count >= 1)
                {
                    string message = match.Groups["text"].ToString();

                    for (int i = 0; i < count; i++)
                    {
                        builder.Append(message);
                    }
                }
            }

            char[] symbols = builder.ToString().ToCharArray();

            symbols = symbols.Distinct().ToArray();

            Console.WriteLine($"Unique symbols used: {symbols.Length}");

            Console.WriteLine(builder);
        }
    }
}

