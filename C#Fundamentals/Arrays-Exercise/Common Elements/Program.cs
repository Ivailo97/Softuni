using System;
using System.Linq;
using System.Collections.Generic;

namespace Common_Elements
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] arr1 = Console.ReadLine().Split();
            string[] arr2 = Console.ReadLine().Split();
            List<string> commons = new List<string>();

            for (int i = 0; i < arr2.Length; i++)
            {
                if (arr1.Contains(arr2[i]))
                {
                    commons.Add(arr2[i]);
                }
            }

            Console.WriteLine(string.Join(" ",commons));
        }
    }
}
