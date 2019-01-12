using System;
using System.Collections.Generic;
using System.Linq;

namespace RawData
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            List<Car> cars = new List<Car>();

            for (int i = 0; i < n; i++)
            {
                string[] rawData = Console.ReadLine().Split();
                string model = rawData[0];
                int engineSpeed = int.Parse(rawData[1]);
                int enginePower = int.Parse(rawData[2]);
                int cargoWeight = int.Parse(rawData[3]);
                string cargoType = rawData[4];

                Engine engine = new Engine(engineSpeed, enginePower);
                Cargo cargo = new Cargo(cargoType, cargoWeight);
                Car car = new Car(model, engine, cargo);
                cars.Add(car);
            }

            string command = Console.ReadLine();

            switch (command)
            {
                case "fragile":
                    foreach (var car in cars.Where(x => x.Cargo.Type == command && x.Cargo.Weight < 1000))
                    {
                        Console.WriteLine(car.Model);
                    }
                    break;
                case "flamable":
                    foreach (var car in cars.Where(x => x.Cargo.Type == command && x.Engine.Power > 250))
                    {
                        Console.WriteLine(car.Model);
                    }
                    break;
                default:
                    break;
            }
        }
    }

    class Car
    {
        public string Model { get; set; }
        public Engine Engine { get; set; }
        public Cargo Cargo { get; set; }

        public Car(string model, Engine engine, Cargo cargo)
        {
            this.Model = model;
            this.Engine = engine;
            this.Cargo = cargo;
        }
    }

    class Cargo
    {
        public string Type { get; set; }
        public int Weight { get; set; }

        public Cargo(string type, int weight)
        {
            this.Type = type;
            this.Weight = weight;

        }
    }

    class Engine
    {
        public int Speed { get; set; }
        public int Power { get; set; }

        public Engine(int speed, int power)
        {
            this.Speed = speed;
            this.Power = power;

        }
    }
}
