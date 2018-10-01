using System;
using System.Numerics;

namespace Snowballs
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            BigInteger bestValue = -1;

            int bestSnowballSnow = 0;
            int bestSnowballTime = 0;
            int bestSnowballQuality = 0;

            for (int i = 0; i < n; i++)
            {
                int snowballSnow = int.Parse(Console.ReadLine());
                int snowballTime = int.Parse(Console.ReadLine());
                int snowballQuality = int.Parse(Console.ReadLine());

                int divided = snowballSnow / snowballTime;

                BigInteger current = BigInteger.Pow(divided, snowballQuality);

                if (current > bestValue)
                {
                    bestValue = current;
                    bestSnowballTime = snowballTime;
                    bestSnowballSnow = snowballSnow;
                    bestSnowballQuality = snowballQuality;

                }
            }

            Console.WriteLine($"{bestSnowballSnow} : {bestSnowballTime} = {bestValue} ({bestSnowballQuality})");
        }
    }
}

