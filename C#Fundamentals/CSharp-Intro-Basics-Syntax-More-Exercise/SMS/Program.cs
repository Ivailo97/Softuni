using System;
using System.Collections.Generic;

namespace SMS
{
    class Program
    {
        static void Main(string[] args)
        {
            Dictionary<int, List<char>> pairs = new Dictionary<int, List<char>>();

            for (int i = 0; i <= 9; i++)
            {
                pairs.Add(i, new List<char>());
            }

            pairs[0].Add(' ');

            int count = 6;
            for (char i = 'a'; i <= 'z'; i++)
            {
                if (i == 'z')
                {
                    pairs[9].Add(i);
                }
                else if (i == 's')
                {
                    pairs[7].Add(i);
                }
                else
                {
                    int index = count / 3;
                    pairs[index].Add(i);
                    count++;
                }
            }

            int wordLen = int.Parse(Console.ReadLine());
            string sms = "";

            for (int i = 0; i < wordLen; i++)
            {
                string numberAsString = Console.ReadLine();
                int key = int.Parse(numberAsString[0].ToString());

               sms += pairs[key][numberAsString.Length - 1];

            }

            Console.WriteLine(sms);
        }
    }
}
