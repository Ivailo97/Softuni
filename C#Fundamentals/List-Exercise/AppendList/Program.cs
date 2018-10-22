using System;
using System.Collections.Generic;
using System.Linq;

namespace AppendList
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] arrays = Console.ReadLine().Split("|");
            List<int> resultList = new List<int>();

            for (int i = arrays.Length - 1; i >= 0; i--)
            {
                int[] currentArray = arrays[i]
                    .Split(' ',StringSplitOptions.RemoveEmptyEntries)
                    .Select(int.Parse)
                    .ToArray();

                resultList.AddRange(currentArray);
            }

            Console.WriteLine(string.Join(" ",resultList));
        }
    }
}
