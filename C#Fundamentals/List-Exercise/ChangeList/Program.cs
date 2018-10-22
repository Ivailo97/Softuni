using System;
using System.Collections.Generic;
using System.Linq;

namespace ChangeList
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> list = Console.ReadLine().Split().Select(int.Parse).ToList();

            while (true)
            {
                string command = Console.ReadLine();

                if (command == "end")
                {
                    break;
                }

                string[] tokens = command.Split();
                string action = tokens[0];

                switch (action)
                {
                    case "Delete":

                        string element = tokens[1];
                        list.RemoveAll(x => x == int.Parse(element));
                        break;

                    case "Insert":

                        int number = int.Parse(tokens[1]);
                        int index = int.Parse(tokens[2]);

                        if (index > list.Count || index < 0)
                        {
                            continue;
                        }

                        list.Insert(index, number);
                        break;
                }
            }

            Console.WriteLine(string.Join(" ", list));
        }
    }
}
