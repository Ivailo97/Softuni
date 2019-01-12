using System;
using System.Text;

namespace CaesarCipher
{
    class Program
    {
        static void Main(string[] args)
        {
            string line = Console.ReadLine();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < line.Length; i++)
            {
                char current = (char)(line[i] + 3);
                sb.Append(current);
            }

            Console.WriteLine(sb);
        }
    }
}
