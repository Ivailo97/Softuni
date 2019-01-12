using System;
using System.Collections.Generic;
using System.Linq;

namespace SpeedRacing
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            List<Car> cars = new List<Car>();

            for (int i = 0; i < n; i++)
            {
                string[] data = Console.ReadLine().Split();
                string model = data[0];
                double fuel = double.Parse(data[1]);
                double fuelPerKm = double.Parse(data[2]);

                Car car = new Car(model, fuel, fuelPerKm);
                Car test = cars.FirstOrDefault(x => x.Model == model);

                if (test == null)
                {
                    cars.Add(car);
                }

            }

            while (true)
            {
                string line = Console.ReadLine();

                if (line == "End")
                {
                    break;
                }

                string[] data = line.Split();
                string model = data[1];
                int kmToDrive = int.Parse(data[2]);

                Car current = cars.FirstOrDefault(x => x.Model == model);

                if (current.CanTravel(kmToDrive))
                {
                    current.TraveledDistance += kmToDrive;
                    current.FuelAmount -= kmToDrive * current.FuelConsumptionPerKM;
                }
                else
                {
                    Console.WriteLine("Insufficient fuel for the drive");
                }
            }

            foreach (var car in cars)
            {
                Console.WriteLine($"{car.Model} {car.FuelAmount:f2} {car.TraveledDistance}");
            }
            
        }
    }

    class Car
    {
        public string Model { get; set; }
        public double FuelAmount { get; set; }
        public double FuelConsumptionPerKM { get; set; }
        public int TraveledDistance { get; set; }

        public Car(string model, double fuel, double fuelPerKM)
        {
            this.Model = model;
            this.FuelAmount = fuel;
            this.FuelConsumptionPerKM = fuelPerKM;
            this.TraveledDistance = 0;
        }

        public bool CanTravel(int distance)
        {
            return distance * FuelConsumptionPerKM <= FuelAmount;

        }
    }
}
