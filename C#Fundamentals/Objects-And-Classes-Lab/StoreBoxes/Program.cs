using System;
using System.Collections.Generic;
using System.Linq;


namespace StoreBoxes
{
    class Program
    {
        static void Main(string[] args)
        {
            List<Box> boxes = new List<Box>();

            while (true)
            {
                string line = Console.ReadLine();

                if (line == "end")
                {
                    break;
                }

                string[] tokens = line.Split();
                int serialNumber = int.Parse(tokens[0]);
                string itemName = tokens[1];
                int itemQuantity = int.Parse(tokens[2]);
                decimal itemPrice = decimal.Parse(tokens[3]);

                decimal pricePerBox = itemQuantity * itemPrice;

                Item currentItem = new Item(itemName, itemPrice);
                Box currentBox = new Box(serialNumber,currentItem,itemQuantity,pricePerBox);

                boxes.Add(currentBox);
           }

            foreach (var box in boxes.OrderByDescending(x=>x.PricePerBox))
            {
                Console.WriteLine($"{box.SerialNumber}");
                Console.WriteLine($"-- {box.Item.Name} - ${box.Item.Price:f2}: {box.ItemQuantity}");
                Console.WriteLine($"-- ${box.PricePerBox:f2}");

            }
        }
    }
    class Item
    {
        public string Name { get; set; }
        public decimal Price { get; set; }

        public Item(string name , decimal price)
        {
            this.Name = name;
            this.Price = price;
        }
    }

    class Box
    {
        public int SerialNumber { get; set; }
        public Item Item { get; set; }
        public int ItemQuantity { get; set; }
        public decimal PricePerBox { get; set; }

        public Box(int number, Item item , int quantity, decimal pricePerBox)
        {
            this.SerialNumber = number;
            this.Item = item;
            this.ItemQuantity = quantity;
            this.PricePerBox = pricePerBox;
        }
    }
}
