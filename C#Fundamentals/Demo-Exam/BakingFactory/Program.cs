using System;
using System.Collections.Generic;
using System.Linq;

namespace BakingFactory
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> bestSequence = new List<int>();
            int bestTotalQuality = int.MinValue;
            int bestAverage = int.MinValue;
            int bestLen = 0;

            while (true)
            {

                string line = Console.ReadLine();

                if (line == "Bake It!")
                {

                    break;
                }
               
                List<int> breads = line.Split("#").Select(int.Parse).ToList();

                int totalQuality = breads.Sum();
                int average = 0;

                foreach (int bread in breads)
                {
                    average += bread;
                }

                average /= breads.Count;

                if (totalQuality > bestTotalQuality)
                {

                    bestTotalQuality = totalQuality;
                    bestAverage = average;
                    bestLen = breads.Count;
                    bestSequence = breads;

                }
                else if (totalQuality == bestTotalQuality)
                {

                    if (average > bestAverage)
                    {

                        bestAverage = average;
                        bestLen = breads.Count;
                        bestSequence = breads;

                    }
                    else if (average == bestAverage)
                    {

                        if (breads.Count < bestLen)
                        {

                            bestLen = breads.Count;
                            bestSequence = breads;
                        }
                    }
                }
            }

            Console.WriteLine($"Best Batch quality: {bestTotalQuality}");
            Console.WriteLine(string.Join(" ",bestSequence));

        }
    }
}
