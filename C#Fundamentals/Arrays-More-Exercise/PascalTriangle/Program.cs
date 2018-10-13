using System;

namespace PascalTriangle
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            string[] prev = new string[1];

            for (int i = 1; i <= n; i++)
            {

                string[] sequence = new string[i];
                sequence[0] = "1";
                sequence[sequence.Length - 1] = "1";

                if (i <= 2)
                {

                    Console.WriteLine(string.Join(" ", sequence));
                    prev = sequence;
                    continue;
                }

                if (prev.Length != 1)
                {

                    for (int j = 0; j < prev.Length - 1; j++)
                    {

                        sequence[j + 1] = (int.Parse(prev[j]) + int.Parse(prev[j + 1])).ToString();
                    }

                    Console.WriteLine(string.Join(" ", sequence));
                    prev = sequence;
                }
            }
        }
    }
}
