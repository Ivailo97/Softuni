using System;

namespace ExtractFile
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] path = Console.ReadLine().Split('\\');

            string[] nameAndExt = path[path.Length - 1].Split('.');
            string name = nameAndExt[0];
            string ext = nameAndExt[1];

            Console.WriteLine($"File name: {name}");
            Console.WriteLine($"File extension: {ext}");

        }
    }
}
