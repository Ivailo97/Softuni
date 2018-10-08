using System;
using System.Collections.Generic;
using System.Linq;

namespace KaminoFactory
{
    class Program
    {
        static void Main(string[] args)
        {
            int len = int.Parse(Console.ReadLine());

            int sequenceIndex = 0;
            int bestSequenceIndex = 0;

            int sequenceSum = 0;
            int prevSequenceSum = 0;

            int onesInARow = 1;
            int bestOnesInARow = 1;

            List<string> result = new List<string>();
            int startOnesIndex = 0;

            int prevBestStartOnesIndex = 1000;

            List<string> allRows = new List<string>();

            while (true)
            {
                string line = Console.ReadLine();
                allRows.Add(line);

                List<string> sequence = line.Split(new[] { '!' }, StringSplitOptions.RemoveEmptyEntries).ToList();
                sequenceIndex++;

                

                if (sequence[0] == "Clone them")
                {
                    break;
                }

                int startIndex = sequence.IndexOf("1");

                for (int i = startIndex + 1; i < sequence.Count; i++)
                {
                    if (sequence[i] == "1")
                    {
                        onesInARow++;

                        if (onesInARow > 1)
                        {
                            startOnesIndex = i - onesInARow + 1;
                        }

                        else
                        {
                            startOnesIndex = i;
                        }

                        sequenceSum = sequence.Select(int.Parse).ToList().Sum();

                        if (onesInARow > bestOnesInARow ||
                            onesInARow == bestOnesInARow &&
                            startOnesIndex < prevBestStartOnesIndex ||
                            onesInARow == bestOnesInARow && startOnesIndex == prevBestStartOnesIndex
                            && sequenceSum > prevSequenceSum
                            )
                        {
                            bestOnesInARow = onesInARow;

                            bestSequenceIndex = sequenceIndex;

                            result = sequence;

                            sequenceSum = sequence.Select(int.Parse).ToList().Sum();

                            prevSequenceSum = sequenceSum;

                            prevBestStartOnesIndex = startOnesIndex;
                        }
                    }
                    else
                    {
                        onesInARow = 0;

                    }
                }

                if (bestOnesInARow == 1 && startIndex < prevBestStartOnesIndex)
                {

                    result = sequence;

                    sequenceSum =sequence.Select(int.Parse).Sum();

                    prevBestStartOnesIndex = startIndex;

                    bestSequenceIndex = sequenceIndex;
                }

                startOnesIndex = 0;
                onesInARow = 1;

            }

            int[] resultSeqNums = allRows[bestSequenceIndex - 1]
                .Split(new char[] { '!' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();

            Console.WriteLine($"Best DNA sample {bestSequenceIndex} with sum: {resultSeqNums.Sum()}.");
            Console.WriteLine(string.Join(" ", result));
        }
    }
}

