using System;
using System.Collections.Generic;
using System.Text;

namespace MorseCodeTranslator
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] encryptedWords = Console.ReadLine().Split(" | ");
            Dictionary<string, char> pairs = new Dictionary<string, char>();
            pairs.Add(".-", 'A');
            pairs.Add("-...", 'B');
            pairs.Add("-.-.", 'C');
            pairs.Add("-..", 'D');
            pairs.Add(".", 'E');
            pairs.Add("..-.", 'F');
            pairs.Add("--.", 'G');
            pairs.Add("....", 'H');
            pairs.Add("..", 'I');
            pairs.Add(".---", 'J');
            pairs.Add("-.-", 'K');
            pairs.Add(".-..", 'L');
            pairs.Add("--", 'M');
            pairs.Add("-.", 'N');
            pairs.Add("---", 'O');
            pairs.Add(".--.", 'P');
            pairs.Add("--.-", 'Q');
            pairs.Add(".-.", 'R');
            pairs.Add("...", 'S');
            pairs.Add("-", 'T');
            pairs.Add("..-", 'U');
            pairs.Add("...-", 'V');
            pairs.Add(".--", 'W');
            pairs.Add("-..-", 'X');
            pairs.Add("-.--", 'Y');
            pairs.Add("--..", 'Z');

            List<string> decryptedWords = new List<string>();

            for (int i = 0; i < encryptedWords.Length; i++)
            {

                StringBuilder sb = new StringBuilder();
                string[] letters = encryptedWords[i].Split(' ',StringSplitOptions.RemoveEmptyEntries);

                for (int j = 0; j < letters.Length; j++)
                {

                    sb.Append(pairs[letters[j]]);
                }

                decryptedWords.Add(sb.ToString());
            }

            Console.WriteLine(string.Join(" ",decryptedWords));
        }
    }
}
