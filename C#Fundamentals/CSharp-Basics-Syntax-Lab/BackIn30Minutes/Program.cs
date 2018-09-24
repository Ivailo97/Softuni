using System;

namespace BackIn30Minutes
{
    class Program
    {
        static void Main(string[] args)
        {
            int hours = int.Parse(Console.ReadLine());
            int minutes = int.Parse(Console.ReadLine()) + 30;

            int min = hours * 60 + minutes;
            int mins = min % 60;

            int h = min / 60;

            if (h > 23)
            {
                h -= 24;
            }

            if (mins < 10)
            {
                Console.WriteLine($"{h}:0{mins}");
            }
            else
            {
                Console.WriteLine($"{h}:{mins}");
            }
        }
    }
}
