﻿using System;

namespace Elevator
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int p = int.Parse(Console.ReadLine());

            double courses = Math.Ceiling((double)n / p);

            Console.WriteLine((int)courses);
        }
    }
}