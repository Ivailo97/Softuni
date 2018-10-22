using System;
using System.Collections.Generic;
using System.Linq;

namespace CardGames
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> firstHand = Console.ReadLine().Split().Select(int.Parse).ToList();
            List<int> secondHand = Console.ReadLine().Split().Select(int.Parse).ToList();
           

            while (true)
            {
                if (firstHand.Count <= 0)
                {
                    Console.WriteLine($"Second player wins! Sum: {secondHand.Sum()}");
                    break;
                }

                if (secondHand.Count <= 0)
                {
                    Console.WriteLine($"First player wins! Sum: {firstHand.Sum()}");
                    break;
                }
               

                if (firstHand[0] > secondHand[0])
                {
                    firstHand.Add(firstHand[0]);
                    firstHand.RemoveAt(0);

                    firstHand.Add(secondHand[0]);
                    secondHand.RemoveAt(0);

                }
                else if (secondHand[0] > firstHand[0])
                {
                    secondHand.Add(secondHand[0]);
                    secondHand.RemoveAt(0);

                    secondHand.Add(firstHand[0]);
                    firstHand.RemoveAt(0);
                }
                else
                {
                    firstHand.RemoveAt(0);
                    secondHand.RemoveAt(0);
                }
            }
        }
    }
}
