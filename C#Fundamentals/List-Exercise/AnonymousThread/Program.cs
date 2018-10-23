using System;
using System.Collections.Generic;
using System.Linq;

namespace AnonymousThreat
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            List<string> words = input.Split().ToList();
            string command = Console.ReadLine();

            while (command != "3:1")
            {
                string[] tokens = command.Split();
                string action = tokens[0];

                int value1 = int.Parse(tokens[1]);
                int value2 = int.Parse(tokens[2]);

                switch (action)
                {
                    case "merge":

                        GetMerged(words, value1, value2);
                        break;

                    case "divide":
                        GetDivide(words, value1, value2);
                        break;
                }

                command = Console.ReadLine();
            }

            Console.WriteLine(string.Join(" ", words));
        }

        public static void GetMerged(List<string> words, int startIndex, int endIndex)
        {
            string combined = "";

            if (startIndex > -1 && endIndex < words.Count)
            {
                for (int i = startIndex; i <= endIndex; i++)
                {
                    combined += words[i];
                }

                words.RemoveRange(startIndex + 1, endIndex - startIndex);
                words[startIndex] = combined;

            }
            else if (startIndex < 0 && endIndex < words.Count)
            {
                for (int i = 0; i <= endIndex; i++)
                {
                    combined += words[i];
                }

                words[0] = combined;
                words.RemoveRange(1, endIndex);

            }
            else if (startIndex > -1 && endIndex >= words.Count)
            {
                for (int i = startIndex; i < words.Count; i++)
                {
                    combined += words[i];
                }

                if (startIndex + 1 < words.Count)
                {
                    words.RemoveRange(startIndex + 1, words.Count - startIndex - 1);
                    words[startIndex] = combined;
                }
            }
            else
            {
                combined = string.Join("", words);
                words.Clear();
                words.Add(combined);
            }
        }

        public static void GetDivide(List<string> words, int index, int partitions)
        {
            string wordToDivide = words[index];

            char[] wordArr = wordToDivide.ToCharArray();
            int count = wordArr.Length / partitions;

            if (wordToDivide.Length % partitions == 0)
            {
                List<string> divided = new List<string>();

                string word = "";

                for (int i = 0; i < wordArr.Length; i++)
                {
                    word += wordArr[i];

                    if (word.Length == count)
                    {
                        divided.Add(word);
                        word = "";
                    }
                }

                words.RemoveAt(index);
                words.InsertRange(index, divided);
            }
            else
            {
                List<string> divided = new List<string>();

                string word = "";

                for (int i = 0; i < wordArr.Length; i++)
                {
                    word += wordArr[i];

                    if (word.Length == count && divided.Count < partitions - 1)
                    {
                        divided.Add(word);
                        word = "";
                    }
                    else if (i == wordArr.Length - 1)
                    {
                        divided.Add(word);

                    }
                }
                words.RemoveAt(index);
                words.InsertRange(index, divided);
            }
        }
    }
}

