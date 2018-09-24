using System;
using System.Collections.Generic;

namespace VendingMachine
{
    class Program
    {
        static void Main(string[] args)
        {
            decimal money = 0;

            string line = Console.ReadLine();

            while (line != "Start")
            {
                decimal insert = decimal.Parse(line);

                if (insert != (decimal)0.1
                    && insert != (decimal)0.2
                    && insert != (decimal)0.5
                    && insert != 1
                    && insert != 2)
                {
                    Console.WriteLine($"Cannot accept {insert}");
                    line = Console.ReadLine();
                    continue;
                }

                money += insert;
                line = Console.ReadLine();
            }

            string product = Console.ReadLine();

            Dictionary<string, decimal> products = new Dictionary<string, decimal>();

            products.Add("Nuts", 2);
            products.Add("Water", (decimal)0.7);
            products.Add("Crisps", (decimal)1.5);
            products.Add("Soda", (decimal)0.8);
            products.Add("Coke", 1);

            while (product != "End")
            {
                
                if (products.ContainsKey(product) && money >= products[product])
                {

                    Console.WriteLine($"Purchased {product.ToLower()}");
                    money -= products[product];

                    product = Console.ReadLine();

                }
                else
                {

                    if (products.ContainsKey(product) == false)
                    {
                        Console.WriteLine("Invalid product");
                        product = Console.ReadLine();
                        continue;
                    }
                    else if (money < products[product])
                    {
                        Console.WriteLine("Sorry, not enough money");
                        product = Console.ReadLine();
                        continue;
                    }
                }
            }

            Console.WriteLine($"Change: {money:f2}");
        }
    }
}
