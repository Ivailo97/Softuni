using System;
using System.Text.RegularExpressions;
using System.Text;

namespace HTMLParser
{
    class Program
    {
        static void Main(string[] args)
        {

            string text = Console.ReadLine();

            Regex tittleMatcher = new Regex(@"(?<=<title>).+(?=<\/title>)");
            Regex bodyMatcher = new Regex(@"(?<=>|\\n|<body>)(?<!<title>)[^<>\n\d\\]+?(?=<|<\/body>)");

            Match title = tittleMatcher.Match(text);
            MatchCollection bodyMatches = bodyMatcher.Matches(text);

            StringBuilder sb = new StringBuilder();

            foreach (Match match in bodyMatches)
            {
                
                sb.Append(match.ToString() + " ");
            }

            Console.WriteLine($"Title: {title.ToString()}");
            Console.WriteLine($"Content: {sb}");
        }
    }
}
