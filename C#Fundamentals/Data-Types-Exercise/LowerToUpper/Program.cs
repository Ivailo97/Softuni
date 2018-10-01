using System;

namespace LowerToUpper
{
    class Program
    {
        static void Main(string[] args)
        {
            string symbolOne = Console.ReadLine();
            string symbolTwo = Console.ReadLine();

            if (symbolOne.ToUpper() == symbolOne)
            {
                Console.WriteLine("upper-case");
            }
            else
            {
                Console.WriteLine("lower-case");
            }

        }
    }
}
