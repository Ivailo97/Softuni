using System;
using System.Collections.Generic;
using System.Linq;

namespace MixedUpList
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> firstList = Console.ReadLine().Split().Select(int.Parse).ToList();
            List<int> secondList = Console.ReadLine().Split().Select(int.Parse).ToList();
            List<int> resultList = new List<int>();

            while(true)
            {
                if (firstList.Count <= 0 || secondList.Count <= 0)
                {
                    break;
                }

                int element = firstList[0];
                firstList.RemoveAt(0);
                resultList.Add(element);

                int secondElement = secondList[secondList.Count - 1];
                secondList.RemoveAt(secondList.Count - 1);
                resultList.Add(secondElement);
                
            }

            List<int> parameters = new List<int>();
            
            if (firstList.Count == 2)
            {
                parameters = firstList;
            }
            else
            {
                parameters = secondList;
            }

            int start = 0;
            int end = 0;

            if (parameters[0] > parameters[1])
            {
                start = parameters[1];
                end = parameters[0];
            }
            else
            {
                start = parameters[0];
                end = parameters[1];
            }

            resultList = resultList.Where(x => x > start && x < end).OrderBy(x => x).ToList();

            Console.WriteLine(string.Join(" ",resultList));

        }
    }
}
