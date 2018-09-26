using System;

namespace GamingStore
{
    class Program
    {
        static void Main(string[] args)
        {
            double money = double.Parse(Console.ReadLine());
            string type = Console.ReadLine();
            double totalSpent = 0;


            while (type !="Game Time")
            {
                if (type == "CS: OG")
                {

                    if (money < 15.99)
                    {
                        Console.WriteLine("Too Expensive");
                    }
                    else
                    {
                        money -= 15.99;
                        totalSpent += 15.99;
                        Console.WriteLine("Bought CS: OG");
                    }
                    if (money == 0)
                    {
                        Console.WriteLine("Out of money!");
                        break;
                    }
                }
                else if (type == "Zplinter Zell")
                {

                    if (money < 19.99)
                    {
                        Console.WriteLine("Too Expensive"); 
                    }
                    else
                    {
                        money -= 19.99;
                        totalSpent += 19.99;
                        Console.WriteLine("Bought Zplinter Zell");
                    }
                    if (money == 0)
                    {
                        Console.WriteLine("Out of money!");
                        break;
                    }
                }
                else if (type == "RoverWatch")
                {

                    if (money < 29.99)
                    {
                        Console.WriteLine("Too Expensive");
                    }
                    else
                    {
                        money -= 29.99;
                        totalSpent += 29.99;
                        Console.WriteLine("Bought RoverWatch");
                    }
                    if (money == 0)
                    {
                        Console.WriteLine("Out of money!");
                        break;
                    }
                }
                else if (type == "RoverWatch Origins Edition")
                {

                    if (money < 39.99)
                    {
                        Console.WriteLine("Too Expensive");
                    }
                    else
                    {
                        money -= 39.99;
                        totalSpent += 39.99;
                        Console.WriteLine("Bought RoverWatch Origins Edition");
                    }
                    if (money == 0)
                    {
                        Console.WriteLine("Out of money!");
                        break;
                    }
                }
                else if (type == "OutFall 4")
                {

                    if (money < 39.99)
                    {
                        Console.WriteLine("Too Expensive");
                    }
                    else
                    {
                        money -= 39.99;
                        totalSpent += 39.99;
                        Console.WriteLine("Bought OutFall 4");
                    }
                    if (money == 0)
                    {
                        Console.WriteLine("Out of money!");
                        break;
                    }
                }
                else if (type == "Honored 2")
                {

                    if (money < 59.99)
                    {
                        Console.WriteLine("Too Expensive");
                    }
                    else
                    {
                        money -= 59.99;
                        totalSpent += 59.99;
                        Console.WriteLine("Bought Honored 2");
                    }
                    if (money == 0)
                    {
                        Console.WriteLine("Out of money!");
                        break;
                    }
                }
                else
                {
                    Console.WriteLine("Not Found");
                }

                type = Console.ReadLine();
            }
            if (money > 0)
            {
                Console.WriteLine($"Total spent: ${totalSpent:f2}. Remaining: ${money:f2}");
            }
        }
    }
}
