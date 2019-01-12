using System;
using System.Text;

namespace ReplaceAllCharacters
{
    class Program
    {
        static void Main(string[] args)
        {
            string line = Console.ReadLine();

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < line.Length; i++)
            {
                if (i == 0)
                {
                    sb.Append(line[i]);
                    continue;
                }

                if (sb.ToString()[sb.Length - 1] != line[i])
                {
                    sb.Append(line[i]);
                }
            }

            Console.WriteLine(sb);

        }
    }
}
