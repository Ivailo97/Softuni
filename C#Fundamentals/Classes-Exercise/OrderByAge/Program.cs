using System;
using System.Collections.Generic;
using System.Linq;

namespace OrderByAge
{
    class Program
    {

        static void Main(string[] args)
        {
            List<Person> people = new List<Person>();

            while (true)
            {
                string line = Console.ReadLine();

                if (line == "End")
                {
                    break;
                }

                string[] data = line.Split();
                string name = data[0];
                string serialNumbr = data[1];
                int age = int.Parse(data[2]);

                Person person = new Person(name, serialNumbr, age);

                people.Add(person);
            }

            foreach (var unit in people.OrderBy(x => x.Age))
            {
                Console.WriteLine($"{unit.Name} with ID: {unit.SerialNumber} is {unit.Age} years old.");
            }
        }
    }

    class Person
    {
        public string Name { get; set; }
        public string SerialNumber { get; set; }
        public int Age { get; set; }

        public Person(string name, string serialNumber, int age)
        {
            this.Age = age;
            this.Name = name;
            this.SerialNumber = serialNumber;
        }
    }
}
