using System;
using System.Linq;
using System.Collections.Generic;

namespace MaxSequenceOfMaxElements
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = Console.ReadLine().Split().Select(int.Parse).ToArray();

            int len = 1;
            int bestStart = 0;
            int bestLen = 1;

            for (int i = 1; i < arr.Length; i++)
            {
                if (arr[i] == arr[i - 1])
                {
                    len++;

                    if (len > bestLen)
                    {
                        bestLen = len;
                        bestStart = i - bestLen + 1;
                    }
                }
                else
                {
                    len = 1;

                }
            }

            for (int i = 0; i < bestLen; i++)
            {
                Console.Write(arr[bestStart + i] + " ");
            }
        }
    }
}
