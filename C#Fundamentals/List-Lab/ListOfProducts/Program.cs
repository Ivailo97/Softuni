using System;
using System.Collections.Generic;
using System.Linq;

namespace ListOfProducts
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            List<string> producs = new List<string>();

            for (int i = 0; i < n; i++)
            {
                producs.Add(Console.ReadLine());
            }

            int count = 1;

            foreach (var item in producs.OrderBy(x => x))
            {
                Console.WriteLine($"{count}.{item}");
                count++;
            }
        }
    }
}
