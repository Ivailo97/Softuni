using System;
using System.Collections.Generic;
using System.Linq;

namespace Messaging
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> numbers = Console.ReadLine().Split().Select(int.Parse).ToList();
            string text = Console.ReadLine();

            foreach (int num in numbers)
            {
                int sum = 0;
                int number = num;

                while (number != 0)
                {
                    sum += number % 10;
                    number /= 10;
                }

                int index = sum % text.Length;
                Console.Write(text[index]);
                List<char> chars = text.ToCharArray().ToList();
                chars.RemoveAt(index);
                text = string.Join("", chars);
                
            }
            Console.WriteLine();
        }
    }
}
