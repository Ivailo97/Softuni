using System;
using System.Collections.Generic;
using System.Linq;

namespace ListOperations
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> numbers = Console.ReadLine().Split().Select(int.Parse).ToList();

            while (true)
            {
                string command = Console.ReadLine();

                if (command == "End")
                {
                    break;
                }

                string[] tokens = command.Split();
                string action = tokens[0];

                switch (action)
                {
                    case "Add":
                        int number = int.Parse(tokens[1]);
                        numbers.Add(number);
                        break;

                    case "Insert":
                        int element = int.Parse(tokens[1]);
                        int position = int.Parse(tokens[2]);

                        if (position < 0 || position >= numbers.Count)
                        {
                            Console.WriteLine("Invalid index");
                            continue;
                        }

                        numbers.Insert(position, element);
                        break;

                    case "Remove":
                        int index = int.Parse(tokens[1]);
                        if (index < 0 || index > numbers.Count)
                        {
                            Console.WriteLine("Invalid index");
                            continue;
                        }
                        numbers.RemoveAt(index);
                        break;

                    case "Shift":
                        string direction = tokens[1];
                        int count = int.Parse(tokens[2]);

                        if (direction == "left")
                        {
                            for (int i = 0; i < count % numbers.Count; i++)
                            {
                                int temp = numbers[0];
                                numbers.RemoveAt(0);
                                numbers.Add(temp);
                            }
                        }
                        else if (direction == "right")
                        {
                            for (int i = 0; i < count % numbers.Count; i++)
                            {
                                int temp = numbers.Last();
                                numbers.RemoveAt(numbers.Count - 1);
                                numbers.Insert(0, temp);
                            }
                        }
                        break;
                }
            }
            Console.WriteLine(string.Join(" ",numbers));
        }
    }
}
