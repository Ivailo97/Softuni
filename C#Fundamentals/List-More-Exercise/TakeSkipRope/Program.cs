using System;
using System.Collections.Generic;
using System.Linq;

namespace TakeSkipRope
{
    class Program
    {
        static void Main(string[] args)
        {
            List<char> line = Console.ReadLine().ToList();
            List<int> digits = new List<int>();
            List<char> nonNumbers = new List<char>();

            for (int i = 0; i < line.Count; i++)
            {
                if (char.IsDigit(line[i]))
                {
                    digits.Add(int.Parse(line[i] + ""));
                }
                else
                {
                    nonNumbers.Add(line[i]);
                }
            }

            List<int> take = new List<int>();
            List<int> skip = new List<int>();

            for (int i = 0; i < digits.Count; i++)
            {
                if (i % 2 == 0)
                {
                    take.Add(digits[i]);
                }
                else
                {
                    skip.Add(digits[i]);
                }
            }

            string result = "";
            int skiped = 0;
            int taken = 0;

            for (int i = 0; i < take.Count; i++)
            {
                int total = skiped + taken;

                List<char> current = nonNumbers.Skip(total).Take(take[i]).ToList();
                result += string.Join("", current);

                skiped += skip[i];
                taken += take[i];
            }

            Console.WriteLine(result);
        }
    }
}
