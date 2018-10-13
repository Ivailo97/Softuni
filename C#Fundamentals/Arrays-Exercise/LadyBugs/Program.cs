using System;
using System.Linq;

namespace LadyBugs
{
    class Program
    {
        static void Main(string[] args)
        {
            int size = int.Parse(Console.ReadLine());
            int[] bugsPositions = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int[] field = new int[size];

            for (int i = 0; i < bugsPositions.Length; i++)
            {
                if (bugsPositions[i] >= 0 && bugsPositions[i] < size)
                {
                    int index = bugsPositions[i];
                    field[index] = 1;
                }
            }

            string command = Console.ReadLine();

            while (command != "end")
            {
                string[] tokens = command.Split();

                int bugPosition = int.Parse(tokens[0]);
                string direction = tokens[1];
                int distance = int.Parse(tokens[2]);

                bool condition = bugPosition < 0
                    || bugPosition >= size
                    || field[bugPosition] != 1
                    || distance == 0;

                if (condition)
                {
                    command = Console.ReadLine();
                    continue;
                }

                Move(field, direction, bugPosition, distance);
            }

            Console.WriteLine(string.Join(" ", field));
        }

        public static void Move(int[] field, string direction, int position, int distance)
        {
            int startIndex = 0;

            switch (direction)
            {
                case "right":
                    startIndex = position + distance;
                    field[position] = 0;

                    for (int i = startIndex; i < field.Length; i += distance)
                    {
                        if (field[i] == 0)
                        {
                            field[i] = 1;
                            field[position] = 0;
                            break;
                        }
                    }

                    break;

                case "left":
                    startIndex = position - distance;
                    field[position] = 0;

                    for (int i = startIndex; i >= 0; i -= distance)
                    {
                        if (field[i] == 0)
                        {
                            field[i] = 1;
                            field[position] = 0;
                            break;
                        }
                    }
                    break;
            }
        }
    }
}
