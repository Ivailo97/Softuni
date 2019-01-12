using System;
using System.Text.RegularExpressions;


namespace SoftUniBarIncome
{
    class Program
    {
        static void Main(string[] args)
        {
            Regex regex = new Regex
                (@"^%(?<customer>[A-Z][a-z]+)%([^|,$%.]*?)<(?<product>\w+)>([^|,$%.]*?)\|(?<count>\d+)\|([^|,$%.]*?)(?<price>\d+\.?\d+)\$$");

            double totalPrice = 0;
            while (true)
            {
                string line = Console.ReadLine();

                if (line == "end of shift")
                {
                    break;
                }

                Match match = regex.Match(line);

                if (match.Success)
                {
                    string name = match.Groups["customer"].ToString();
                    string product = match.Groups["product"].ToString();
                    int count = int.Parse(match.Groups["count"].ToString());
                    double price = double.Parse(match.Groups["price"].ToString());

                    Console.WriteLine($"{name}: {product} - {price * count:f2}");
                    totalPrice += price * count;
                }
            }
            Console.WriteLine($"Total income: {totalPrice:f2}");
        }
    }
}
