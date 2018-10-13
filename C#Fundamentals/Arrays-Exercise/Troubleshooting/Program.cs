using System;
using System.Linq;

class Program
{
    static void Main()
    {
        int sizeOfField = int.Parse(Console.ReadLine());
        int[] field = new int[sizeOfField];
        int[] initialIndexesOfAllLadybugs = Console.ReadLine().Split().Select(int.Parse).ToArray();

        foreach (var index in initialIndexesOfAllLadybugs)
        {
            if (index >= 0 && index <= sizeOfField - 1)
            {
                field[index] = 1;
            }
        }

        string input = Console.ReadLine();

        while (input != "end")
        {
            string[] command = input.Split().ToArray();

            int[] commandIntegers = new int[2];
            commandIntegers[0] = int.Parse(command[0]);
            commandIntegers[1] = int.Parse(command[2]);

            if (commandIntegers[0] < 0
                || commandIntegers[0] >= field.Length
                || commandIntegers[1] == 0
                || field[commandIntegers[0]] != 1)
            {
                input = Console.ReadLine();
                continue;
            }

            if (command[1] == "right")
            {
                int indexAfterMovement = commandIntegers[0] + commandIntegers[1];

                field[commandIntegers[0]] = 0;

                if (indexAfterMovement >= 0 && indexAfterMovement < field.Length)
                {
                    for (int i = indexAfterMovement; i < field.Length; i += commandIntegers[1])
                    {
                        if (field[i] == 0)
                        {
                            field[i] = 1;
                            break;
                        }
                    }
                }
            }
            else if (command[1] == "left")
            {
                int indexAfterMovement = commandIntegers[0] - commandIntegers[1];

                field[commandIntegers[0]] = 0;

                for (int i = indexAfterMovement; i >= 0; i -= commandIntegers[1])
                {
                    if (field[i] == 0)
                    {
                        field[i] = 1;
                        break;
                    }
                }
            }
        }
        Console.WriteLine(string.Join(" ", field));
    }
}