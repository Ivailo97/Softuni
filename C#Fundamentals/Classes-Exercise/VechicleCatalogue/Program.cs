using System;
using System.Collections.Generic;

namespace VehicleCatalogue
{
    class Program
    {
        static void Main(string[] args)
        {
            List<Vehicle> catalogue = new List<Vehicle>();

            while (true)
            {
                string[] tokens = Console.ReadLine().Split();

                if (tokens[0] == "End")
                {
                    break;
                }

                string type = tokens[0];

                if (type.ToLower() == "truck")
                {
                    type = "Truck";
                }
                else
                {
                    type = "Car";
                }

                string model = tokens[1];
                string color = tokens[2];
                int horsePower = int.Parse(tokens[3]);

                Vehicle vehicle = new Vehicle()
                { Type = type, Model = model, Color = color, HorsePower = horsePower };

                catalogue.Add(vehicle);
            }

            while (true)
            {
                string model = Console.ReadLine();

                if (model == "Close the Catalogue")
                {
                    break;
                }

                Vehicle currentVehicle = catalogue.Find(x => x.Model == model);
                Console.WriteLine($"Type: {currentVehicle.Type}");
                Console.WriteLine($"Model: {currentVehicle.Model}");
                Console.WriteLine($"Color: {currentVehicle.Color}");
                Console.WriteLine($"Horsepower: {currentVehicle.HorsePower}");
            }

            double truckTotalHorsepower = 0;
            double totalTrucks = 0;
            double carTotalHorsepower = 0;
            double totalCars = 0;

            foreach (var vehicle in catalogue)
            {
                if (vehicle.Type == "Truck")
                {
                    totalTrucks++;
                    truckTotalHorsepower += vehicle.HorsePower;
                }
                else
                {
                    totalCars++;
                    carTotalHorsepower += vehicle.HorsePower;
                }
            }

            double averageTruckHorsepower = 0;
            double averageCarHorsepower = 0;

            if (truckTotalHorsepower != 0)
            {
                averageTruckHorsepower = truckTotalHorsepower / totalTrucks;
            }

            if (carTotalHorsepower != 0)
            {
                averageCarHorsepower = carTotalHorsepower / totalCars;
            }

            Console.WriteLine($"Cars have average horsepower of: {averageCarHorsepower:f2}.");
            Console.WriteLine($"Trucks have average horsepower of: {averageTruckHorsepower:f2}.");
        }
    }

    class Vehicle
    {
        public string Type { get; set; }
        public string Model { get; set; }
        public string Color { get; set; }
        public int HorsePower { get; set; }
    }
}
