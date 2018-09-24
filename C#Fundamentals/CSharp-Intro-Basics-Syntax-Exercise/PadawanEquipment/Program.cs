using System;

namespace PadawanEquipment
{
    class Program
    {
        static void Main(string[] args)
        {
            decimal money = decimal.Parse(Console.ReadLine());
            int students = int.Parse(Console.ReadLine());
            decimal priceForSaber = decimal.Parse(Console.ReadLine());
            decimal priceForRobe = decimal.Parse(Console.ReadLine());
            decimal priceForBelt = decimal.Parse(Console.ReadLine());

            decimal totalPrice = priceForSaber * (Math.Ceiling(students * (decimal)1.1)) + priceForRobe * students 
                + priceForBelt * (students - students / 6);

            if (money >= totalPrice)
            {
                Console.WriteLine($"The money is enough - it would cost {Math.Round(totalPrice,2):f2}lv.");
            }
            else
            {
                Console.WriteLine($"Ivan Cho will need {Math.Round(totalPrice - money,2):f2}lv more.");
            }
        }
    }
}
