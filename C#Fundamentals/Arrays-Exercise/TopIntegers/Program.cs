using System;
using System.Collections.Generic;
using System.Linq;

namespace TopIntegers
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> topList = new List<int>();

            int[] arr = Console.ReadLine().Split().Select(int.Parse).ToArray();
            
            for (int i = 0; i < arr.Length; i++)
            {
                bool isTop = false;

                for (int k = i + 1; k < arr.Length; k++)
                {
                    if (arr[i] > arr[k])
                    {
                        isTop = true;

                    }
                    else
                    {
                        isTop = false;
                        break;
                    }
                }

                if (isTop || i == arr.Length - 1)
                {
                    topList.Add(arr[i]);
                }
            }

            Console.WriteLine(string.Join(" ",topList));
        }
    }
}
