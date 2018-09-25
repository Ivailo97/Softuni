using System;

namespace RageExpenses
{
    class Program
    {
        static void Main(string[] args)
        {
            int lostGames = int.Parse(Console.ReadLine());
            double headsetPrice = double.Parse(Console.ReadLine());
            double mousePrice = double.Parse(Console.ReadLine());
            double keyboardPrice = double.Parse(Console.ReadLine());
            double displayPrice = double.Parse(Console.ReadLine());

            int mouses = 0;
            int keyboards = 0;
            int displays = 0;
            int headset = 0;
            int countKeyboardTrashing = 0;

            for (int i = 1; i <= lostGames; i++)
            {
                if (i % 2 == 0)
                {
                    headset++;
                }
                if (i % 3 == 0)
                {
                    mouses++;
                }
                if (i % 2 == 0 && i % 3 == 0)
                {
                    keyboards++;
                    countKeyboardTrashing++;
                    if (countKeyboardTrashing % 2 == 0)
                    {
                        displays++;
                    }

                }

            }
            double totalPrice = mouses * mousePrice + displays * displayPrice + keyboards * keyboardPrice
                + headset * headsetPrice;
            Console.WriteLine($"Rage expenses: {totalPrice:f2} lv.");

        }
    }
}
