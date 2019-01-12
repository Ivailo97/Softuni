using System;
using System.Linq;
using System.Collections.Generic;

namespace BakingRush
{
    class Program
    {
        static void Main(string[] args)
        {
            string daysEvents = Console.ReadLine();
            int energy = 100;
            int coins = 100;

            string[] events = daysEvents.Split("|");

            foreach (var evenT in events)
            {
                string[] tokens = evenT.Split("-");
                string nameOrIngredient = tokens[0];
                int number = int.Parse(tokens[1]);

                switch (nameOrIngredient)
                {

                    case "rest":
                        if (energy == 100)
                        {
                            number = 0;
                        }
                        else if (energy + number > 100)
                        {
                            number = 100 - energy;
                            energy = 100;
                        }
                        else
                        {
                            energy += number;
                        }
                       
                        Console.WriteLine($"You gained {number} energy.");
                        Console.WriteLine($"Current energy: {energy}.");
                        break;
                    case "order":

                        if (energy - 30 >= 0)
                        {
                            coins += number;
                            energy -= 30;
                            Console.WriteLine($"You earned {number} coins.");
                        }
                        else
                        {
                            energy += 50;
                            Console.WriteLine("You had to rest!");
                            continue;
                        }
                        break;

                    default:
                        coins -= number;

                        if (coins > 0)
                        {
                            Console.WriteLine($"You bought {nameOrIngredient}.");
                        }
                        else
                        {
                            Console.WriteLine($"Closed! Cannot afford {nameOrIngredient}.");
                            return;
                        }
                        break;
                }
            }
            Console.WriteLine("Day completed!");
            Console.WriteLine($"Coins: {coins}");
            Console.WriteLine($"Energy: {energy}");
        }
    }
}
