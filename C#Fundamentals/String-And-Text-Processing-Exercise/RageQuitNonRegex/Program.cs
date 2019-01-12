using System;
using System.Text;
using System.Linq;

namespace RageQuitNonRegex
{
    class Program
    {
        static void Main(string[] args)
        {
            string line = Console.ReadLine().ToUpper();

            StringBuilder sb = new StringBuilder();
            StringBuilder stb = new StringBuilder();

            for (int i = 0; i < line.Length; i++)
            {
                int count = 1;

                if (!char.IsDigit(line[i]))
                {
                    stb.Append(line[i]);
                }
                else if (line[i] == '0')
                {
                    stb.Clear();
                }
                else if (char.IsDigit(line[i]) && i + 1 < line.Length && char.IsDigit(line[i + 1]))
                {
                    string countAsString = line[i] + "" + line[i + 1];

                    count = int.Parse(countAsString);

                    if (count <= 20 && count >= 1)
                    {
                        for (int k = 0; k < count; k++)
                        {
                            sb.Append(stb);

                        }

                        stb.Clear();
                    }
                }
                else if(char.IsDigit(line[i]))
                {
                    count = int.Parse(line[i].ToString());

                    if (count <= 20 && count >= 1)
                    {
                        for (int k = 0; k < count; k++)
                        {
                            sb.Append(stb);

                        }

                        stb.Clear();
                    }
                }
            }

            char[] unique = sb.ToString().ToCharArray();
            unique = unique.Distinct().ToArray();
            Console.WriteLine($"Unique symbols used: {unique.Length}");
            Console.WriteLine(sb);
        }
    }
}
