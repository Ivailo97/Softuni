using System;

namespace RepeatString
{
    class Program
    {
        static void Main(string[] args)
        {

            string text = Console.ReadLine();
            int n = int.Parse(Console.ReadLine());

            Print(text, n);
        }

        private static void Print(String text, int n)
        {

            for (int i = 0; i < n; i++)
            {

                Console.Write(text);
            }
        }
    }
}



