using System;
using System.Collections.Generic;
using System.Linq;

namespace ListManipulationAdvanced
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> numbers = Console.ReadLine().Split().Select(int.Parse).ToList();

            string command = Console.ReadLine();
            bool changed = false;
            while (command != "end")
            {
                string[] tokens = command.Split();
                string action = tokens[0];

                switch (action)
                {
                    case "Add":
                        int number = int.Parse(tokens[1]);
                        numbers.Add(number);
                        changed = true;
                        break;

                    case "Remove":
                        int numberToRemove = int.Parse(tokens[1]);
                        numbers = numbers.Where(x => x != numberToRemove).ToList();
                        changed = true;
                        break;

                    case "RemoveAt":
                        int index = int.Parse(tokens[1]);
                        numbers.RemoveAt(index);
                        changed = true;
                        break;

                    case "Insert":
                        int numberToInsert = int.Parse(tokens[1]);
                        int position = int.Parse(tokens[2]);
                        numbers.Insert(position, numberToInsert);
                        changed = true;
                        break;

                    case "Contains":
                        int numberToCheck = int.Parse(tokens[1]);

                        if (numbers.Contains(numberToCheck))
                        {
                            Console.WriteLine("Yes");
                        }
                        else
                        {
                            Console.WriteLine("No such number");
                        }
                        break;

                    case "PrintEven":
                    case "PrintOdd":
                        if (action.Contains("Even"))
                        {
                            List<int> evenNumbers = numbers.Where(x => x % 2 == 0).ToList();
                            Console.WriteLine(string.Join(" ", evenNumbers));
                        }
                        else
                        {
                            List<int> oddNumbers = numbers.Where(x => x % 2 != 0).ToList();
                            Console.WriteLine(string.Join(" ", oddNumbers));
                        }
                        break;

                    case "GetSum":
                        Console.WriteLine(numbers.Sum());
                        break;

                    case "Filter":
                        string condition = tokens[1];
                        int numToCompare = int.Parse(tokens[2]);

                        List<int> filtered = new List<int>();

                        if (condition == ">=")
                        {
                            filtered = numbers.Where(x => x >= numToCompare).ToList();
                        }
                        else if (condition == "<=")
                        {
                            filtered = numbers.Where(x => x <= numToCompare).ToList();
                        }
                        else if (condition == "<")
                        {
                            filtered = numbers.Where(x => x < numToCompare).ToList();

                        }
                        else if (condition == ">")
                        {
                            filtered = numbers.Where(x => x > numToCompare).ToList();

                        }
                        Console.WriteLine(string.Join(" ", filtered));
                        break;
                }
                command = Console.ReadLine();
            }

            if (changed)
            {
                Console.WriteLine(string.Join(" ",numbers));
            }
        }
    }
}
