using System;
using System.Collections.Generic;

namespace AsciiSumator
{
    class Program
    {
        static void Main(string[] args)
        {
            char first = char.Parse(Console.ReadLine());
            char last = char.Parse(Console.ReadLine());
            string text = Console.ReadLine();

            int sum = 0;

            if (last < first)
            {

                char temp = first;
                first = last;
                last = temp;
            }

            first++;

            List<char> symbols = new List<char>();

            for (char i = first; i < last; i++)
            {

                symbols.Add(i);

            }

            for (int i = 0; i < text.Length; i++)
            {

                if (symbols.Contains(text[i]))
                {

                    sum += text[i];
                }
            }

            Console.WriteLine(sum);

        }
    }
}
