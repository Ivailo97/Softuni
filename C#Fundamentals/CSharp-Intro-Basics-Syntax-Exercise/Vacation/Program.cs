using System;
using System.Collections.Generic;

namespace Vacation
{
    class Program
    {
        static void Main(string[] args)
        {
            int people = int.Parse(Console.ReadLine());
            string type = Console.ReadLine();
            string day = Console.ReadLine();

            double totalPrice = 0;

            Dictionary<string, Dictionary<string, double>> pairs = new Dictionary<string, Dictionary<string, double>>();

            string type1 = "Students";
            string type2 = "Business";
            string type3 = "Regular";

            pairs.Add(type1, new Dictionary<string, double>());

            pairs[type1].Add("Monday", 9.5);
            pairs[type1].Add("Tuesday", 8);
            pairs[type1].Add("Wednesday", 6.85);
            pairs[type1].Add("Thursday", 7.15);
            pairs[type1].Add("Friday", 8.45);
            pairs[type1].Add("Saturday", 9.80);
            pairs[type1].Add("Sunday", 10.46);

            pairs.Add(type2, new Dictionary<string, double>());

            pairs[type2].Add("Monday", 11.80);
            pairs[type2].Add("Tuesday", 14.50);
            pairs[type2].Add("Wednesday", 12.60);
            pairs[type2].Add("Thursday", 13.20);
            pairs[type2].Add("Friday", 10.90);
            pairs[type2].Add("Saturday", 15.60);
            pairs[type2].Add("Sunday", 16);

            pairs.Add(type3, new Dictionary<string, double>());

            pairs[type3].Add("Monday", 15);
            pairs[type3].Add("Tuesday", 15);
            pairs[type3].Add("Wednesday", 14.80);
            pairs[type3].Add("Thursday", 13.90);
            pairs[type3].Add("Friday", 15);
            pairs[type3].Add("Saturday", 20);
            pairs[type3].Add("Sunday", 22.50);

            totalPrice = pairs[type][day] * people;

            if (type == "Students" && people >= 30)
            {
                totalPrice *= 0.85;
            }
            else if (type == "Business" && people >= 100)
            {
                double price = totalPrice / people;
                totalPrice = (people - 10) * price;
            }
            else if (type == "Regular" && people >= 10 && people <= 20)
            {
                totalPrice *= 0.95;
            }

            Console.WriteLine($"Total price: {totalPrice:f2}");
        }
    }
}

