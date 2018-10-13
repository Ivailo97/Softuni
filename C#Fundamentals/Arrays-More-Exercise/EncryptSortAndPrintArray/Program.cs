using System;
using System.Linq;

namespace EncryptSortAndPrintArray
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            int[] nums = new int[n];

            char[] vowels = new char[] { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };

            for (int i = 0; i < n; i++)
            {
                string name = Console.ReadLine();
                int number = 0;
                char[] nameArr = name.ToCharArray();

                for (int j = 0; j < name.Length; j++)
                {

                    bool isVowel = VowelOrNot(vowels, nameArr[j]);

                    if (isVowel)
                    {
                        number += nameArr[j] * name.Length;
                    }
                    else
                    {
                        number += nameArr[j] / name.Length;
                    }

                    nums[i] = number;
                }
            }

            nums = nums.OrderBy(x => x).ToArray();

            foreach (int num in nums)
            {
                Console.WriteLine(num);
            }
        }

        private static bool VowelOrNot(char[] vowels, char letter)
        {
            bool isVowel = false;

            foreach (char vowel in vowels)
            {
                if (letter == vowel)
                {
                    isVowel = true;
                    break;
                }
            }

            return isVowel;
        }
    }
}
