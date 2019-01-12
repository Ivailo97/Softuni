using System;
using System.Linq;
using System.Text;

namespace TreasureFinder
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] keySequence = Console.ReadLine().Split().Select(int.Parse).ToArray();

            while (true)
            {

                string line = Console.ReadLine();
                if (line == "find")
                {
                    break;
                }

                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < line.Length; i++)
                {

                    int keyIndex = i % keySequence.Length;
                    int decreasedASCII = line[i] - keySequence[keyIndex];
                    char newSymbol = (char)decreasedASCII;
                    sb.Append(newSymbol);
                }

                line = sb.ToString();

                int startIndexOfType = line.IndexOf('&') + 1;
                int endIndexOfType = line.LastIndexOf('&');
                string type = line.Substring(startIndexOfType, endIndexOfType - startIndexOfType);
                int startIndexOfCoordinates = line.IndexOf('<') + 1;
                int endIndexOfCoordinates = line.IndexOf('>');
                string coordinates = line.Substring(startIndexOfCoordinates, endIndexOfCoordinates - startIndexOfCoordinates);

                Console.WriteLine($"Found {type} at {coordinates}");
            }
        }
    }
}
