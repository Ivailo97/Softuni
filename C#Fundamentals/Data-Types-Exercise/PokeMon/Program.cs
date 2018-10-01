using System;

namespace PokeMon
{
    class Program
    {
        static void Main(string[] args)
        {
            int power = int.Parse(Console.ReadLine());
            int distance = int.Parse(Console.ReadLine());
            int factor = int.Parse(Console.ReadLine());
            int counter = 0;

            if (distance > power)
            {
                Console.WriteLine(power);
                Console.WriteLine(0);
            }
            else
            {

                int copyPower = power;

                while (true)
                {

                    if (power == 0.5 * copyPower)
                    {
                        if (power >= factor && factor != 0)
                        {
                            power /= factor;
                        }

                    }

                    if (distance > power)
                    {
                        break;
                    }

                    power -= distance;
                    counter++;
                }
            }

            Console.WriteLine(power);
            Console.WriteLine(counter);
        }
    }
}
