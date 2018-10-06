using System;
using System.Linq;

namespace RoundingNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            double[] nums = Console.ReadLine().Split().Select(double.Parse).ToArray();

            foreach (var num in nums)
            {
                Console.WriteLine($"{num} => {Math.Round(num, MidpointRounding.AwayFromZero)}");
            }
        }
    }
}
