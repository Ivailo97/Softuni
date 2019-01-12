using System;

namespace ExtractPersonInfo
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            for (int i = 0; i < n; i++)
            {
                string line = Console.ReadLine();
                int startNameIndex = line.IndexOf('@') + 1;
                int endNameIndex = line.IndexOf('|');
                string name = line.Substring(startNameIndex, endNameIndex - startNameIndex);
                int startAgeIndex = line.IndexOf('#') + 1;
                int endAgeIndex = line.IndexOf('*');
                int age = int.Parse(line.Substring(startAgeIndex, endAgeIndex - startAgeIndex));

                Console.WriteLine($"{name} is {age} years old.");
            }
        }
    }
}
