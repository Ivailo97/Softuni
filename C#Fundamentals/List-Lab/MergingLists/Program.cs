using System;
using System.Collections.Generic;
using System.Linq;

namespace MergingLists
{
    class Program
    {
        static void Main(string[] args)
        {

            List<int> firstList = Console.ReadLine().Split().Select(int.Parse).ToList();
            List<int> secondList = Console.ReadLine().Split().Select(int.Parse).ToList();
            List<int> resultList = new List<int>();

            for (int i = 0; ; i++)
            {

                if (i >= firstList.Count && i < secondList.Count)
                {

                    for (int j = i; j < secondList.Count; j++)
                    {

                        resultList.Add(secondList[j]);
                    }

                    break;
                }

                if (i >= secondList.Count && i < firstList.Count)
                {

                    for (int j = i; j < firstList.Count; j++)
                    {

                        resultList.Add(firstList[j]);
                    }

                    break;
                }

                if (i == secondList.Count && i == firstList.Count)
                {

                    break;
                }

                resultList.Add(firstList[i]);
                resultList.Add(secondList[i]);
            }
           
            Console.WriteLine(string.Join(" ",resultList));
        }
    }
}
