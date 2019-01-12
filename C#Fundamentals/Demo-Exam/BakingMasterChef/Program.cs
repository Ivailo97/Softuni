using System;

namespace BakingMasterChef
{
    class Program
    {
        static void Main(string[] args)
        {
            double budget = double.Parse(Console.ReadLine());
            int students = int.Parse(Console.ReadLine());

            double pricePerFlour = double.Parse(Console.ReadLine());
            double pricePerEgg = double.Parse(Console.ReadLine());
            double pricePerApron = double.Parse(Console.ReadLine());

            int freePackages = students / 5;

            double totalPrice = pricePerApron * (Math.Ceiling(students * 1.2)) + pricePerEgg * 10 * students
                    + pricePerFlour * (students - freePackages);


            if (totalPrice <= budget)
            {
                Console.WriteLine($"Items purchased for {totalPrice:f2}$.");
            }
            else
            {
                Console.WriteLine($"{totalPrice-budget:f2}$ more needed.");
            }
        }
    }
}
