using System;

namespace PalindromeIntegers
{
    class Program
    {
        static void Main(string[] args)
        {
            string numAsString = Console.ReadLine();

            while (numAsString != "END")
            {
                IsPalindrome(numAsString);
                numAsString = Console.ReadLine();
            }
        }

        private static void IsPalindrome(string num)
        {
            bool isPalindrome = true;

            for (int i = 0; i < num.Length / 2; i++)
            {
                if (num[i] != num[num.Length - 1 -  i])
                {

                    isPalindrome = false;
                    break;
                }
            }

            Console.WriteLine(isPalindrome.ToString().ToLower());
        }
    }
}
