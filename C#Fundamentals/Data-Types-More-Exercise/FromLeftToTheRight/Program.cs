using System;
using System.Linq;
using System.Numerics;

namespace FromLeftToTheRight
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            for (int i = 0; i < n; i++)
            {
                string[] nums = Console.ReadLine().Split().ToArray();

                bool isInteger = BigInteger.TryParse(nums[0], out BigInteger result);
                bool isDecimal = decimal.TryParse(nums[0], out decimal resultDecimal);

                bool condiditon = true;

                if (isDecimal)
                {
                    condiditon = decimal.Parse(nums[0]) > decimal.Parse(nums[1]);
                }
                else if (isInteger)
                {
                    condiditon = BigInteger.Parse(nums[0]) > BigInteger.Parse(nums[1]);
                }

                if (condiditon)
                {
                    BigInteger sum = 0;

                    char[] numAsString = nums[0].ToCharArray();

                    for (int k = 0; k < numAsString.Length; k++)
                    {
                        try
                        {
                            sum += BigInteger.Parse(numAsString[k].ToString());
                        }
                        catch (Exception)
                        {

                            continue;
                        }
                    }

                    Console.WriteLine(sum);
                }
                else
                {
                    BigInteger sum = 0;

                    char[] numAsString = nums[1].ToCharArray();

                    for (int k = 0; k < numAsString.Length; k++)
                    {
                        try
                        {
                            sum += BigInteger.Parse(numAsString[k].ToString());
                        }
                        catch (Exception)
                        {

                            continue;
                        }
                    }

                    Console.WriteLine(sum);
                }
            }
        }
    }
}
