using System;

namespace ReverseName
{
    class Program
    {
        static void Main(string[] args)
        {
            string word = Console.ReadLine();

            string reversed = "";

            for (int i = 0; i < word.Length; i++)
            {

                reversed += word[word.Length - 1 - i];

            }

            Console.WriteLine(reversed);
        }
    }
}
