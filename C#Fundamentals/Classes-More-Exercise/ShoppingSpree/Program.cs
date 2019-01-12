using System;
using System.Collections.Generic;
using System.Linq;

namespace ShoppingSpree
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] peopleData = Console.ReadLine().Split(';', StringSplitOptions.RemoveEmptyEntries);
            string[] productsData = Console.ReadLine().Split(';', StringSplitOptions.RemoveEmptyEntries);

            List<Person> people = new List<Person>();
            List<Product> products = new List<Product>();

            foreach (string pair in peopleData)
            {
                string[] tokens = pair.Split('=');
                string name = tokens[0];
                double money = double.Parse(tokens[1]);
                Person person = new Person(name, money);
                people.Add(person);

            }

            foreach (string pair in productsData)
            {
                string[] tokens = pair.Split('=');
                string name = tokens[0];
                double price = double.Parse(tokens[1]);
                Product product = new Product(name, price);
                products.Add(product);
            }

            while (true)
            {
                string line = Console.ReadLine();

                if (line == "END")
                {
                    break;
                }

                string[] order = line.Split();
                string name = order[0];
                string productName = order[1];

                Person buyer = people.Where(x => x.Name == name).First();
                Product stock = products.Where(x => x.Name == productName).First();

                if (buyer.Money >= stock.Price)
                {
                    buyer.Products.Add(stock);
                    buyer.Money -= stock.Price;

                    Console.WriteLine($"{buyer.Name} bought {stock.Name}");
                }
                else
                {
                    Console.WriteLine($"{buyer.Name} can't afford {stock.Name}");
                }
            }

            foreach (var unit in people)
            {
                if (unit.Products.Count == 0)
                {
                    Console.WriteLine($"{unit.Name} - Nothing bought");
                }
                else
                {
                    List<string> productNames = new List<string>();

                    foreach (Product item in unit.Products)
                    {
                        productNames.Add(item.Name);
                    }

                    Console.WriteLine($"{unit.Name} - {string.Join(", ",productNames)}");
                }
            }
        }
    }

    class Person
    {
        public string Name { get; set; }
        public double Money { get; set; }
        public List<Product> Products { get; set; }

        public Person(string name, double money)
        {
            this.Name = name;
            this.Money = money;
            this.Products = new List<Product>();
        }
    }

    class Product
    {
        public string Name { get; set; }
        public double Price { get; set; }

        public Product(string name, double price)
        {
            this.Name = name;
            this.Price = price;
        }
    }
}
