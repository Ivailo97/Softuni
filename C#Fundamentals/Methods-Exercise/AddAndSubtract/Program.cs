using System;

namespace AddAndSubtract
{
    class Program
    {
        static void Main(string[] args)
        {
            int num1 = int.Parse(Console.ReadLine());
            int num2 = int.Parse(Console.ReadLine());
            int num3 = int.Parse(Console.ReadLine());

            int sumFirstPair = GetSum(num1, num2);
            int result = Subtract(sumFirstPair,num3);

            Console.WriteLine(result);
        }

        private static int Subtract(int sumFirstPair,int num)
        {
            return sumFirstPair - num;
        }

        private static int GetSum(int num1, int num2)
        {
            return num1 + num2;
        }
    }
}
