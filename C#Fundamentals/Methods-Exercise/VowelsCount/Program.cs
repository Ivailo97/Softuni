using System;

namespace VowelsCount
{
    class Program
    {
        static void Main(string[] args)
        {
            string text = Console.ReadLine();
            PrintVowelsCount(text);
        }

        private static void PrintVowelsCount(string text)
        {
            char[] vowels = { 'a', 'e', 'i', 'o', 'u' };

            int count = 0;

            for (int i = 0; i < text.Length; i++)
            {
                char current = text[i];

                for (int k = 0; k < vowels.Length; k++)
                {
                    if (vowels[k] == current.ToString().ToLower()[0])
                    {
                        count++;
                    }
                }
            }

            Console.WriteLine(count);
        }
    }
}
